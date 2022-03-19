package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.model.dto.MessageDto;
import org.snetwork.model.mapper.MessageMapper;
import org.snetwork.service.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MessageRestController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @GetMapping(path = "/user_id")
    public Page<MessageDto> allMessagesByUserId(@PageableDefault(size = 20, page = 0) Pageable pageable,
                                                @RequestParam(name = "id") UUID id) {
        return messageService.getAllMessagesByUserId(pageable, id).map(messageMapper::entityToDto);
    }

    @GetMapping(path = "/conversation_id")
    public Page<MessageDto> allMessagesByConversationId(@PageableDefault(size = 20, page = 0) Pageable pageable,
                                                        @RequestParam(name = "id") UUID id) {
        return messageService.getAllMessagesByConversationId(pageable, id).map(messageMapper::entityToDto);
    }

    @DeleteMapping(path = "/remove")
    public void remove(MessageDto message) {
        messageService.removeMessage(messageMapper.dtoToEntity(message));
    }
}
