package com.app.linkedhu.controller;


import com.app.linkedhu.entitites.Poll;
import com.app.linkedhu.request.PollCreateRequest;
import com.app.linkedhu.request.PollService;
import com.app.linkedhu.response.PollResponse;
import com.app.linkedhu.response.PostResponse;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("polls")
public class PollController {

    private PollService pollService;


    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestParam("userId")Long userId,@RequestBody PollCreateRequest pollCreateRequest){
        return pollService.createPoll(userId,pollCreateRequest);
    }

    @PutMapping
    public void vote(@RequestParam("choiceId") Long choiceId){
         pollService.vote(choiceId);
    }

    @GetMapping()
    public PollResponse getResults(@RequestParam("pollId") Long pollId){
        return pollService.getResults(pollId);
    }
}
