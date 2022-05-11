package com.app.linkedhu.service;

import com.app.linkedhu.entitites.Follow;
import com.app.linkedhu.entitites.Message;
import com.app.linkedhu.entitites.User;
import com.app.linkedhu.repository.FollowRepository;
import com.app.linkedhu.request.FollowCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FollowService {
    private FollowRepository followRepository;
    private UserService userService;

    public FollowService(FollowRepository followRepository, UserService userService) {
        this.followRepository = followRepository;
        this.userService = userService;
    }

    public List<Follow> getAllFollows(Optional<Long> userId){
        List<Follow> follows = new ArrayList<>();
        if(userId.isPresent()){
            return followRepository.findBySenderUserId(userId.get());
        }
        return follows;
    }

    public List<Follow> getAllFollowers(Optional<Long> userId) {
        List<Follow> follows = new ArrayList<>();
        if (userId.isPresent()) {
            return followRepository.findByReceiverUserId(userId.get());
        }
        return follows;
    }

    public Follow getOneFollow(Optional<Long> senderUserId, Optional<Long> receiverUserId){
        Follow follows = new Follow();
        if(senderUserId.isPresent() & senderUserId.isPresent()){
            return followRepository.findBySenderUserIdAndReceiverUserId(senderUserId.get(), receiverUserId.get());
        }
        return follows;
    }

    public Follow createOneFollow(FollowCreateRequest followCreateRequest){
        User senderUser = userService.getOneUserById(followCreateRequest.getSenderUserId());
        User receiverUser = userService.getOneUserById(followCreateRequest.getReceiverUserId());
        if(senderUser == null | receiverUser == null){
            return null;
        }
        Follow toSave = new Follow();
        toSave.setId(followCreateRequest.getId());
        toSave.setDate(new java.util.Date());
        toSave.setSenderUser(senderUser);
        toSave.setReceiverUser(receiverUser);
        return followRepository.save(toSave);
    }

    public void DeleteOneFollow(Long followId){followRepository.deleteById(followId);}

    public Follow getOneCurrentFollow(Long followId) {
        return followRepository.findById(followId).orElse(null);
    }
}
