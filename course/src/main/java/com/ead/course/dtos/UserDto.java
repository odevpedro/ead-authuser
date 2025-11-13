package com.ead.course.dtos;

import com.ead.course.enums.UserStatus;
import com.ead.course.enums.UserType;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class UserDto {
    private UUID userId;

    private String username;
    private String email;
    private String fullName;
    private String password;
    private UserStatus userStatus;
    private UserType userType;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;


}
