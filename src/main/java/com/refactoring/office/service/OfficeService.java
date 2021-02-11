package com.refactoring.office.service;

import com.refactoring.office.model.Office;

import java.util.List;

public interface OfficeService {
    List<Office> getAll();
    Office getById(Integer id);
    void save(Office office);
    void update(Office office);
}
