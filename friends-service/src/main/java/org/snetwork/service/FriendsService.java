package org.snetwork.service;

import org.snetwork.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface FriendsService {
    Page<UserEntity> getFriends(Pageable pageable, UUID id);
    void addFriend(UUID userId, UUID friendId);
    void removeFriendById(UUID userId, UUID friendId);
}
