package gl2.example.films.controller;

import gl2.example.films.model.Film;
import gl2.example.films.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> film = filmService.getFilmById(id);
        return film.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        return filmService.addFilm(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(
            @PathVariable Long id,
            @RequestBody Film film) {

        Optional<Film> existing = filmService.getFilmById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        film.setId(id);
        Film updated = filmService.addFilm(film);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Film> patchFilm(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        Optional<Film> existing = filmService.getFilmById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Film film = existing.get();

        if (updates.containsKey("nom")) {
            film.setNom((String) updates.get("nom"));
        }

        if (updates.containsKey("realisateur")) {
            film.setRealisateur((String) updates.get("realisateur"));
        }

        if (updates.containsKey("genre")) {
            film.setGenre((String) updates.get("genre"));
        }

        Film updated = filmService.addFilm(film);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/filter/{nom}")
    public List<Film> filterFilms(@PathVariable(required = false) String nom) {
        System.out.println("Filtering with nom=" + nom);
        return filmService.filterFilms(nom);
    }
    @GetMapping("/filter/genre/{genre}")
    public List<Film> filterByGenre(@PathVariable String genre) {
        System.out.println("Filtering with genre=" + genre);
        return filmService.filterByGenre(genre);
    }


}
