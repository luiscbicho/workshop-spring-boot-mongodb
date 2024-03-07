package com.luisbicho.workshopmongo.services;

import com.luisbicho.workshopmongo.domain.User;
import com.luisbicho.workshopmongo.repositories.UserRepository;
import com.luisbicho.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
            Optional<User> user = userRepository.findById(id);
            return user.orElseThrow(()->new ObjectNotFoundException("Not Found."));
    }

}
