package com.app.linkedhu.service;

import com.app.linkedhu.entitites.Message;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.repository.MessageRepository;
import com.app.linkedhu.request.MessageCreateRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MessageService {
    public MessageRepository messageRepository;
    private UserService userService;

    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public List<Message> getAllMessages(Optional<Long> senderUserId, Optional<Long> receiverUserId){
        List<Message> newList = new ArrayList<>();
        if(senderUserId.isPresent() | receiverUserId.isPresent()){
            List<Message> sent = messageRepository.findBySenderUserIdAndReceiverUserId(senderUserId.get(), receiverUserId.get());
            List<Message> received = messageRepository.findBySenderUserIdAndReceiverUserId(receiverUserId.get(), senderUserId.get());
            newList = Stream.of(sent, received).flatMap(Collection::stream)
                    .collect(Collectors.toList());

            newList.sort(Comparator.comparing(Message::getDate));
            return newList;
        }
        return newList;
    }

    public Message createOneMessage(MessageCreateRequest messageCreateRequest){
        User senderUser = userService.getOneUserById(messageCreateRequest.getSenderUserId());
        User receiverUser = userService.getOneUserById(messageCreateRequest.getReceiverUserId());
        if(senderUser == null | receiverUser == null){
            return null;
        }
        Message toSave = new Message();
        toSave.setId(messageCreateRequest.getId());
        toSave.setText(messageCreateRequest.getText());
        toSave.setDate(new java.util.Date());
        toSave.setSenderUser(senderUser);
        toSave.setReceiverUser(receiverUser);
        return messageRepository.save(toSave);
    }

    public void deleteOneMessageById(Long messageId){
        messageRepository.deleteById(messageId);
    }

    public Message getOneMessageById(Long messageId){
        return messageRepository.findById(messageId).orElse(null);
    }
}
