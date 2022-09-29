package emora.database.dao;

import emora.database.domain.SystemLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemlogDao {
    void addSystemlog(SystemLog systemLog);
    List<SystemLog> getAllSystemlogs();
    List<SystemLog> getLogByUsername(String username);
    List<SystemLog> getLogByDatetime(String time);
}
