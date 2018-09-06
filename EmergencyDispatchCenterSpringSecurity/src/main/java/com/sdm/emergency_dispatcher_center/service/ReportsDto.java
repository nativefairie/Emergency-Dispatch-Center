package com.sdm.emergency_dispatcher_center.service;

import java.util.List;

public class ReportsDto {
    private List<ReportDto> reports;
    private boolean success = true;


    public ReportsDto(List<ReportDto> reports) {
        this.reports = reports;
    }
}
