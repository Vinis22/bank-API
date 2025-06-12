package project.bankapp.bank.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bankapp.bank.dto.FinancialInfoDTO;
import project.bankapp.bank.dto.UserDTO;
import project.bankapp.bank.model.User;
import project.bankapp.bank.service.AgencyService;
import project.bankapp.bank.service.UserService;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;
    private final AgencyService agencyService;

    public UserController(UserService userService, AgencyService agencyService) {
        this.userService = userService;
        this.agencyService = agencyService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUserWithAgency(@Valid @RequestBody UserDTO userDTO) {
        log.info("Receiving request to create user: {}", userDTO);

        try {
            User createdUser = userService.createUserWithAgency(userDTO, userDTO.getAgencyId());
            log.info("User created successfully: {}", createdUser);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception ex) {
            log.error("Error creating user: {}", ex.getMessage(), ex);
            throw ex;
        }
    }

    @GetMapping("/by-cpf")
    public ResponseEntity<User> getUserByCpf(@RequestParam String cpf) {
        log.info("Searching for user by CPF: {}", cpf);
        return ResponseEntity.ok(userService.findUserByCpf(cpf));
    }

    @PostMapping("/{userId}/update-financial-info")
    public ResponseEntity<Void> updateFinancialInfo(
            @PathVariable Long userId,
            @Valid @RequestBody FinancialInfoDTO dto
    ) {
        log.info("Updating user financial information with ID: {}", userId);
        userService.updateFinancialInfo(userId, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}