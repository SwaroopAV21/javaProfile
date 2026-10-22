
package com.profile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import com.profile.model.User;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/login")
@RequiredArgsConstructor
class LoginController {


//    @GetMapping("/getSession")
//    public ResponseEntity<ApiResponse<User>> getJWTSessionToken(){
//        return ResponseEntity.ok(ApiResponse.success(user));
//    }
}