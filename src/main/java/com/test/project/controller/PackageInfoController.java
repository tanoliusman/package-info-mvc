package com.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.model.PackageInfo;
import com.test.project.service.PackageInfoService;
import com.test.project.utils.ResponseClass;

/**
 * 
 * @author usman
 *
 */
@RestController
@RequestMapping(value ="/info",produces="application/json")
public class PackageInfoController {
	
	@Autowired
	private PackageInfoService packageInfoService;
	
	@GetMapping
	public ResponseEntity<ResponseClass> getAllPackageInfo() {
		return packageInfoService.getAllPackageInfo();
	}
	
	@PostMapping
	public ResponseEntity<ResponseClass> addNewPackageInfo(@RequestBody PackageInfo packageInfo) {
		return packageInfoService.addNewPackageInfo(packageInfo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseClass> deletePackageInfo(@PathVariable String id) {
		return packageInfoService.deletePackageInfo(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseClass> updatePackageInfo(@RequestBody PackageInfo packageInfo) {
		return packageInfoService.updatePackageInfo(packageInfo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseClass> getPackageInfoById(@PathVariable("id") String id) {
		return packageInfoService.getPackageInfoById(id);
	}
	
	
}
