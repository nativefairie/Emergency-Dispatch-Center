package com.sdm.emergency_dispatcher_center.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdm.emergency_dispatcher_center.service.ManageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdm.emergency_dispatcher_center.domain.Log;
import com.sdm.emergency_dispatcher_center.service.LogDto;
import com.sdm.emergency_dispatcher_center.service.LogsDto;
import com.sdm.emergency_dispatcher_center.service.StatusResponseDto;

@RestController
@RequestMapping("/manageLog")
public class ManageLogController {

    private ManageLogService manageLogService;

    @PostMapping
    public void createManageLog(HttpServletRequest request, HttpServletResponse response) {

        if (request.getUserPrincipal() != null) {
            Log log = manageLogService.createManageLog();

            new LogDto(log);
            return;
        }

        new StatusResponseDto(false);
    }

    @GetMapping
    public void getManageLog(HttpServletRequest request, HttpServletResponse response) {

        if (request.getUserPrincipal() != null) {
            List<LogDto> jsonLogs = manageLogService.getManageLog(request);

            new LogsDto(jsonLogs, manageLogService.userRepository, manageLogService.reportRepository, manageLogService.logRepository);
            return;
        }

        new StatusResponseDto(false);
    }

}
