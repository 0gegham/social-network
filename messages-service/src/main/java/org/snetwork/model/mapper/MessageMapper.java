package org.snetwork.model.mapper;

import org.mapstruct.Mapper;
import org.snetwork.model.dto.MessageDto;
import org.snetwork.model.entity.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto entityToDto(Message entity);
    Message dtoToEntity(MessageDto dto);
}
