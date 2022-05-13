package com.app.linkedhu.service;

import com.app.linkedhu.entitites.Mail;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.repository.MailRepository;
import com.app.linkedhu.request.MailCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public Mail createMail(MailCreateRequest mailCreateRequest){
        User senderUser = userService.getOneUserById(mailCreateRequest.getSenderUserId());
        if(mailCreateRequest.isMass()){
            List<User> users = userService.getAllUsers();
            users.remove(userService.getOneUserById(senderUser.getId()));
            if(senderUser != null){
                for(User user : users){
                    mailCreateRequest.setReceiverUserId(user.getId());
                    createOneMail(mailCreateRequest);
                }
            }
            return new Mail();
        }
        else{
           return createOneMail(mailCreateRequest);
        }
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
        /*User senderUser = userService.getOneUserById(mailCreateRequest.getSenderUserId());
        List<User> users = userService.getAllUsers();
        users.remove(userService.getOneUserById(senderUser.getId()));
        if(senderUser != null){
            for(User user : users){
                mailCreateRequest.setReceiverUserId(user.getId());
                createOneMail(mailCreateRequest);
            }
        }*/
    }
    public void deleteOneMailById(Long mailId){
        mailRepository.deleteById(mailId);
    }
    public Mail getOneMailById(Long mailId){
        return mailRepository.findById(mailId).orElse(null);
    }

}
