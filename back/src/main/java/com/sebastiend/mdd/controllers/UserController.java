package com.sebastiend.mdd.controllers;


import java.util.Optional;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sebastiend.mdd.models.dto.Users.UserCreateDTO;
import com.sebastiend.mdd.models.dto.Users.UserDTO;
import com.sebastiend.mdd.models.dto.Users.UserLoginDTO;
import com.sebastiend.mdd.models.dto.Users.UserTokenResponseDTO;
import com.sebastiend.mdd.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /* Register the account */
    @PostMapping("/api/users/register")
    public ResponseEntity<Void> register(@RequestBody UserCreateDTO data) {
        userService.registerUser(data);
        return ResponseEntity.noContent().build();
    }


    /* Login the account */
    @PostMapping("/api/users/login")
    public ResponseEntity<UserTokenResponseDTO> login(@RequestBody UserLoginDTO data) throws AuthenticationException {
        userService.loginUser(data);
        return ResponseEntity.ok(userService.loginUser(data));
    }


    /* Get user details */
    @GetMapping("/api/users/details")
    public Optional<UserDTO> userDetails() {
        return userService.getDetails();
    }
    
}
