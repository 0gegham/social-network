package org.snetwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.snetwork.config.jwt.JwtProvider;
import org.snetwork.model.JwtResponse;
import org.snetwork.model.RefreshTokenRequest;
import org.snetwork.model.entity.UserEntity;
import org.snetwork.service.JwtService;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;

    @Override
    public JwtResponse auth(UserEntity user) {
        String username = user.getUsername();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
            throw new AuthenticationCredentialsNotFoundException("Bad credentials");
        }

        String token = generateToken(username);
        return new JwtResponse(username, token);
    }

    @Override
    public JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String username = refreshTokenRequest.getUsername();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = generateToken(userDetails.getUsername());
        return new JwtResponse(username, token);
    }

    private String generateToken(String username) {
        return jwtProvider.generateToken(username);
    }
}
