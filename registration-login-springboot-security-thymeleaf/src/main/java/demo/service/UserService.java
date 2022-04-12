package demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import demo.model.User;
import demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
