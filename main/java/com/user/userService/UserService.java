package com.user.userService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.UserLocation;

@Service
public interface UserService {

	public List<UserLocation> getAllUser();
	
	public UserLocation getUserById(Long id);
	
	public UserLocation addorUpdateUser(UserLocation userLocation);
	
	public boolean deleteUser(Long id);
	public List<UserLocation> getNearestUsers(Long N);
}
