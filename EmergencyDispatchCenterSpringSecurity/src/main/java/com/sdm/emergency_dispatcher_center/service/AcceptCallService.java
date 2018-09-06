package com.sdm.emergency_dispatcher_center.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdm.emergency_dispatcher_center.domain.Operation;
import com.sdm.emergency_dispatcher_center.repository.LogRepository;
import com.sdm.emergency_dispatcher_center.repository.OperationRepository;
import com.sdm.emergency_dispatcher_center.repository.ReportRepository;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AcceptCallService {

    private final OperationRepository operationRepository;
    private final LogRepository logRepository;
    private final UserRepository userRepository;
    private final ReportRepository reportRepository;

    @Autowired
    public AcceptCallService(OperationRepository operationRepository, LogRepository logRepository, UserRepository userRepository, ReportRepository reportRepository) {
        this.operationRepository = operationRepository;
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.reportRepository = reportRepository;
    }

    public void createAcceptCall(String body) {
        Gson gson = new GsonBuilder().create();
        Operation op = gson.fromJson(body, OperationDto.class).toOperation(userRepository, reportRepository, logRepository);

        op.getLog().setCallingEndTime(new Date());
        op.getLog().setOperation(op);

        operationRepository.save(op);
        logRepository.save(op.getLog());
    }

}
