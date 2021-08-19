package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.mapper.UserMapper;
import org.snetwork.model.dto.UserDto;
import org.snetwork.model.entity.UserEntity;
import org.snetwork.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(path = "/all")
    public Page<UserDto> getAll(@PageableDefault(size = 20, page = 0) Pageable pageable) {
        return userService.getAll(pageable).map(userMapper::entityToDto);
    }

    @PostMapping(path = "/save")
    public UserDto save(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        userService.save(userEntity);
        return userDto;
    }

    @GetMapping(path = "/by")
    public UserDto getByUsername(@RequestParam(value = "username") String username) {
        return userMapper.entityToDto(userService.getByUsername(username));
    }
}
