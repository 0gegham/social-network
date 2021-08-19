package org.snetwork.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.snetwork.exception.PictureNotFoundException;
import org.snetwork.model.entity.Picture;
import org.snetwork.repository.PictureRepository;
import org.snetwork.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Override
    public void save(MultipartFile file, UUID userId) {
        try {
            Picture picture = new Picture(userId, file.getBytes());
            pictureRepository.save(picture);
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
    }

    @Override
    public Picture getById(UUID id) {
        return pictureRepository.findById(id)
                .orElseThrow(() -> new PictureNotFoundException("Wrong picture id"));
    }

    @Override
    public Picture getByUserId(UUID userId) {
        return pictureRepository.findByUserId(userId)
                .orElseThrow(() -> new PictureNotFoundException("Wrong user id"));
    }

    @Override
    public void remove(Picture picture) {
        pictureRepository.delete(picture);
    }
}
