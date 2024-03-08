package com.luisbicho.workshopmongo.resources;

import com.luisbicho.workshopmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostResource {

    @Autowired
    private PostRepository postRepository;



}
