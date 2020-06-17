package movie.wad.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movie.wad.model.Role;
import movie.wad.model.User;
import movie.wad.repository.UserRepository;
import movie.wad.webdto.UserRegistrationDto;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstname(registration.getFirstname());
        user.setLastname(registration.getLastname());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("role_user")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRoles()));
    }

	private Collection<? extends GrantedAuthority > mapRolesToAuthorities(Collection <Role> roles) {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    }
}