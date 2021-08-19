package org.snetwork.service;

import org.snetwork.model.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MessageService {
    void sendMessageToBroker(Message message);
    Page<Message> getAllMessagesByUserId(Pageable pageable, UUID userId);
    Page<Message> getAllMessagesByConversationId(Pageable pageable, UUID conversionId);
    void removeMessage(Message message);
}
