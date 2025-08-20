package com.sebastiend.mdd.controllers;


import java.util.Optional;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sebastiend.mdd.models.dto.Users.*;
import com.sebastiend.mdd.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /* Register the account */
    @PostMapping("/api/users/register")
    public ResponseEntity<Object> register(@RequestBody UserCreateDTO data) {
        try {
            UserCreateResponseDTO response = userService.registerUser(data);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Login the account */
    @PostMapping("/api/users/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDTO data) throws AuthenticationException {
        try {
            UserTokenResponseDTO response = userService.loginUser(data);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Get user details */
    @GetMapping("/api/users/details")
    public ResponseEntity<Object> userDetails() {
        try {
            Optional<UserDTO> response = userService.getDetails();
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    /* Update user details */
    @PostMapping("/api/users/details")
    public ResponseEntity<Object> update(@RequestBody UserUpdateDTO data) {
        try {
            userService.updateUser(data);
            return ResponseEntity.ok().build();
        } catch(IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}
