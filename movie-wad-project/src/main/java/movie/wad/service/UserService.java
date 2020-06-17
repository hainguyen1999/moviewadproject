package movie.wad.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import movie.wad.model.*;
import movie.wad.webdto.UserRegistrationDto;


public interface UserService extends UserDetailsService{
	
	User findByEmail(String email);
	
	User save(UserRegistrationDto registration);
	
	
}
