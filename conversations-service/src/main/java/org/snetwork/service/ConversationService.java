package org.snetwork.service;

import org.snetwork.model.entity.Conversation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ConversationService {
    Conversation save(Conversation conversation);
    Conversation getById(UUID id);
    Page<Conversation> getAll(Pageable pageable);
    Page<Conversation> getAllByName(Pageable pageable, String name);
    void remove(Conversation conversation);
}
