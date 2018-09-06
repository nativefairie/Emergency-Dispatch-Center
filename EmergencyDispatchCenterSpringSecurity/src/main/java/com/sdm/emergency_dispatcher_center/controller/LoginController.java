package com.sdm.emergency_dispatcher_center.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdm.emergency_dispatcher_center.domain.*;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import com.sdm.emergency_dispatcher_center.service.LoginService;
import com.sdm.emergency_dispatcher_center.service.StatusResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@RestController
public class LoginController {
//    User u1 = new Dispatcher("cristinaf", "83592796bc17705662dc9a750c8b6d0a4fd93396", "floroiu.cristina@gmail.com", 0);
//    User u2 = new EmergencyUnit(OperationType.FireEmergency, "andraevs@gmail.com", "83592796bc17705662dc9a750c8b6d0a4fd93396", "andreiv", 1);
//    UserRepository userRepository;
//
//    public void SaveUsersForLogin(){
//        userRepository.save(u1);
//        userRepository.save(u2);
//        System.out.println("dfkjsdfkjaerjkfaer");
//    }

//    private final LoginService loginService;
//
//    @Autowired
//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    @PostMapping
//    public void authorization(HttpServletRequest request, HttpServletResponse response) {
//        Gson gson = new GsonBuilder().create();
//        User user = loginService.authorization(request);
//        if (user != null) {
//            try {
//                request.authenticate((HttpServletResponse) user);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
//    }
}