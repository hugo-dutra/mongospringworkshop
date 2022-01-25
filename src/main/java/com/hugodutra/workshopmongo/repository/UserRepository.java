package com.hugodutra.workshopmongo.repository;

import com.hugodutra.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
