package com.user.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserLocation;
import com.user.userServiceImpl.UserServiceImpl;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	

	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserLocation>> getUserLocation(){
		List<UserLocation> user=userServiceImpl.getAllUser();
		return  new ResponseEntity<List<UserLocation>>(user, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/get_users/{N}")
	public ResponseEntity<UserLocation> getUsers(@PathVariable("N") Long id){
		UserLocation userById = userServiceImpl.getUserById(id);
		return new ResponseEntity<UserLocation>(userById, HttpStatus.OK);
		}
	
	//add user data or update data
	@PostMapping("/update_data")
	public ResponseEntity<UserLocation> addUser(@RequestBody UserLocation userLocation){
		UserLocation updateUser=null;
		try {
			 updateUser = userServiceImpl.addorUpdateUser(userLocation);
		}catch(Exception e) {
			e.getMessage();
		}
		return  new ResponseEntity<UserLocation>(updateUser, HttpStatus.OK);	
	}
	
	
	@DeleteMapping("/delete_data/{N}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long N){
		 userServiceImpl.deleteUser(N);
		 String msg="Deleted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	
	
	

}
