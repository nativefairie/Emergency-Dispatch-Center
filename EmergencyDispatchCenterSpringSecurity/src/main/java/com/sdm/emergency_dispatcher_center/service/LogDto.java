package com.sdm.emergency_dispatcher_center.service;

import com.sdm.emergency_dispatcher_center.domain.Log;
import com.sdm.emergency_dispatcher_center.repository.LogRepository;
import com.sdm.emergency_dispatcher_center.repository.ReportRepository;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;

import java.util.Date;

public class LogDto {
    private boolean success = true;
    private Long id;
    private Date callingTime;
    private Date callingEndTime;
    private OperationDto operation;

    public LogDto(Log log) {
        this.id = log.getId();
        this.callingEndTime = log.getCallingEndTime();
        this.callingTime = log.getCallingTime();
        this.operation = log.getOperation() != null ? new OperationDto(log.getOperation()) : null;
    }

    public Log toLog(UserRepository userRepository, ReportRepository reportRepository, LogRepository logRepository) {
        return new Log(callingTime, callingEndTime, operation != null ? operation.toOperation(userRepository, reportRepository,
                logRepository) : null, id);
    }
}
