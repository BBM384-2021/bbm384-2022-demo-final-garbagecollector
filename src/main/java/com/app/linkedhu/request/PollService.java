package com.app.linkedhu.request;

import com.app.linkedhu.entitites.Choice;
import com.app.linkedhu.entitites.Poll;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.repository.ChoiceRepository;
import com.app.linkedhu.repository.PollRepository;
import com.app.linkedhu.response.CommentResponse;
import com.app.linkedhu.response.PollResponse;
import com.app.linkedhu.response.PostResponse;
import com.app.linkedhu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private PollRepository pollRepository;
    private ChoiceRepository choiceRepository;

    private UserService userService;

    public PollService(PollRepository pollRepository, ChoiceRepository choiceRepository, UserService userService) {
        this.pollRepository = pollRepository;
        this.choiceRepository = choiceRepository;
        this.userService = userService;
    }


    public Poll createPoll(Long userId, PollCreateRequest pollCreateRequest) {
        User user = userService.getOneUserById(userId);
        if (user!= null && !pollCreateRequest.getTitle().isEmpty() && !pollCreateRequest.getChoices().isEmpty()){
            Poll poll = new Poll();
            poll.setSenderUser(user);
            poll.setTitle(pollCreateRequest.getTitle());
            Poll temp1 = pollRepository.save(poll);
            for (String choice:pollCreateRequest.getChoices()) {
                Choice choice1 = new Choice();
                choice1.setPoll(temp1);
                choice1.setText(choice);
                choiceRepository.save(choice1);
            }
            return temp1;
        }else {
            return null;
        }
    }

    public void vote(Long choiceId) {
            Choice choice = choiceRepository.getById(choiceId);
            choice.setCount(choice.getCount()+1);
            choiceRepository.save(choice);

    }

    public PollResponse getResults(Long pollId) {
        Poll poll = pollRepository.getById(pollId);
        List<Choice> choices = choiceRepository.findAllByPollId(pollId);
        PollResponse pollResponse = new PollResponse();
        pollResponse.setTitle(poll.getTitle());
        pollResponse.setUserId(poll.getSenderUser().getId());
        pollResponse.setChoices(choices);
        pollResponse.setUserName(poll.getSenderUser().getUserName());
        return pollResponse;
    }
}
