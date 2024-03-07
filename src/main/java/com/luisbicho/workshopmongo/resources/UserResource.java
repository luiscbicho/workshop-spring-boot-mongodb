package com.luisbicho.workshopmongo.resources;

import com.luisbicho.workshopmongo.domain.User;
import com.luisbicho.workshopmongo.dto.UserDTO;
import com.luisbicho.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User>list=userService.findAll();
        List<UserDTO>listDto=list.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        UserDTO userDto =new UserDTO(userService.findById(id));
        return ResponseEntity.ok().body(userDto);

    }

}
