package edu.kea.exam.renameme.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultatDTO {
    private Long id;
    private DeltagerDTO deltager;
    private DisciplinDTO disciplin;
    private String resultatType;
    private LocalDate dato;
    private String resultatværdi;
}
