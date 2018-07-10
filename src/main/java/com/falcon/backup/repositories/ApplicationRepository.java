package com.falcon.backup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.backup.entities.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {

	List<Application> findByOwner(Integer userId);

}
