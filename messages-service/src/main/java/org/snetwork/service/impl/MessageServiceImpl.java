package org.snetwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.snetwork.model.entity.Message;
import org.snetwork.repository.MessageRepository;
import org.snetwork.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageServiceImpl implements MessageService {

    @Value("${spring.amqp.exchange}")
    private String exchange;

    @Value("${spring.amqp.routing_key}")
    private String routingKey;

    private final MessageRepository messageRepository;
    private final AmqpTemplate template;

    @Override
    @Transactional(readOnly = false)
    public void sendMessageToBroker(Message message) {
        messageRepository.save(message);
        template.convertAndSend(exchange, routingKey, message);
    }

    @Override
    public Page<Message> getAllMessagesByUserId(Pageable pageable, UUID userId) {
        return messageRepository.findAllByUserId(pageable, userId);
    }

    @Override
    public Page<Message> getAllMessagesByConversationId(Pageable pageable, UUID conversionId) {
        return messageRepository.findAllByConversationId(pageable, conversionId);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeMessage(Message message) {
        messageRepository.delete(message);
    }
}
