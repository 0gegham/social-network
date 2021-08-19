package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.mapper.UserMapper;
import org.snetwork.model.JwtResponse;
import org.snetwork.model.RefreshTokenRequest;
import org.snetwork.model.dto.UserDto;
import org.snetwork.service.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtService jwtService;
    private final UserMapper userMapper;

    @PostMapping(path = "/sign_in")
    public JwtResponse auth(@RequestBody UserDto userDto) {
        return jwtService.auth(userMapper.dtoToEntity(userDto));
    }

    @PostMapping(path = "/refresh_token")
    public JwtResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return jwtService.refreshToken(refreshTokenRequest);
    }
}
