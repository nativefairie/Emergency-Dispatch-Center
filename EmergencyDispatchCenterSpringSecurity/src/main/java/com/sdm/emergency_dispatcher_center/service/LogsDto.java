package com.sdm.emergency_dispatcher_center.service;

import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.Operation;
import com.sdm.emergency_dispatcher_center.repository.LogRepository;
import com.sdm.emergency_dispatcher_center.repository.ReportRepository;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogsDto {
    public static class Workload {
        private UserDto user;
        private int amount;

        public Workload(UserDto user, int amount) {
            this.user = user;
            this.amount = amount;
        }
    }

    private boolean success = true;
    private List<LogDto> logs;

    private int countOfCallsFire;
    private int countOfCallsMedical;
    private int countOfCallsPolice;
    private int countOfCallsTotal;

    private List<Workload> workload;

    public LogsDto(List<LogDto> jsonLogs, UserRepository userRepository, ReportRepository reportRepository, LogRepository logRepository) {
        this.logs = jsonLogs;

        workload = new ArrayList<>();

        countOfCallsTotal = jsonLogs.size();

        countOfCallsFire = 0;
        countOfCallsMedical = 0;
        countOfCallsPolice = 0;

        Map<EmergencyUnit, Integer> counts = new HashMap<>();

        for (LogDto jsonLog : jsonLogs) {
            Operation operation = jsonLog.toLog(userRepository, reportRepository, logRepository).getOperation();
            if (operation != null) {
                switch (operation.getType()) {
                    case FireEmergency:
                        countOfCallsFire++;
                        break;
                    case MedicalEmergency:
                        countOfCallsMedical++;
                        break;
                    case PoliceEmergency:
                        countOfCallsPolice++;
                        break;
                }

                if (operation.getAssignedUnit() != null) {
                    if (!counts.containsKey(operation.getAssignedUnit())) {
                        counts.put(operation.getAssignedUnit(), 0);
                    }
                    counts.put(operation.getAssignedUnit(), 1 + counts.get(operation.getAssignedUnit()));
                }
            }
        }

        for (EmergencyUnit unit : counts.keySet()) {
            Integer count = counts.get(unit);
            workload.add(new Workload(new UserDto(unit), count));
        }
    }
}
