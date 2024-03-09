package com.luisbicho.workshopmongo.services;


import com.luisbicho.workshopmongo.domain.Post;
import com.luisbicho.workshopmongo.repositories.PostRepository;
import com.luisbicho.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(()->new ObjectNotFoundException("Not found."));
    }



}
