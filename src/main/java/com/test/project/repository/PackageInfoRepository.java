package com.test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.project.model.PackageInfo;

/**
 * 
 * @author usman
 *
 */
@Repository
public interface PackageInfoRepository extends JpaRepository<PackageInfo, Integer>{

}
