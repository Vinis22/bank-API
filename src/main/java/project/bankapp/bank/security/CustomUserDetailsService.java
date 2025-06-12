package project.bankapp.bank.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.bankapp.bank.model.User;
import project.bankapp.bank.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;

@Service
@Primary
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByCpf(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
} 