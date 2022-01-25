package com.hugodutra.workshopmongo.resources;

import com.hugodutra.workshopmongo.domain.User;
import com.hugodutra.workshopmongo.dto.UserDTO;
import com.hugodutra.workshopmongo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>>  findAll(){
        List<User> users = userService.findAll();
        List<UserDTO> userDTOS = users
                .stream()
                .map(usr -> new UserDTO(usr))
                .collect(Collectors.toList());
        if(users.size()!=0){
            return ResponseEntity.ok(userDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserDTO(user));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody UserDTO usr){
        User user = userService.fromDTO(usr);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        userService.deleteById(id);
    }
}
