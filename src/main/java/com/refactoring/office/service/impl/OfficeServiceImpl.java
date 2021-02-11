package com.refactoring.office.service.impl;

import com.refactoring.office.exception.NotFoundException;
import com.refactoring.office.model.Office;
import com.refactoring.office.model.mapper.OfficeMapper;
import com.refactoring.office.repository.OfficeRepository;
import com.refactoring.office.service.OfficeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeServiceImpl(final OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public List<Office> getAll() {
        return officeRepository.findAll().stream()
                .map(OfficeMapper.INSTANCE::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Office getById(Integer id) {
        return officeRepository.findById(id)
                .map(OfficeMapper.INSTANCE::toModel)
                .orElseThrow(() -> new NotFoundException("Office not found! " + id));
    }

    @Override
    public void save(Office office) {
        officeRepository.save(OfficeMapper.INSTANCE.toEntity(office));
    }

    @Override
    public void update(Office office) {
        officeRepository.save(OfficeMapper.INSTANCE.toEntity(office));
    }
}
