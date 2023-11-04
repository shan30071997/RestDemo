package com.springboot.restdemo.service;

import java.util.List;

import com.springboot.restdemo.model.CloudVendor;

public interface CloudVendorService {

	public CloudVendor createCloudVendor(CloudVendor cloudVendor);
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(String vendorId);
	public CloudVendor getCloudVendor(String vendorId);
	public List<CloudVendor> getAllCloudvendors();
}
