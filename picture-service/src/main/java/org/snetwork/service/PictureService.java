package org.snetwork.service;

import org.snetwork.model.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface PictureService {
    void save(MultipartFile file, UUID userId);
    Picture getById(UUID id);
    Picture getByUserId(UUID userId);
    void remove(Picture picture);
}
