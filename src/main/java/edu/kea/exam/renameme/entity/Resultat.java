package edu.kea.exam.renameme.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String resultatværdi;
}
