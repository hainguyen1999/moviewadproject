package movie.wad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import movie.wad.model.Genre;
import movie.wad.model.Movie;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
