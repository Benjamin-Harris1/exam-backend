package edu.kea.exam.atletik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disciplin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String navn;
    private String resultatType;

    @ManyToMany(mappedBy = "discipliner")
    private List<Deltager> deltagere;

    private boolean isActive;

    public Disciplin(String navn, String resultatType) {
        this.navn = navn;
        this.resultatType = resultatType;
    }

    public Disciplin(Long id, String navn, String resultatType){
        this.id = id;
        this.navn = navn;
        this.resultatType = resultatType;
    }

    public Disciplin(String navn, String resultatType, boolean isActive) {
        this.navn = navn;
        this.resultatType = resultatType;
        this.isActive = isActive;
    }

}
