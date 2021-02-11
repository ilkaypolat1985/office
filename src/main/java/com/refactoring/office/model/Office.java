package com.refactoring.office.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Office {
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @Size(min = 1, max = 50)
    private String city;
}
