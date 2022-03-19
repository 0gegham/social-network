package org.snetwork.repository.impl;

import lombok.RequiredArgsConstructor;
import org.snetwork.repository.FriendsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class FriendsRepositoryImpl implements FriendsRepository {

    private final EntityManager entityManager;

    @Override
    public void addFriend(UUID userId, UUID friendId) {
        executeUpdateQueries("insert into user_friends(user_id, friend_id) values(?, ?)", userId, friendId);
    }

    @Override
    public void removeFriendById(UUID userId, UUID friendId) {
        executeUpdateQueries("delete from user_friends where user_id=? and friend_id=?", userId, friendId);
    }

    private void executeUpdateQueries(String sql, UUID userId, UUID friendId) {
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, userId);
        query.setParameter(2, friendId);
        query.executeUpdate();
    }
}
