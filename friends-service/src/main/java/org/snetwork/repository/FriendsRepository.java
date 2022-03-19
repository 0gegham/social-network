package org.snetwork.repository;

import java.util.UUID;

public interface FriendsRepository {
    void addFriend(UUID userId, UUID friendId);
    void removeFriendById(UUID userId, UUID friendId);
}
