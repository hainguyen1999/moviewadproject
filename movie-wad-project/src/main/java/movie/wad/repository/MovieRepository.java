package movie.wad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import movie.wad.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(value="select * from movie m where m.title like %:keyword%", nativeQuery=true)
	List<Movie> findByKeyword(@Param("keyword") String keyword);
	
	
}
