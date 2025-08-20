package com.sebastiend.mdd.services;


import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.sebastiend.mdd.models.dto.Users.*;
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
    public UserCreateResponseDTO registerUser(@RequestBody UserCreateDTO data) {
        // Check if there is content
        if(data.getEmailAddress() == "" || data.getUsername() == "" || data.getPassword() == "") {
            throw new IllegalArgumentException("Tous les champs doivent être remplis.");
        }

        // Check if the username already exist
        UserEntity usernameCheck = userRepository.findByUsername(data.getUsername());
        if(usernameCheck != null) {
            throw new IllegalArgumentException("Un compte existe déjà avec ce nom d'utilisateur.");
        }

        // Check if the email already exist
        UserEntity emailCheck = userRepository.findByEmailAddress(data.getEmailAddress());
        if(emailCheck != null) {
            throw new IllegalArgumentException("Un compte existe déjà avec cette adresse email.");
        }

        // Check the password security
        String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        if(!data.getPassword().matches(regexPassword)) {
            throw new IllegalArgumentException("Le mot de passe doit contenir minimum 8 caractères, une majuscule, une minuscule et un caractère spécial.");
        }

        // Get the current date
        LocalDateTime currentDate = LocalDateTime.now();

        // Encrypt the password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(data.getPassword());

        // Save the data
        UserEntity newUser = new UserEntity();
        newUser.setEmailAddress(data.getEmailAddress());
        newUser.setUsername(data.getUsername());
        newUser.setPassword(password);
        newUser.setCreatedAt(currentDate);
        newUser.setUpdatedAt(currentDate);
        userRepository.save(newUser); 

        // Return a message
        return new UserCreateResponseDTO("Le compte a bien été créé.");
    }


    /* Login */
    public UserTokenResponseDTO loginUser(UserLoginDTO userLogin) throws AuthenticationException {
        // Check if there is content
        String usernameOrEmail = userLogin.getUsernameOrMail();
        String password = userLogin.getPassword();
        if(usernameOrEmail == "" || password == "") {
            throw new IllegalArgumentException("Tous les champs doivent être remplis.");
        }

        // Check if the user exist
        UserEntity userCheckExist = userRepository.findByEmailAddress(usernameOrEmail);
        if (userCheckExist == null) {
            userCheckExist = userRepository.findByUsername(usernameOrEmail);
        }
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Aucun utilisateur n'existe avec cet identifiant.");
        }

        // Check if the password is correct
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordCheckSame = userCheckExist.getPassword();
        if(passwordEncoder.matches(password, passwordCheckSame)) {
            String token = jwtService.generateToken(userCheckExist);
            return new UserTokenResponseDTO(token);
        } else {
            throw new IllegalArgumentException("Le mot de passe est incorrect.");
        }
    }


    /* Get user details */
    public Optional<UserDTO> getDetails() {
        // Check if logged
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Le compte n'existe pas.");
        } 

        // Return the details
        Integer userId = userCheckExist.getUserId();
        return userRepository.findById(userId).map(data -> UserDTO.convertDTO(userCheckExist)); 
    }


    /* Update details */
    public void updateUser(UserUpdateDTO data) {
        // Check if logged
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);

        // Check if there is content filled
        if(data.getEmailAddress() == "" && data.getUsername() == "" && data.getPassword() == "") {
            throw new IllegalArgumentException("Aucune modification n'a été effectué.");
        }
        
        // Check if the email already exist
        UserEntity emailUser = userRepository.findByEmailAddress(data.getEmailAddress());
        if(emailUser != null && !emailUser.getUserId().equals(userCheckExist.getUserId())) {
            throw new IllegalArgumentException("Un compte existe déjà avec cet email.");
        }

        // Check if the username already exist
        UserEntity usernameUser = userRepository.findByUsername(data.getUsername());
        if(usernameUser != null && !usernameUser.getUserId().equals(userCheckExist.getUserId())) {
            throw new IllegalArgumentException("Un compte existe déjà avec ce nom d'utilisateur.");
        }

        // Get the current date
        LocalDateTime currentDate = LocalDateTime.now();

        // Check if the username is filled
        if(data.getUsername() != null && !data.getUsername().isBlank()) {
            userCheckExist.setUsername(data.getUsername());
        }

        // Check if the email is filled
        if(data.getEmailAddress() != null && !data.getEmailAddress().isBlank()) {
            userCheckExist.setEmailAddress(data.getEmailAddress());
        }
        
        // Check if the password is filled
        if(data.getPassword() != null && !data.getPassword().isBlank()) {
            // Check the password security
            String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
            if(!data.getPassword().matches(regexPassword)) {
                throw new IllegalArgumentException("Le mot de passe doit contenir minimum 8 caractères, une majuscule, une minuscule et un caractère spécial.");
            } else {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String password = passwordEncoder.encode(data.getPassword());
                userCheckExist.setPassword(password);
            }
        }

        // Save the data
        userCheckExist.setUpdatedAt(currentDate);
        userRepository.save(userCheckExist);
    }
}
