package gl2.example.films.repository;

import gl2.example.films.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT f FROM Film f WHERE " +
            "(:nom IS NULL OR f.nom LIKE %:nom%)")
    List<Film> findByFilters(@Param("nom") String nom);
    List<Film> findByGenreContainingIgnoreCase(String genre);

}
