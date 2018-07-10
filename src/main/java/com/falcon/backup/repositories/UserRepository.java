package com.falcon.backup.repositories;

import org.springframework.data.repository.CrudRepository;

import com.falcon.backup.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
