package com.user.userRepository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.entity.UserLocation;

@Repository
public interface UserRepository extends CrudRepository<UserLocation, Serializable>  {

	@Query("SELECT u FROM UserLocation u WHERE u.excluded = false ORDER BY " +
	           "SQRT((u.latitude * u.latitude) + (u.longitude * u.longitude)) ASC")
	    List<UserLocation> findNearestUsers(@Param("N") Long N);

}
