package com.sdm.emergency_dispatcher_center.service;


import javax.jnlp.UnavailableServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdm.emergency_dispatcher_center.domain.User;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authorization(HttpServletRequest request) {
        Gson gson = new GsonBuilder().create();
        User user = null;
        try {
            user = gson.fromJson(request.getReader(), UserDto.class).toUser();
        } catch (IOException e) {
            e.printStackTrace();
        }

        user = userRepository.findUserByEmail(user.getEmail());
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return user;
        }
        return null;
    }

}
