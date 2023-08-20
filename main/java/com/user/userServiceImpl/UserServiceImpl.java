package com.user.userServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserLocation;
import com.user.userRepository.UserRepository;
import com.user.userService.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<UserLocation> getAllUser() {
		return (List<UserLocation>) userRepo.findAll();
	}

	@Override
	public UserLocation getUserById(Long id) {
				Optional<UserLocation> findById = userRepo.findById(id);
				if(findById.isPresent()) {
					UserLocation location = findById.get();
					return location;
				}
				return null;
				
	}
	
	

	@Override
	public UserLocation addorUpdateUser(UserLocation userLocation) {
		return userRepo.save(userLocation);
	}

	
	
	@Override
	public boolean deleteUser(Long id) {
		boolean deletedUser=userRepo.existsById(id);
		if(deletedUser) {
			userRepo.deleteById(id);
			return true;
		}	
		return false ;
	}

	
	
	public List<UserLocation> getNearestUsers(Long N) {
		List<UserLocation> list = userRepo.findNearestUsers(N);
		return list; 
	}


}