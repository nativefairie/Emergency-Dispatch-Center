package com.sdm.emergency_dispatcher_center.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.Report;
import com.sdm.emergency_dispatcher_center.domain.User;

@Repository
@Transactional
public interface ReportRepository extends CrudRepository<Report, Integer> {
    public Report findReportById(long id);
    public List <Report> findReportsByLastUnit_UserName(EmergencyUnit emergencyUnit);

}