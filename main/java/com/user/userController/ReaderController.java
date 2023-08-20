package com.user.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserLocation;
import com.user.userServiceImpl.UserServiceImpl;

@RestController
@RequestMapping("/reader")
public class ReaderController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	//TO get all users
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserLocation>> getUserLocation(){
		List<UserLocation> user=userServiceImpl.getAllUser();;
		return  new ResponseEntity<List<UserLocation>>(user, HttpStatus.OK);	
	}
	
	
	// Mapping for Nearest User
	@GetMapping("/get_users/{N}")
    public ResponseEntity<List<UserLocation>> getNearestUsers(@PathVariable("N") Long N) {
        List<UserLocation> nearestUsers = userServiceImpl.getNearestUsers(N);
        return new ResponseEntity<List<UserLocation>>(nearestUsers, HttpStatus.OK);
    }
	
	
	
		
		
		
	

}
