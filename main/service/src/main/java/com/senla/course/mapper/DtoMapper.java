package com.senla.course.mapper;

import java.util.List;

public interface DtoMapper<T, DTO> {

    DTO toDto(T entity);

    T toEntity(DTO dto);

    List<DTO> toDtoList(List<T> entities);

    List<T> toEntityList(List<DTO> dtoList);

}
