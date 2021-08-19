package org.snetwork.repository;

import org.snetwork.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface FriendsRepository extends JpaRepository<UserEntity, UUID> {

    @Query(
            value = "select * from users inner join user_friends on users.id = user_friends.user_id where user_friends.friend_id=:id",
            nativeQuery = true
    )
    Page<UserEntity> findAllFriendsByUserId(Pageable var1, @Param(value = "id") UUID id);

    @Query(
            value = "insert into user_friends(user_id, friend_id) values(:user_id, :friend_id)",
            nativeQuery = true
    )
    @Modifying
    void addFriend(@Param(value = "user_id") UUID userId, @Param(value = "friend_id") UUID friendId);

    @Query(
            value = "delete from user_friends where user_id=:user_id and friend_id=:friend_id",
            nativeQuery = true
    )
    @Modifying
    void removeFriendById(@Param(value = "user_id") UUID userId, @Param(value = "friend_id") UUID friendId);
}
