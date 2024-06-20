package edu.kea.exam.renameme.entity;

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
public class Deltager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String navn;
    private String køn;
    private int alder;
    private String klub;

    @ManyToMany
    private List<Disciplin> discipliner;


    public Deltager(String navn, String køn, int alder, String klub, List<Disciplin> discipliner) {
        this.navn = navn;
        this.køn = køn;
        this.alder = alder;
        this.klub = klub;
        this.discipliner = discipliner;
    }


}
