package com.dev.gallefaceshoppingmall.service.imple;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.controller.JwtAuthenticationResponse;
import com.dev.gallefaceshoppingmall.dto.RefreshTokenRequest;
import com.dev.gallefaceshoppingmall.dto.SignUpRequest;
import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.entity.Role;
import com.dev.gallefaceshoppingmall.repository.UserRepository;
import com.dev.gallefaceshoppingmall.service.AuthenticationService;
import com.dev.gallefaceshoppingmall.service.JWTService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User signup(SignUpRequest signUpRequest){
        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstName());
        user.setSecondname(signUpRequest.getLastName());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public Object signin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signin'");
    }

    @Override
    public Object refreshToken(RefreshTokenRequest refreshTokenRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refreshToken'");
    }


}
