package emora.database.aspect;

import emora.database.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import emora.database.domain.SystemLog;
import emora.database.domain.User;
import emora.database.service.SystemlogService;
import org.apache.shiro.SecurityUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAscept {
    @Resource
    private SystemlogService systemlogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(emora.database.annotation.Log)")
    public void pointcut() { }

    @AfterReturning("pointcut()")
    public void saveSysLog(JoinPoint joinPoint){
        // 保存日志
        SystemLog systemLog = new SystemLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        Log logannotation = method.getAnnotation(Log.class);
        if (logannotation != null){
            String value = logannotation.value();
            systemLog.setDescribes(value);   // 保存获取的操作
        }

        // 获取请求类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求方法名
        String methodName = method.getName();
        // 设置请求方法日志
        systemLog.setMethod(className + "." + methodName + "()");

        User user = (User)SecurityUtils.getSubject().getPrincipal();
        String username = user.getUsername();
        // 设置执行操作的用户名
        systemLog.setUsername(username);

        // 设置操作时间
        Date date = new Date();
        systemLog.setTime(date);

        systemlogService.addSystemlog(systemLog);
    }
}
