package com.sdm.emergency_dispatcher_center.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.Operation;

@Repository
@Transactional
public interface OperationRepository extends CrudRepository<Operation, Integer> {

    public List<Operation> findOperationByAssignedUnit(EmergencyUnit user);
    public Operation findOperationById(long operationId);
}
