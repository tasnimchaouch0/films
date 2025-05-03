package gl2.example.moviesapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String  nationalite;
    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "realisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;
    public Realisateur() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    public String getNationalite() {
        return nationalite;
    }

}
