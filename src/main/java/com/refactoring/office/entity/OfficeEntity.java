package com.refactoring.office.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Office")
public class OfficeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String name;

    @Column
    public String city;
}
