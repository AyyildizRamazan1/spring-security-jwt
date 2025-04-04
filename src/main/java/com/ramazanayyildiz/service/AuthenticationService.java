package com.ramazanayyildiz.service;

import com.ramazanayyildiz.dto.UserDto;
import com.ramazanayyildiz.dto.UserRequest;
import com.ramazanayyildiz.dto.UserResponse;
import com.ramazanayyildiz.entity.User;
import com.ramazanayyildiz.enums.Role;
import com.ramazanayyildiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserResponse save(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nameSurname(userDto.getNameSurname())
                .role(Role.USER).build();
        userRepository.save(user);

        var token=jwtService.generateToken(user);

        return UserResponse.builder().token(token).build();
    }

    public UserResponse auth(UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow();
        String token =jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }
}
