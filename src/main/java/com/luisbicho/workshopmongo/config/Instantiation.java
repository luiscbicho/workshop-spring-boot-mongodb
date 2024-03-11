package com.luisbicho.workshopmongo.config;

import com.luisbicho.workshopmongo.domain.Post;
import com.luisbicho.workshopmongo.domain.User;
import com.luisbicho.workshopmongo.dto.AuthorDTO;
import com.luisbicho.workshopmongo.dto.CommentDTO;
import com.luisbicho.workshopmongo.repositories.PostRepository;
import com.luisbicho.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dtf.withZone(ZoneOffset.UTC);
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob)); 

        Post post1 = new Post(null, LocalDate.parse("21/03/2008",dtf),"Partiu viagem","Vou viajar para sao Paulo",new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2008",dtf),"Bom dia","Acordei feliz hoje!",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!",LocalDate.parse("21/03/2018",dtf),new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!",LocalDate.parse("22/03/2018",dtf),new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia!",LocalDate.parse("23/03/2018",dtf),new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

    }
}
