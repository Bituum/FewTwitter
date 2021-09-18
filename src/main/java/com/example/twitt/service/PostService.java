package com.example.twitt.service;

import com.example.twitt.entity.MainUser;
import com.example.twitt.entity.UserPost;

import java.util.List;

public interface PostService {
    UserPost newPost(UserPost post, MainUser user);

    void deletePostById(int id, int uid);

    void deletePost(UserPost post);

    List<UserPost> getAll();

    UserPost getOneById(int id, int uid);

    List<UserPost> getOnePostPage();

    UserPost editPost(UserPost post, int uid, int id);
}
