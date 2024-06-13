package org.shopping.gallery.backend.service;

import org.shopping.gallery.backend.entity.User;
import org.shopping.gallery.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //BCryptPasswordEncoder 사용하여 비밀번호 암호화
    private final BCryptPasswordEncoder = new BCryptPasswordEncoder();

    // 이메일 중복 확인
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // 사용자 등록
    public User registerUser(String email, String password, String username) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password); // 비밀번호 암호화하여 저장
        newUser.setUsername(username);

        //DB에 사용자 정보 저장
        return userRepository.save(newUser);




    }
}
