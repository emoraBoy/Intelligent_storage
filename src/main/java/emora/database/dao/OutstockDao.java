package emora.database.dao;

import emora.database.domain.Outstock;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OutstockDao {
    List<Outstock> getAllOutstocks();

    Outstock getOutstockById(Integer id);

    void updateOutstock(Outstock outstock);

    void addOutstock(Outstock outstock);

    List<Outstock> getOutstockByPid(Integer pid);

    List<Outstock> getOutstockByRid(Integer rid);

    List<Outstock> getOutstockByTime(Date time);

    void deleteManyOutstocks(List<Integer> ids);

    void deleteOneOutstock(Integer id);
}
