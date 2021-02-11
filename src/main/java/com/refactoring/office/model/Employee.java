package com.refactoring.office.model;

import com.refactoring.office.entity.OfficeEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Employee {
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @Size(min = 1, max = 50)
    private String country;

    @NotBlank
    @Size(min = 1, max = 50)
    private String city;

    private OfficeEntity office;
}
