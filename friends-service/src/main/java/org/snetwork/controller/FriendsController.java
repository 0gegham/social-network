package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.model.FriendshipRequest;
import org.snetwork.service.FriendsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FriendsController {

    private final FriendsService friendsService;

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
