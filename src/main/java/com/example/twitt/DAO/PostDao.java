package com.example.twitt.DAO;

import com.example.twitt.entity.UserPost;
import com.example.twitt.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository


@AllArgsConstructor
@NoArgsConstructor
public class PostDao {
    @Autowired
    private PostRepository postRepository;

    public Page<UserPost> getPostPage(int limit) {
        Page<UserPost> page = postRepository.findAll(
                PageRequest.of(0, limit)
        );
        return page;
    }
}
