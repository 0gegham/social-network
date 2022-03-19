package org.snetwork.service;

import java.util.UUID;

public interface FriendsService {
    void addFriend(UUID userId, UUID friendId);
    void removeFriendById(UUID userId, UUID friendId);
}
