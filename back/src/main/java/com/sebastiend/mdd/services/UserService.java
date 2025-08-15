package com.sebastiend.mdd.services;


import java.time.LocalDateTime;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.sebastiend.mdd.models.dto.Users.UserCreateDTO;
import com.sebastiend.mdd.models.dto.Users.UserDTO;
import com.sebastiend.mdd.models.dto.Users.UserLoginDTO;
import com.sebastiend.mdd.models.dto.Users.UserResponseDTO;
import com.sebastiend.mdd.models.dto.Users.UserTokenResponseDTO;
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


    /* Login */
    public UserTokenResponseDTO loginUser(UserLoginDTO userLogin) throws AuthenticationException {
        String usernameOrEmail = userLogin.getUsernameOrMail();
        String password = userLogin.getPassword();

        if(usernameOrEmail == null || password == null) {
            throw new IllegalArgumentException("Some fields are empty");
        }

        UserEntity userCheckExist = userRepository.findByEmailAddress(usernameOrEmail);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("User no exist");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordCheckSame = userCheckExist.getPassword();

        if(passwordEncoder.matches(password, passwordCheckSame)) {
            String token = jwtService.generateToken(userCheckExist);
            return new UserTokenResponseDTO(token);
        } else {
            throw new IllegalArgumentException("Passowrd is incorrect");
        }
    }


    /* Get actual user */
    public UserDTO getMe() {
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.findByEmailAddress(jwt);
        return UserDTO.convertDTO(user);
    }
}
