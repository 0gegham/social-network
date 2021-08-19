package org.snetwork.controller;

import lombok.RequiredArgsConstructor;
import org.snetwork.model.entity.Conversation;
import org.snetwork.service.ConversationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping(path = "/save")
    public Conversation save(Conversation conversation) {
        return conversationService.save(conversation);
    }

    @GetMapping(path = "/all")
    public Page<Conversation> getAll(@PageableDefault(size = 20, page = 0) Pageable pageable) {
        return conversationService.getAll(pageable);
    }

    @GetMapping(path = "/by_id")
    public Conversation getById(@RequestParam(value = "id") UUID id) {
        return conversationService.getById(id);
    }

    @GetMapping(path = "/all/by_name")
    public Page<Conversation> getAllByName(@PageableDefault(size = 20, page = 0) Pageable pageable, String name) {
        return conversationService.getAllByName(pageable, name);
    }

    @DeleteMapping(path = "/remove")
    @ResponseStatus(value = HttpStatus.OK)
    public void remove(Conversation conversation) {
        conversationService.remove(conversation);
    }
}
