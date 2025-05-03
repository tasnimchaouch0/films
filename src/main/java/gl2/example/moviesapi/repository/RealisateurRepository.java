package gl2.example.moviesapi.repository;

import gl2.example.moviesapi.model.Film;
import gl2.example.moviesapi.model.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

    public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {
        @Query("SELECT f.nom FROM Film f,Realisateur r WHERE " +
                "( r.nom = f.realisateur.nom and   r.nationalite LIKE %:nationalite%)")
    List<Film> findByNationalite(String nationalite);
    @Query("SELECT f.nom FROM Film f,Realisateur r WHERE " +
            "( r.nom = f.realisateur.nom and   r.nom LIKE %:nom%)")
    List<Film> findByNom(String nom);
    }
