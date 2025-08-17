package com.sebastiend.mdd.models.dto.Users;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


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


    /* Convert to DTO */
    public static UserUpdateDTO convertDTO(UserEntity entity) {
        return new UserUpdateDTO(
            entity.getUserId(),
            entity.getUsername(),
            entity.getEmailAddress(),
            entity.getPassword(),
            entity.getUpdatedAt()
        );
    }
}
