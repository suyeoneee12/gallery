package org.shopping.gallery.backend.controller;

import lombok.RequiredArgsConstructor;
import org.shopping.gallery.backend.dto.UserDto;
import org.shopping.gallery.backend.entity.User;
import org.shopping.gallery.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/register")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        String email = userDto.getEmail();
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        try {
            // email이 이미 존재하는지 확인
            if(userService.isEmailExists(email)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 이메일입니다.");
            }

            User registeredUser = userService.registerUser(email, username, password);

            if(registeredUser != null) {
                return ResponseEntity.ok("회원가입 성공!");
            }else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("만료된 키입니다.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버오류");
        }

    }
}
