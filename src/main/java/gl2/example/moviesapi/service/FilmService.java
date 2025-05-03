package gl2.example.moviesapi.service;

import gl2.example.moviesapi.model.Film;
import gl2.example.moviesapi.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    public List<Film> filterFilms(String nom) {
        return filmRepository.findByFilters(nom);
    }
    public List<Film> filterByGenre(String genre) {
        return filmRepository.findByGenreContainingIgnoreCase(genre);
    }
    public List<Film> filterByRealisateur(String nomRealisateur) {
        return filmRepository.findByRealisateurIgnoreCase(nomRealisateur);
    }


}
