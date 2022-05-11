package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.Follow;
import com.app.linkedhu.request.FollowCreateRequest;
import com.app.linkedhu.response.FollowResponse;
import com.app.linkedhu.service.FollowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/follows")
public class FollowController {
    private FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @RequestMapping(value = "/followings", method = RequestMethod.GET)
    public List<Follow> getAllFollows(@RequestParam(name = "userId")Optional<Long> userId){
        return followService.getAllFollows(userId);
    }

    @RequestMapping(value = "/followers", method = RequestMethod.GET)
    public List<Follow> getAllFollowers(@RequestParam(name = "userId")Optional<Long> userId){
        return followService.getAllFollowers(userId);
    }

    @GetMapping
    public FollowResponse isFollowed(@RequestParam(name = "senderUserId") Optional<Long> senderUserId,
                                     @RequestParam(name = "receiverUserId") Optional<Long> receiverUserId){
        Follow follow = followService.getOneFollow(senderUserId, receiverUserId);
        if(follow!=null){
            return new FollowResponse(follow.getId(),true);
        }
        else{
            return new FollowResponse(null,false);
        }
    }

    @PostMapping
    public Follow createOneFollow(@RequestBody FollowCreateRequest followCreateRequest){
        return followService.createOneFollow(followCreateRequest);
    }

    @GetMapping("/{followId}")
    public Follow getOneCurrentFollow(@PathVariable(name = "followId") Long followId){
        return followService.getOneCurrentFollow(followId);
    }

    @DeleteMapping
    public void deleteOneFollow(Long followId){
        followService.DeleteOneFollow(followId);
    }
}
