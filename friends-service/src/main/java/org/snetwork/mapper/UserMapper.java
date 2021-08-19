package org.snetwork.mapper;

import org.mapstruct.Mapper;
import org.snetwork.model.dto.UserDto;
import org.snetwork.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity dtoToEntity(UserDto dto);
    UserDto entityToDto(UserEntity entity);
}
