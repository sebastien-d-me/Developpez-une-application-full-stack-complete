package com.sebastiend.mdd.models.dto.Users;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@Data
public class UserUpdateDTO {
    @JsonProperty("id_users")
    private Integer userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("password")
    private String password;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
