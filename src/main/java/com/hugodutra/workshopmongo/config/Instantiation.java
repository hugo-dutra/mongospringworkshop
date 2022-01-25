package com.hugodutra.workshopmongo.config;

import com.hugodutra.workshopmongo.domain.User;
import com.hugodutra.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null,"Hugo Alves Dutra","hugo.dutra@hotmail.com");
        User user2 = new User(null,"Juliana Alves Dutra","juliana.dutra@hotmail.com");
        User user3 = new User(null,"Gilbero Dutra de Freitas","gilberto.dutra@hotmail.com");
        User user4 = new User(null,"Francisca Alves da Costa","francisca.alves@hotmail.com");
        User user5 = new User(null,"Ana Olívia Rodrigues Ferreira","anarodriguesf1@hotmail.com");
        User user6 = new User(null,"Laura Rodrigues Dutra","laura.dutra@hotmail.com");
        User user7 = new User(null,"Clara Rodrigues Dutra","clara.dutra@hotmail.com");

        List<User> users = Arrays.asList(user1,user2,user3,user4,user5,user6,user7);
        userService.deleteAll();
        userService.saveAll(users);
    }
}
