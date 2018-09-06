package com.sdm.emergency_dispatcher_center.repository;

import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.Log;
import com.sdm.emergency_dispatcher_center.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface LogRepository extends CrudRepository<Log, Integer> {
    public Log findLogById(Long id);
    public List<Log> findLogsByOperation_AssignedUnit(User user);
    List<Log> findLogsByOperation_AssignedUnit(EmergencyUnit emergencyUnit);
    List<Log> findLogsByOperation_AssignedUnit(String userName);

    List<Log> findLogsByOperation_AssignedUnit(Object user);
}
