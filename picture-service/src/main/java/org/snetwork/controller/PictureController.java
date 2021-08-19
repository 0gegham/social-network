package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.model.dto.PictureDto;
import org.snetwork.model.mapper.PictureMapper;
import org.snetwork.service.PictureService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;
    private final PictureMapper pictureMapper;

    @PostMapping(path = "/save")
    public void save(@RequestParam(name = "pic", required = false) MultipartFile file,
                       @RequestParam(name = "user_id") UUID id) {
        pictureService.save(file, id);
    }

    @GetMapping(path = "/by/info/id", produces = "application/json")
    public PictureDto getImageInfoById(@RequestParam("id") UUID id) {
        return pictureMapper.entityToDto(pictureService.getById(id));
    }

    @GetMapping(path = "/by/pic/user_id", produces = "application/json")
    public PictureDto getImageInfoByUserId(@RequestParam("user_id") UUID id) {
        return pictureMapper.entityToDto(pictureService.getByUserId(id));
    }

    @GetMapping(path = "/by/pic/id", produces = "image/jpeg")
    public byte[] getImageById(@RequestParam(name = "id") UUID id) {
        return pictureService.getById(id).getPicByte();
    }

    @GetMapping(path = "/by/pic/user_id", produces = "image/jpeg")
    public byte[] getImageByUserId(@RequestParam(name = "user_id") UUID id) {
        return pictureService.getByUserId(id).getPicByte();
    }

    @DeleteMapping(path = "/remove")
    public void remove(@RequestBody PictureDto pictureDto) {
        pictureService.remove(pictureMapper.dtoToEntity(pictureDto));
    }
}
