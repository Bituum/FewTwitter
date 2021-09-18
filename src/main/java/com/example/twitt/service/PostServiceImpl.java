package com.example.twitt.service;

import com.example.twitt.DAO.PostDao;
import com.example.twitt.entity.MainUser;
import com.example.twitt.entity.UserPost;
import com.example.twitt.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PostServiceImpl implements PostService {

    private static Logger logger = Logger.getLogger(PostServiceImpl.class.getName());
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PostDao postDao;

    @Override
    public UserPost newPost(UserPost post, MainUser user) {
        List<UserPost> userPostList = postRepository.getUserPostsByUserId(user.getId());
        userPostList.add(post);

        user.setUserPostList(userPostList);

        return postRepository.save(post);
    }

    @Override
    public void deletePostById(int id, int uid) {
        List<UserPost> userPostList = postRepository.getUserPostsByUserId(uid);
        userPostList.remove(id - 1);

        userService.getOneById(uid).setUserPostList(userPostList);

        postRepository.deleteById(id);
    }

    @Override
    public void deletePost(UserPost post) {

        postRepository.delete(post);
    }

    @Override
    public List<UserPost> getAll() {
        return postRepository.findAll();
    }

    @Override
    public UserPost getOneById(int id, int uid) {
        return userService.getOneById(uid)
                .getUserPostList()
                .get(id);
    }

    @Override
    public List<UserPost> getOnePostPage() {
        Page<UserPost> page = postDao.getPostPage(1);
        return page.getContent();
    }

    @Override
    public UserPost editPost(UserPost post, int uid, int id) {
        List<UserPost> userPostList = postRepository.getUserPostsByUserId(uid);
        userPostList.remove(id);
        userPostList.add(post);

        userService.getOneById(uid).setUserPostList(userPostList);

        return postRepository.save(post);
    }
}
