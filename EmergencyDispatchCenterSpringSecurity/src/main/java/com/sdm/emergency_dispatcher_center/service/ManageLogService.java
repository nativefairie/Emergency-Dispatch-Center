package com.sdm.emergency_dispatcher_center.service;

import com.sdm.emergency_dispatcher_center.domain.Log;
import com.sdm.emergency_dispatcher_center.repository.LogRepository;
import com.sdm.emergency_dispatcher_center.repository.ReportRepository;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ManageLogService {

    public final LogRepository logRepository;
    public final UserRepository userRepository;
    public final ReportRepository reportRepository;

    @Autowired
    public ManageLogService(LogRepository logRepository, UserRepository userRepository, ReportRepository reportRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.reportRepository = reportRepository;
    }

    public Log createManageLog() {
        Log log = new Log();
        log.setCallingTime(new Date());

        logRepository.save(log);

        return log;
    }

    public List<LogDto> getManageLog(HttpServletRequest request) {
        List<Log> logs = logRepository.findLogsByOperation_AssignedUnit(request.getSession().getAttribute("user"));
        List<LogDto> jsonLogs = new ArrayList<LogDto>();
        for (Log l : logs) {
            jsonLogs.add(new LogDto(l));
        }
        return jsonLogs;
    }

}
