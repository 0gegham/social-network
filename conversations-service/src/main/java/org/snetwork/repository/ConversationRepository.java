package org.snetwork.repository;

import org.snetwork.model.entity.Conversation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ConversationRepository extends PagingAndSortingRepository<Conversation, UUID> {
    Page<Conversation> findAllByName(Pageable pageable, String name);
}
