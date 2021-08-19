package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.mapper.UserMapper;
import org.snetwork.model.FriendshipRequest;
import org.snetwork.model.dto.UserDto;
import org.snetwork.service.FriendsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FriendsController {

    private final FriendsService friendsService;
    private final UserMapper userMapper;

    @GetMapping(path = "/all")
    public Page<UserDto> getFriendsByUserId(@PageableDefault(size = 20, page = 0) Pageable pageable,
                                            @RequestParam(value = "id") UUID id) {
        return friendsService.getFriends(pageable, id).map(userMapper::entityToDto);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public void addFriend(@RequestBody FriendshipRequest requestBody) {
        friendsService.addFriend(requestBody.getUserId(), requestBody.getFriendId());
    }

    @PostMapping(value = "/remove")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeFriend(@RequestBody FriendshipRequest requestBody) {
        friendsService.removeFriendById(requestBody.getUserId(), requestBody.getFriendId());
    }
}
