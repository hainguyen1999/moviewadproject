package movie.wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movie.wad.model.Actor;


@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{

}
