package project.bankapp.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.bankapp.bank.model.User;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String cpf;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
    private String gender;

    public static UserResponseDTO fromUser(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getCpf(),
            user.getName(),
            user.getEmail(),
            user.getPhone(),
            user.getBirthday(),
            user.getGender()
        );
    }
}
