package gl2.example.moviesapi.model;

import jakarta.persistence.*;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    @ManyToOne
    @JoinTable(

            joinColumns = @JoinColumn(name = "realisateur_id")
    )
    private Realisateur realisateur;
    private String genre;

    public Film() {}

    public Film(String nom, Realisateur realisateur, String genre) {
        this.nom = nom;
        this.realisateur = realisateur;
        this.genre = genre;
    }

    // Getters and Setters
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

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
