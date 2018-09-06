package com.sdm.emergency_dispatcher_center.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdm.emergency_dispatcher_center.domain.CustomUserDetails;
import com.sdm.emergency_dispatcher_center.domain.User;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Qualifier("userRepository")
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findUserByUserName(username);

    optionalUser
      .orElseThrow(() ->new UsernameNotFoundException("User not found"));

    return optionalUser
      .map(CustomUserDetails::new).get();
  }
}
