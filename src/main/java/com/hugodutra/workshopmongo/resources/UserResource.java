package com.hugodutra.workshopmongo.resources;

import com.hugodutra.workshopmongo.domain.User;
import com.hugodutra.workshopmongo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>>  findAll(){
        List<User> users = userService.findAll();
        if(users.size()!=0){
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }
}
