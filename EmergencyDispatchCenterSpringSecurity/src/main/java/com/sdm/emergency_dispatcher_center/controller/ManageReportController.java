package com.sdm.emergency_dispatcher_center.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdm.emergency_dispatcher_center.service.ManageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdm.emergency_dispatcher_center.service.ReportDto;
import com.sdm.emergency_dispatcher_center.service.ReportsDto;
import com.sdm.emergency_dispatcher_center.service.StatusResponseDto;
import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;


@RestController
@RequestMapping("/manageReport")
public class ManageReportController {

    private ManageReportService manageReportService;

    @PostMapping
    public void createManageReport(HttpServletRequest request, HttpServletResponse response) {

        if (request.getUserPrincipal() != null && request.getUserPrincipal() instanceof EmergencyUnit) {
            manageReportService.createManageReport(request);

            new StatusResponseDto(true);
            return;
        }

        new StatusResponseDto(false);
    }

    @GetMapping
    public void getManageReport(HttpServletRequest request, HttpServletResponse response) {
        if (request.getUserPrincipal() != null) {
            List<ReportDto> jsonReports = manageReportService.getManageReport(request);

            new ReportsDto(jsonReports);
            return;
        }

        new StatusResponseDto(false);
    }
}
