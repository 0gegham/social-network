package org.snetwork.repository;

import org.snetwork.model.entity.UserEntity;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;
import java.util.UUID;

@RepositoryDefinition(domainClass = UserEntity.class, idClass = UUID.class)
public interface UserRepository {
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
