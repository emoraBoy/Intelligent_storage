package emora.database.service;

import org.springframework.stereotype.Service;
import emora.database.dao.SystemlogDao;
import emora.database.domain.SystemLog;

import java.util.List;

@Service
public class SystemlogService {
    private final SystemlogDao systemlogDao;

    public SystemlogService(SystemlogDao systemlogDao){this.systemlogDao = systemlogDao;}

    public void addSystemlog(SystemLog systemLog){systemlogDao.addSystemlog(systemLog);}

    public List<SystemLog> getAllSystemlogs(){return systemlogDao.getAllSystemlogs();}

    public List<SystemLog> getLogByUsername(String username) {return systemlogDao.getLogByUsername(username);}

    public List<SystemLog> getLogByDatetime(String time) {return systemlogDao.getLogByDatetime(time);}

}
