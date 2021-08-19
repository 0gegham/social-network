package org.snetwork.service;

import org.snetwork.model.JwtResponse;
import org.snetwork.model.RefreshTokenRequest;
import org.snetwork.model.entity.UserEntity;

public interface JwtService {
    JwtResponse auth(UserEntity user);
    JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
