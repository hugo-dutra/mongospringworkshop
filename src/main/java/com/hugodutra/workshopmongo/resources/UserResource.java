package com.hugodutra.workshopmongo.resources;

import com.hugodutra.workshopmongo.domain.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>>  findAll(){
        User user = new User(1,"Maria","maria@gmail.com");
        User user2 = new User(2,"José","jose@gmail.com");
        List<User> users = Arrays.asList(user,user2);
        if(users.size()!=0){
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.noContent().build();
    }
}
