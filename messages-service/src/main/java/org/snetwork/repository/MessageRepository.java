package org.snetwork.repository;

import org.snetwork.model.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface MessageRepository extends PagingAndSortingRepository<Message, UUID> {
    Page<Message> findAllByUserId(Pageable pageable, UUID id);
    Page<Message> findAllByConversationId(Pageable pageable, UUID id);
}
