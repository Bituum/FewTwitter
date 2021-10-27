package com.example.twitt.controller;


import com.example.twitt.entity.UserPost;
import com.example.twitt.service.PostServiceImpl;
import com.example.twitt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class PostController {
    private static Logger logger = Logger.getLogger(PostController.class.getName());
    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/post/all")
    List<UserPost> all() {
        return postService.getAll();
    }

    @GetMapping("user/post/page/{limit}")
    List<UserPost> getPage(@PathVariable ("limit") int limit) {
        return postService.getOnePostPage(limit);
    }


    @PostMapping("user/{id}/post")
    UserPost newPost(@RequestBody UserPost newPost, @PathVariable("id") int userId) {
        return postService.newPost(newPost,
                userService.getOneById(userId));
    }


    @GetMapping("user/{uid}/post/{id}")
    UserPost one(@PathVariable("id") int id, @PathVariable("uid") int userId) {
        return postService.getOneById(id, userId);
    }

    @PutMapping("/user/{uid}/post/{id}")
    UserPost editPost(@RequestBody UserPost post, @PathVariable("id") int id, @PathVariable("uid") int uid) {
        return postService.editPost(post, uid, id - 1);
    }

    @DeleteMapping("user/{uid}/post/{id}")
    void deletePost(@PathVariable("id") int id, @PathVariable("uid") int uid) {
        postService.deletePostById(id, uid);
    }

}
