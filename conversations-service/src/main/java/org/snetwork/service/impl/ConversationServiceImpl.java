package org.snetwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.snetwork.exception.ConversationNotFoundException;
import org.snetwork.model.entity.Conversation;
import org.snetwork.repository.ConversationRepository;
import org.snetwork.service.ConversationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;

    @Override
    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation getById(UUID id) {
        return conversationRepository.findById(id)
                .orElseThrow(() -> new ConversationNotFoundException("Wrong conversation id"));
    }

    @Override
    public Page<Conversation> getAll(Pageable pageable) {
        return conversationRepository.findAll(pageable);
    }

    @Override
    public Page<Conversation> getAllByName(Pageable pageable, String name) {
        return conversationRepository.findAllByName(pageable, name);
    }

    @Override
    public void remove(Conversation conversation) {
        conversationRepository.delete(conversation);
    }
}
