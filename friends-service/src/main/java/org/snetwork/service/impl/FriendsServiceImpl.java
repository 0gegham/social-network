package org.snetwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.snetwork.model.entity.UserEntity;
import org.snetwork.repository.FriendsRepository;
import org.snetwork.service.FriendsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class FriendsServiceImpl implements FriendsService {

    private final FriendsRepository friendsRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<UserEntity> getFriends(Pageable pageable, UUID id) {
        return friendsRepository.findAllFriendsByUserId(pageable, id);
    }

    @Override
    public void addFriend(UUID userId, UUID friendId) {
        friendsRepository.addFriend(userId, friendId);
    }

    @Override
    public void removeFriendById(UUID userId, UUID friendId) {
        friendsRepository.removeFriendById(userId, friendId);
    }
}
