package com.refactoring.office.model.mapper;

import com.refactoring.office.entity.OfficeEntity;
import com.refactoring.office.model.Office;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OfficeMapper {
    OfficeMapper INSTANCE = Mappers.getMapper( OfficeMapper.class );

    Office toModel(final OfficeEntity officeEntity);
    OfficeEntity toEntity(final Office office);
}
