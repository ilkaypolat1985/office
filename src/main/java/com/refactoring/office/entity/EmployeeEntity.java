package com.refactoring.office.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String city;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OfficeEntity office;
}
