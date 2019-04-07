package me.psalguero.student.services.impl;

import me.psalguero.student.entities.CustomUserDetails;
import me.psalguero.student.entities.User;
import me.psalguero.student.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findByName(username);
    optionalUser
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    return optionalUser
        .map(CustomUserDetails::new).get();
  }
}
