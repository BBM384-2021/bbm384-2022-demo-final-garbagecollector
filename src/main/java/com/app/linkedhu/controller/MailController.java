package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.Mail;
import com.app.linkedhu.request.MailCreateRequest;
import com.app.linkedhu.service.MailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/mails")
public class MailController {
    private MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @RequestMapping(value = "/sentMails", method = RequestMethod.GET)
    public List<Mail> getAllSentMails(@RequestParam(name = "userId") Optional<Long> userId) {
        return mailService.getAllSentMails(userId);
    }

    @RequestMapping(value = "/receivedMails", method = RequestMethod.GET)
    public List<Mail> getAllReceivedMails(@RequestParam(name = "userId") Optional<Long> userId) {
        return mailService.getAllReceivedMails(userId);
    }

    @PostMapping
    public Mail createMail(@RequestBody MailCreateRequest mailCreateRequest) {
        if(mailCreateRequest.getReceiverUserId() == null){
            mailCreateRequest.setReceiverUserId(Long.valueOf(0));
        }
        System.out.println(mailCreateRequest.isMass());
        return mailService.createMail(mailCreateRequest);
    }



    @GetMapping("/{mailId}")
    public Mail getOneMail(@PathVariable Long mailId) {
        return mailService.getOneMailById(mailId);
    }

    @DeleteMapping("/{mailId}")
    public void deleteOneMail(@PathVariable Long mailId) {
        mailService.deleteOneMailById(mailId);
    }
}
