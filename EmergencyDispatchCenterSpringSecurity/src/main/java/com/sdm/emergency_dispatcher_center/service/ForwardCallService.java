package com.sdm.emergency_dispatcher_center.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.Operation;
import com.sdm.emergency_dispatcher_center.domain.Report;
import com.sdm.emergency_dispatcher_center.repository.LogRepository;
import com.sdm.emergency_dispatcher_center.repository.OperationRepository;
import com.sdm.emergency_dispatcher_center.repository.ReportRepository;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ForwardCallService {

    private final OperationRepository operationRepository;
    private final ReportRepository reportRepository;
    private final LogRepository logRepository;
    private final UserRepository userRepository;

    @Autowired
    public ForwardCallService(OperationRepository operationRepository, ReportRepository reportRepository, LogRepository logRepository, UserRepository userRepository) {
        this.operationRepository = operationRepository;
        this.reportRepository = reportRepository;
        this.logRepository = logRepository;
        this.userRepository = userRepository;
    }

    public void createForwardCall(HttpServletRequest request) {
        Gson gson = new GsonBuilder().create();
        Operation op = null;
        try {
            op = gson.fromJson(request.getReader(), OperationDto.class).toOperation(userRepository,
                    reportRepository, logRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }

        op.setAssignedUnit((EmergencyUnit) request.getSession().getAttribute("user"));
        op.setStartTime(new Date());

        operationRepository.save(op);
    }

    public Report updateForwardCall(HttpServletRequest request) {
        Gson gson = new GsonBuilder().create();

        Operation op = null;
        try {
            op = gson.fromJson(request.getReader(), OperationDto.class).toOperation(userRepository,
                    reportRepository, logRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Report report = new Report("", new Date(), op.getAssignedUnit(), null);
        op.setReport(report);
        op.setEndTime(new Date());

        reportRepository.save(report);
        operationRepository.save(op);

        return report;
    }

    public List<OperationDto> getForwardCall(HttpServletRequest request) {
        List<Operation> operations = operationRepository.findOperationByAssignedUnit(
                (EmergencyUnit) request.getSession().getAttribute("user"));
        operations.sort(Comparator.comparingInt(o -> o.getPriority().getEmergencyPriority()));
        List<OperationDto> jsonOperations = new ArrayList<>();
        for (Operation op : operations) {
            jsonOperations.add(new OperationDto(op));
        }

        return jsonOperations;
    }

}
