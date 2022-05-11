package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.Likes;
import com.app.linkedhu.request.LikeCreateRequest;
import com.app.linkedhu.response.LikeResponse;
import com.app.linkedhu.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam(name = "userId") Optional<Long> userId,
                                          @RequestParam(name = "postId") Optional<Long> postId) {
        return likeService.getAllLikesWithParam(userId, postId);
    }

    @PostMapping
    public Likes createOneLike(@RequestBody LikeCreateRequest request) {
        return likeService.createOneLike(request);
    }

    @GetMapping("/{likeId}")
    public Likes getOneLike(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        likeService.deleteOneLikeById(likeId);
    }

}
