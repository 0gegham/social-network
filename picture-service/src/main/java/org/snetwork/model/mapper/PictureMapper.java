package org.snetwork.model.mapper;

import org.mapstruct.Mapper;
import org.snetwork.model.dto.PictureDto;
import org.snetwork.model.entity.Picture;

@Mapper(componentModel = "spring")
public interface PictureMapper {
    Picture dtoToEntity(PictureDto dto);
    PictureDto entityToDto(Picture entity);
}
