package com.springboot.restdemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restdemo.Exception.CloudVendorNotFoundException;
import com.springboot.restdemo.model.CloudVendor;
import com.springboot.restdemo.repository.CloudVendorRepository;
import com.springboot.restdemo.service.CloudVendorService;
@Service
public class CloudVendorServiceImpl implements CloudVendorService{

	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public CloudVendor createCloudVendor(CloudVendor cloudVendor) {
		return cloudVendorRepository.save(cloudVendor);
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String deleteCloudVendor(String vendorId) {
		cloudVendorRepository.deleteById(vendorId);
		return "Success";
	}

	@Override
	public CloudVendor getCloudVendor(String vendorId) {
		if(cloudVendorRepository.findById(vendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Vendor does not Exist", null);
		return cloudVendorRepository.findById(vendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudvendors() {
		return cloudVendorRepository.findAll();
	}

}
