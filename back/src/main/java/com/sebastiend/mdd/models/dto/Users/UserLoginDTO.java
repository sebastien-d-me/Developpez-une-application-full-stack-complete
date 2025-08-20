package com.sebastiend.mdd.models.dto.Users;


import lombok.*;


@AllArgsConstructor
@Data
public class UserLoginDTO {
    private String usernameOrMail;
    private String password;
}
