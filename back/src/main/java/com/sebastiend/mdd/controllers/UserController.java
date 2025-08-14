package com.sebastiend.mdd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sebastiend.mdd.models.dto.Users.UserCreateDTO;
import com.sebastiend.mdd.services.UserService;


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
}
