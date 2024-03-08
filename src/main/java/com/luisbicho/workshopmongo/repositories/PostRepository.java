package com.luisbicho.workshopmongo.repositories;

import com.luisbicho.workshopmongo.domain.Post;
import com.luisbicho.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {


}