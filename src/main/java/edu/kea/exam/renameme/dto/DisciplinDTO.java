package edu.kea.exam.renameme.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinDTO {
    private Long id;
    private String navn;
    private String resultatType;
}
