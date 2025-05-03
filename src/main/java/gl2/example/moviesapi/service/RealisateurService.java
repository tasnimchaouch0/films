package gl2.example.moviesapi.service;

import gl2.example.moviesapi.model.Realisateur;
import gl2.example.moviesapi.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gl2.example.moviesapi.model.Film;
import java.util.List;
import java.util.Optional;

@Service
public class RealisateurService {
    @Autowired
    private static RealisateurRepository realisateurRepository;
    public static List<Realisateur> getAllRealisateurs() {
        return realisateurRepository.findAll();
    }
    public static Optional<Realisateur> getRealisateurById(Long id) {
        return realisateurRepository.findById(id);
    }

    public static Realisateur addRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);

    }

    public static void deleteRealisateur(Long id) {
        realisateurRepository.deleteById(id);
    }
    public static List<Film> filterByNationaliteRealisateur(String nationalite) {
        return realisateurRepository.findByNationalite(nationalite);
    }
    public static List<Film> filterByNomRealisateur(String nom) {
        return realisateurRepository.findByNom(nom);
    }


}
