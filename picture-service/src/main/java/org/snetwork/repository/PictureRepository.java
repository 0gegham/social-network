package org.snetwork.repository;

import org.snetwork.model.entity.Picture;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface PictureRepository extends CrudRepository<Picture, UUID> {
    Optional<Picture> findByUserId(UUID userId);
}
