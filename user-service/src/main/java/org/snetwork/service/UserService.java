package org.snetwork.service;

import org.snetwork.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserEntity save(UserEntity userEntity);
    UserEntity getByUsername(String username);
    Page<UserEntity> getAll(Pageable pageable);
}
