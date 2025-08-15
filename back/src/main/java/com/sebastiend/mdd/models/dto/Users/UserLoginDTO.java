package com.sebastiend.mdd.models.dto.Users;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class UserLoginDTO {
    private String usernameOrMail;
    private String password;
}
