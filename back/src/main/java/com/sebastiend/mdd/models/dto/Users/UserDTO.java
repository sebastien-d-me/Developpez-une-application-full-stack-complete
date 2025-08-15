package com.sebastiend.mdd.models.dto.Users;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebastiend.mdd.models.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class UserDTO {
    @JsonProperty("id_users")
    private Integer id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email_address")
    private String email;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    

    /* Convert to DTO */
    public static UserDTO convertDTO(UserEntity entity) {
        return new UserDTO(
            entity.getUserId(),
            entity.getUsername(),
            entity.getEmailAddress(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
