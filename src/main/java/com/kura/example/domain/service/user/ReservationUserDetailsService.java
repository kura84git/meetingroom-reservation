package com.kura.example.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kura.example.domain.model.User;
import com.kura.example.domain.repository.user.UserRepository;

@Service
public class ReservationUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException(username + " is not found!!");
		}
		return new ReservationUserDetails(user);
	}
}
