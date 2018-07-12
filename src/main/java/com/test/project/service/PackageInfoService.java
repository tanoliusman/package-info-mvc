package com.test.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.project.model.PackageInfo;
import com.test.project.repository.PackageInfoRepository;
import com.test.project.utils.ResponseClass;

/**
 * 
 * @author usman
 *
 */
@Service
public class PackageInfoService {

	@Autowired
	private PackageInfoRepository packageInfoRepository;
	
	public ResponseEntity<ResponseClass> getAllPackageInfo(){
		
		try {
			List<PackageInfo> infos = (List<PackageInfo>) packageInfoRepository.findAll();  
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Package info Fetched Successfully",
														true, infos),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Internal Error occured while fetching package info.", false, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<ResponseClass> addNewPackageInfo(PackageInfo packageInfo) {
		try {
			packageInfoRepository.save(packageInfo);
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Package info saved Successfully",
														true, null),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Internal Error occured while Adding package info.", false, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<ResponseClass> deletePackageInfo(String id) {
		try {
			Optional<PackageInfo> packageInfo = packageInfoRepository.findById(Integer.parseInt(id));
			packageInfoRepository.delete(packageInfo.get());
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Package info deleted Successfully",true, null),HttpStatus.OK);
		}catch (NoSuchElementException ex) {
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Unable to find Package Info", false, null), HttpStatus.BAD_REQUEST);
		}catch(Exception ex) {
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Internal Error occured while Adding package info.", false, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<ResponseClass> updatePackageInfo(PackageInfo packageInfo) {
		try {
			packageInfoRepository.save(packageInfo);
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Package info updated Successfully",
														true, null),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Internal Error occured while Adding package info.", false, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<ResponseClass> getPackageInfoById(String id) {
		try {
			Optional<PackageInfo> packageInfo = packageInfoRepository.findById(Integer.parseInt(id));
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Package info found Successfully",true, packageInfo.get()),HttpStatus.OK);
		}catch (NoSuchElementException ex) {
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Unable to find Package Info", false, null), HttpStatus.BAD_REQUEST);
		}catch(Exception ex) {
			return new ResponseEntity<ResponseClass>(ResponseClass.getResponse("Internal Error occured while Adding package info.", false, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
