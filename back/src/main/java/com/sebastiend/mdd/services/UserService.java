package com.sebastiend.mdd.services;


import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.sebastiend.mdd.models.dto.Users.UserCreateDTO;
import com.sebastiend.mdd.models.dto.Users.UserResponseDTO;
import com.sebastiend.mdd.models.entities.UserEntity;
import com.sebastiend.mdd.repositories.UserRepository;
import lombok.Data;


@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    private JWTService jwtService;

    public UserService(JWTService jwtService) {
		this.jwtService = jwtService;
	}

    /* Register */
    public UserResponseDTO registerUser(@RequestBody UserCreateDTO data) {
        LocalDateTime currentDate = LocalDateTime.now();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(data.getPassword());

        UserEntity newUser = new UserEntity();
        newUser.setEmailAddress(data.getEmailAddress());
        newUser.setUsername(data.getUsername());
        newUser.setPassword(password);
        newUser.setCreatedAt(currentDate);
        newUser.setUpdatedAt(currentDate);
        userRepository.save(newUser); 
        return new UserResponseDTO("Le compte a bien été crée");
    }
}
