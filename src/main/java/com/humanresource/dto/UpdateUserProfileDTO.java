package com.humanresource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserProfileDTO {
    private String firstName;
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    private String phone;
    private String address;
    private LocalDateTime dateOfBirth;
    private String department;
    private String position;
}
