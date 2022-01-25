package com.hugodutra.workshopmongo.service;

import com.hugodutra.workshopmongo.domain.User;
import com.hugodutra.workshopmongo.dto.UserDTO;
import com.hugodutra.workshopmongo.exception.ObjectNotFoundException;
import com.hugodutra.workshopmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        Optional<User> usr = userRepository.findById(user.getId());
        if(usr.isPresent()){
            return userRepository.save(user);
        }
        throw new ObjectNotFoundException("Usuário não encontrado");
    }



    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public void deleteAll (){
        userRepository.deleteAll();
    }

    public void saveAll (Iterable users){
        userRepository.saveAll(users);
    }

    public User fromDTO(UserDTO user){
        return new User(user.getId(),user.getName(),user.getEmail());
    }

    public void deleteById(String id){
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
        userRepository.deleteById(id);
    }

}
