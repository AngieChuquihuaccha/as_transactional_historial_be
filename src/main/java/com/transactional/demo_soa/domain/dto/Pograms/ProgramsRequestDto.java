package com.transactional.demo_soa.domain.dto.Pograms;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProgramsRequestDto implements Serializable {
    private static final long serialVersionUID = 8222253670338491507L;

    private Integer id_program;
    private String name;
    private String type;
    private String beneficiary;
    private String responsible;
    private String description;
    private String condition;
    private String duration;
}
