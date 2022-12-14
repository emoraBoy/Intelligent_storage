package emora.database;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@MapperScan("emora.database.dao")
@SpringBootApplication
public class IntelligentStorageApplication {
    private static final Logger LOG = LoggerFactory.getLogger(IntelligentStorageApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(IntelligentStorageApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("智能仓储系统启动成功！");
        LOG.info("地址：\thttp://127.0.0.1:{}", env.getProperty("server.port"));

    }


}
