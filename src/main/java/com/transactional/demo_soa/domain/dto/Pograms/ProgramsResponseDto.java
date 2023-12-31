package com.transactional.demo_soa.domain.dto.Pograms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class
ProgramsResponseDto implements Serializable {
    private static final long serialVersionUID = 8735757125749188522L;

    private Integer id_program;
    private String name;
    private String type;
    private String beneficiary;
    private String responsible;
    private String description;
    private String duration;
    private String condition;
}
