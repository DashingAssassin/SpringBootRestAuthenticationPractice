package com.docker.springauth.config;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.docker.springauth.model.User;
import com.docker.springauth.service.MongoUserRepository;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Component
public class MongoUserDetailsService implements UserDetailsManager {

	@Autowired
	private MongoUserRepository mongoUserRepository;

//	@Autowired
//	private MongoDatabase mongoDatabase;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =mongoUserRepository.findByUsername(username);
				
				//mongoDatabase.getCollection("user").find(Filters.eq("username", username), User.class)
				//.first();
		if (null == user) {
			throw new UsernameNotFoundException("UserDoes not exist in our system ");
		}
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USERO"));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}

	@Override
	public void createUser(UserDetails user) {
		try {
			mongoUserRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword())));
//			mongoDatabase.getCollection("user")
//					.insertOne(new User(user.getUsername(), passwordEncoder.encode(user.getPassword())));
			// mongoUserRepository.save(new User(user.getUsername(),
			// passwordEncoder.encode(user.getPassword())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
