package movie.wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movie.wad.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}