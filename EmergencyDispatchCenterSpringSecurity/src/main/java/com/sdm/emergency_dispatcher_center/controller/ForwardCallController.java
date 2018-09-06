package com.sdm.emergency_dispatcher_center.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.Report;
import com.sdm.emergency_dispatcher_center.service.ForwardCallService;
import com.sdm.emergency_dispatcher_center.service.OperationDto;
import com.sdm.emergency_dispatcher_center.service.OperationsDto;
import com.sdm.emergency_dispatcher_center.service.ReportDto;
import com.sdm.emergency_dispatcher_center.service.StatusResponseDto;


@RestController
@RequestMapping("/forwardCall")
public class ForwardCallController {

    private ForwardCallService forwardCallService;

    @PostMapping
    public void createForwardCall(HttpServletRequest request, HttpServletResponse response) {

        if (request.getSession().getAttribute("user") != null && (request.getUserPrincipal() instanceof EmergencyUnit)) {
            forwardCallService.createForwardCall(request);
            new StatusResponseDto(true);
            return;
        }

        new StatusResponseDto(false);
    }

    @PutMapping
    public void updateForwardCall(HttpServletRequest request, HttpServletResponse response) {

        if (request.getUserPrincipal() != null && (request.getUserPrincipal() instanceof EmergencyUnit)) {
            Report report = forwardCallService.updateForwardCall(request);

            new ReportDto(report);
            return;
        }

       new StatusResponseDto(false);
    }

    @GetMapping
    public void getForwardCall(HttpServletRequest request, HttpServletResponse response) {
        if (request.getUserPrincipal() != null && (request.getUserPrincipal() instanceof EmergencyUnit)) {         List<OperationDto> jsonOperations = forwardCallService.getForwardCall(request);

            new OperationsDto(jsonOperations);
            return;
        }

        new StatusResponseDto(false);
    }
}