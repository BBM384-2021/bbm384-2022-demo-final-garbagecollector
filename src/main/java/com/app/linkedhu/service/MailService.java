package com.app.linkedhu.service;

import com.app.linkedhu.entitites.Mail;
import com.app.linkedhu.entitites.Message;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.repository.MailRepository;
import com.app.linkedhu.request.MailCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MailService {
    private MailRepository mailRepository;
    private UserService userService;

    public MailService(MailRepository mailRepository, UserService userService) {
        this.mailRepository = mailRepository;
        this.userService = userService;
    }

    public List<Mail> getAllSentMails(Optional<Long> userId){
        List<Mail> newList = new ArrayList<>();
        if(userId.isPresent()){
            return mailRepository.findBySenderUserId(userId.get());
        }

        return newList;
    }

    public List<Mail> getAllReceivedMails(Optional<Long> userId){
        List<Mail> newList = new ArrayList<>();
        if(userId.isPresent()){
            return mailRepository.findByReceiverUserId(userId.get());
        }

        return newList;
    }


    public Mail createOneMail(MailCreateRequest mailCreateRequest){
        User senderUser = userService.getOneUserById(mailCreateRequest.getSenderUserId());
        User receiverUser = userService.getOneUserById(mailCreateRequest.getReceiverUserId());
        if(senderUser==null | receiverUser == null){
            return null;
        }
        Mail toSave = new Mail();
        toSave.setId(mailCreateRequest.getId());
        toSave.setText(mailCreateRequest.getText());
        toSave.setTitle(mailCreateRequest.getTitle());
        toSave.setDate(new java.util.Date());
        toSave.setSenderUser(senderUser);
        toSave.setReceiverUser(receiverUser);
        return mailRepository.save(toSave);
    }
    public void deleteOneMailById(Long mailId){
        mailRepository.deleteById(mailId);
    }
    public Mail getOneMailById(Long mailId){
        return mailRepository.findById(mailId).orElse(null);
    }

}
