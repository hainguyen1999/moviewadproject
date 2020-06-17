package movie.wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movie.wad.model.Director;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{

}
