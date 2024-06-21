package edu.kea.exam.atletik.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Deltager deltager;

    @ManyToOne
    private Disciplin disciplin;

    private String resultatType;
    private LocalDate dato;
    private BigDecimal resultatværdi;

    public Resultat(Deltager deltager, Disciplin disciplin, String resultatType, LocalDate dato, BigDecimal resultatværdi) {
        this.deltager = deltager;
        this.disciplin = disciplin;
        this.resultatType = resultatType;
        this.dato = dato;
        this.resultatværdi = resultatværdi;
    }
    
}
