package com.falcon.backup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.backup.entities.Package;

public interface PackageRepository extends CrudRepository<Package, Integer> {
	List<Package>findByApplications(Integer applicationId);
}
