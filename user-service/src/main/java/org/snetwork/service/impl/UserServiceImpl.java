package org.snetwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.snetwork.exception.UsernameNotFoundException;
import org.snetwork.model.entity.UserEntity;
import org.snetwork.repository.UserRepository;
import org.snetwork.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Wrong username: " + username));
    }

    @Override
    public Page<UserEntity> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
