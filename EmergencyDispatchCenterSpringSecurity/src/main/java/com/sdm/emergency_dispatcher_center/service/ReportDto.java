package com.sdm.emergency_dispatcher_center.service;

import com.sdm.emergency_dispatcher_center.domain.Report;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;

import java.util.Date;

public class ReportDto {
    private boolean success = true;
    private Long id;
    private String reportText;
    private Date lastModification;
    private Long lastUnitId;
    private String userName;

    public ReportDto(Report report) {
        this.id = report.getId();
        this.reportText = report.getText();
        this.lastModification = report.getLastModification();
        try {
            this.lastUnitId = report.getLastUnit().getId();
            this.userName = report.getLastUnit().getUserName();
        } catch (Exception ex) {

        }
    }

    public Report toReport(UserRepository userRepository) {
        return new Report(reportText, lastModification, lastUnitId != null ? userRepository.findEmergencyUnitById(lastUnitId) : null, id);
    }
}
