package com.sdm.emergency_dispatcher_center.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdm.emergency_dispatcher_center.service.AcceptCallService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdm.emergency_dispatcher_center.domain.Dispatcher;
import com.sdm.emergency_dispatcher_center.service.StatusResponseDto;

@RestController
@RequestMapping("/acceptCall")
public class AcceptCallController {

    private AcceptCallService acceptCallService;

    @PostMapping
    public void createAcceptCall(HttpServletRequest request, HttpServletResponse response) {

        if (request.getRemoteUser()!= null && (request.getUserPrincipal() instanceof Dispatcher)) {

            acceptCallService.createAcceptCall(request.getRemoteUser());
            new StatusResponseDto(true);
        }
        new StatusResponseDto(false);
    }
}
