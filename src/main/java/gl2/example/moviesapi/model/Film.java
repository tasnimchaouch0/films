package gl2.example.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String genre;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    @JsonIgnore // Prevent full Realisateur object from being serialized
    private Realisateur realisateur;

    public Film() {}

    public Film(String nom, Realisateur realisateur, String genre) {
        this.nom = nom;
        this.realisateur = realisateur;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    // 👇 Expose only the realisateur's id in JSON
    @JsonProperty("realisateurId")
    public Long getRealisateurId() {
        return realisateur != null ? realisateur.getId() : null;
    }
}
