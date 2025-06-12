package project.bankapp.bank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.bankapp.bank.model.User;
import project.bankapp.bank.model.UserCredential;
import project.bankapp.bank.repository.UserRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public ResponseEntity<?> login(String cpf, String password) {
        try {
            log.info("Starting authentication for CPF: {}", cpf);

            User user = userRepository.findByCpf(cpf)
                    .orElseThrow(() -> {
                        log.warn("User not found for CPF: {}", cpf);
                        return new RuntimeException("User or password invalid.");
                    });

            UserCredential credentials = user.getCredentials();

            if (!passwordEncoder.matches(password, credentials.getPassword())) {
                log.warn("Invalid password for CPF: {}", cpf);
                throw new RuntimeException("User or password invalid.");
            }

            String token = jwtService.generateToken(cpf);

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("message", "Token generated successfully");
            response.put("token", token);


            log.info("Token generated successfully for CPF: {}", cpf);

            return ResponseEntity.ok()
                    .header("Authorization", "Bearer " + token)
                    .body(response);

        } catch (RuntimeException e) {
            log.warn("Authentication failed: {}", e.getMessage());
            return ResponseEntity.status(401).body(Map.of(
                    "error", "Authentication failed",
                    "message", e.getMessage()
            ));
        } catch (Exception e) {
            log.error("Internal error during authentication", e);
            return ResponseEntity.status(500).body(Map.of(
                    "error", "Internal error",
                    "message", "An error occurred during authentication."));
        }
    }

    public static class InvalidCredentialsException extends RuntimeException {
        public InvalidCredentialsException(String message) {
            super(message);
        }
    }
}
