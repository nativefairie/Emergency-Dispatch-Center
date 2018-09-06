package com.sdm.emergency_dispatcher_center.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.Report;
import com.sdm.emergency_dispatcher_center.repository.ReportRepository;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManageReportService {

    private final UserRepository userRepository;
    private final ReportRepository reportRepository;

    @Autowired
    public ManageReportService(UserRepository userRepository, ReportRepository reportRepository) {
        this.userRepository = userRepository;
        this.reportRepository = reportRepository;
    }

    public void createManageReport(HttpServletRequest request) {
        Gson gson = new GsonBuilder().create();

        Report report = null;
        try {
            report = gson.fromJson(request.getReader(), ReportDto.class).toReport(userRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }
        report.setLastModification(new Date());
        report.setLastUnit((EmergencyUnit) request.getSession().getAttribute("user"));

        reportRepository.save(report);
    }

    public List<ReportDto> getManageReport(HttpServletRequest request) {
        List<Report> reports = reportRepository.findReportsByLastUnit_UserName((EmergencyUnit) request.getSession().getAttribute("user"));
        List<ReportDto> jsonReports = new ArrayList<>();
        for (Report report : reports) {
            jsonReports.add(new ReportDto(report));
        }
        return jsonReports;
    }

}
