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
    private RealisateurRepository realisateurRepository;

    public List<Realisateur> getAllRealisateurs() {
        return realisateurRepository.findAll();
    }

    public Optional<Realisateur> getRealisateurById(Long id) {
        return realisateurRepository.findById(id);
    }

    public Realisateur addRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    public void deleteRealisateur(Long id) {
        realisateurRepository.deleteById(id);
    }

    public List<Film> filterByNationaliteRealisateur(String nationalite) {
        return realisateurRepository.findByNationalite(nationalite);
    }

    public List<Film> filterByNomRealisateur(String nom) {
        return realisateurRepository.findByNom(nom);
    }
}
