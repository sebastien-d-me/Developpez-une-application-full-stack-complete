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
        // Vérifie si les champs sont vides
        if(data.getEmailAddress() == "" || data.getUsername() == "" || data.getPassword() == "") {
            throw new IllegalArgumentException("Tous les champs doivent être remplis.");
        }

        // Vérifie si l'utilisateur existe déjà
        UserEntity usernameCheck = userRepository.findByUsername(data.getUsername());
        if(usernameCheck != null) {
            throw new IllegalArgumentException("Un compte existe déjà avec ce nom d'utilisateur.");
        }

        // Vérifie si l'email existe déjà
        UserEntity emailCheck = userRepository.findByEmailAddress(data.getEmailAddress());
        if(emailCheck != null) {
            throw new IllegalArgumentException("Un compte existe déjà avec cette adresse email.");
        }

        // Vérifie le mot de passe (longueur + sécurité)
        String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        if(!data.getPassword().matches(regexPassword)) {
            throw new IllegalArgumentException("Le mot de passe doit contenir minimum 8 caractères, une majuscule, une minuscule et un caractère spécial.");
        }

        // Récupère la date actuelle
        LocalDateTime currentDate = LocalDateTime.now();

        // Crypte le MDP
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(data.getPassword());

        // Enregistre l'utilisateur
        UserEntity newUser = new UserEntity();
        newUser.setEmailAddress(data.getEmailAddress());
        newUser.setUsername(data.getUsername());
        newUser.setPassword(password);
        newUser.setCreatedAt(currentDate);
        newUser.setUpdatedAt(currentDate);
        userRepository.save(newUser); 

        // Retourne un message de confirmation
        return new UserCreateResponseDTO("Le compte a bien été crée.");
    }


    /* Login */
    public UserTokenResponseDTO loginUser(UserLoginDTO userLogin) throws AuthenticationException {
        // Vérifie si les champs sont vides
        String usernameOrEmail = userLogin.getUsernameOrMail();
        String password = userLogin.getPassword();
        if(usernameOrEmail == "" || password == "") {
            throw new IllegalArgumentException("Tous les champs doivent être remplis.");
        }

        // Vérifie si l'utilisateur existe (email puis utilisateur au cas où)
        UserEntity userCheckExist = userRepository.findByEmailAddress(usernameOrEmail);
        if (userCheckExist == null) {
            userCheckExist = userRepository.findByUsername(usernameOrEmail);
        }
        if(userCheckExist == null) {
            throw new IllegalArgumentException("Aucun utilisateur n'existe avec cet identifiant.");
        }

        // Vérifie si le mot de passe est le bon
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
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);
        if(userCheckExist == null) {
            throw new IllegalArgumentException("The user not exist");
        } 

        Integer userId = userCheckExist.getUserId();

        return userRepository.findById(userId).map(data -> UserDTO.convertDTO(userCheckExist)); 
    }


    /* Update details */
    public void updateUser(UserUpdateDTO data) {
        String jwt = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userCheckExist = userRepository.findByEmailAddress(jwt);

        if(data.getEmailAddress() == "" && data.getUsername() == "" && data.getPassword() == "") {
            throw new IllegalArgumentException("Aucune modification n'a été effectué.");
        }

        
        UserEntity emailUser = userRepository.findByEmailAddress(data.getEmailAddress());
        if(emailUser != null && !emailUser.getUserId().equals(userCheckExist.getUserId())) {
            throw new IllegalArgumentException("Un compte existe déjà avec cet email.");
        }



        UserEntity usernameUser = userRepository.findByUsername(data.getUsername());
        if(usernameUser != null && !usernameUser.getUserId().equals(userCheckExist.getUserId())) {
            throw new IllegalArgumentException("Un compte existe déjà avec ce nom d'utilisateur.");
        }

        LocalDateTime currentDate = LocalDateTime.now();

        if(data.getUsername() != null && !data.getUsername().isBlank()) {
            userCheckExist.setUsername(data.getUsername());
        }

        if(data.getEmailAddress() != null && !data.getEmailAddress().isBlank()) {
            userCheckExist.setEmailAddress(data.getEmailAddress());
        }
        
    
        if(data.getPassword() != null && !data.getPassword().isBlank()) {
            // Vérifie le mot de passe (longueur + sécurité)
            String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
            if(!data.getPassword().matches(regexPassword)) {
                throw new IllegalArgumentException("Le mot de passe doit contenir minimum 8 caractères, une majuscule, une minuscule et un caractère spécial.");
            } else {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String password = passwordEncoder.encode(data.getPassword());
                userCheckExist.setPassword(password);
            }
        }

        userCheckExist.setUpdatedAt(currentDate);
        userRepository.save(userCheckExist);
    }
}
