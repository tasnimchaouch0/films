package gl2.example.moviesapi.controller;

import gl2.example.moviesapi.model.Film;
import gl2.example.moviesapi.model.Realisateur;
import gl2.example.moviesapi.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/realisateurs")
public class RealisateurController {

    @Autowired
    private RealisateurService realisateurService;

    @GetMapping
    public List<Realisateur> getAllRealisateurs() {
        return realisateurService.getAllRealisateurs();
    }

    @GetMapping("/{id}")
    public Optional<Realisateur> getRealisateurById(@PathVariable Long id) {
        return realisateurService.getRealisateurById(id);
    }

    @PostMapping
    public Realisateur addRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.addRealisateur(realisateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRealisateur(@PathVariable Long id) {
        realisateurService.deleteRealisateur(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Realisateur> updateRealisateur(
            @PathVariable Long id,
            @RequestBody Realisateur realisateur) {

        Optional<Realisateur> existing = realisateurService.getRealisateurById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        realisateur.setId(id);
        Realisateur updated = realisateurService.addRealisateur(realisateur); // assuming this handles updates
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/filter/realisateur/nationalite/{nationalite}")
    public List<Film> filterByNationaliteRealisateur(@PathVariable String nationalite) {
        System.out.println("Filtering with nationalité de realisateur=" + nationalite);
        return realisateurService.filterByNationaliteRealisateur(nationalite);
    }

    @GetMapping("/filter/realisateur/nom/{nom}")
    public List<Film> filterByNomRealisateur(@PathVariable String nom) {
        System.out.println("Filtering with nom de realisateur=" + nom);
        return realisateurService.filterByNomRealisateur(nom); // assuming this method exists
    }
}
