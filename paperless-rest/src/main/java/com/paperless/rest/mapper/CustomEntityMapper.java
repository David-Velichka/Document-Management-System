package com.paperless.rest.mapper;

import com.paperless.rest.dal.entity.CustomEntity;
import com.paperless.rest.dto.CustomEntityDto;
import com.paperless.rest.service.model.CustomEntityModel;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * MapStruct mapper decoupling CustomEntity across presentation, business, and persistence layers.
 */
@Mapper(componentModel = "spring")
public interface CustomEntityMapper {

    // DTO <-> BL Model
    CustomEntityDto toDto(CustomEntityModel model);
    CustomEntityModel toModel(CustomEntityDto dto);
    List<CustomEntityDto> toDtoList(List<CustomEntityModel> models);

    // BL Model <-> DAL Entity
    CustomEntity toEntity(CustomEntityModel model);
    CustomEntityModel toModel(CustomEntity entity);
    List<CustomEntityModel> toModelList(List<CustomEntity> entities);
}
