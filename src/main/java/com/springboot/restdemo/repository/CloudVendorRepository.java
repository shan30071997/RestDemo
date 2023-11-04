package com.springboot.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restdemo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
