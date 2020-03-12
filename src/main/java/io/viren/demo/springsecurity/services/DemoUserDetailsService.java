package io.viren.demo.springsecurity.services;

import io.viren.demo.springsecurity.entities.User;
import io.viren.demo.springsecurity.repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class DemoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DemoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userOptional = this.userRepository.findByName(userName);
        return userOptional.map(DemoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Na Mila"));
    }
}
