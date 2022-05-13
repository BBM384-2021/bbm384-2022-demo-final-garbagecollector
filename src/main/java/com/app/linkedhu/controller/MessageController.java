package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.Message;
import com.app.linkedhu.request.MessageCreateRequest;
import com.app.linkedhu.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessages(@RequestParam(name = "senderUserId") Optional<Long> senderUserId, @RequestParam(name = "receiverUserId") Optional<Long> receiverUserId) {
        return messageService.getAllMessages(senderUserId, receiverUserId);
    }

    @PostMapping
    public Message createOneMessage(@RequestBody MessageCreateRequest messageCreateRequest) {
        return messageService.createOneMessage(messageCreateRequest);
    }

    @GetMapping("/{messageId}")
    public Message getOneMail(@PathVariable Long messageId) {
        return messageService.getOneMessageById(messageId);
    }

    @DeleteMapping("/{messageId}")
    public void deleteOneMail(@PathVariable Long messageId) {
        messageService.deleteOneMessageById(messageId);
    }
}
