package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.model.dto.MessageDto;
import org.snetwork.model.mapper.MessageMapper;
import org.snetwork.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageWebSocketController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public void send(@Payload MessageDto message) {
        messageService.sendMessageToBroker(messageMapper.dtoToEntity(message));
    }

}
