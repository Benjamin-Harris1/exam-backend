package edu.kea.exam.atletik.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeltagerDTO {
    private Long id;
    private String navn;
    private String køn;
    private int alder;
    private String klub;
    private List<DisciplinDTO> discipliner;
}
