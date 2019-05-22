package com.andres.alianzabe.mapper;

import java.util.List;

import org.mapstruct.MappingTarget;

/**
 * @param <T> Entity
 * @param <D> DTO
 */
public interface IMapperGeneric<T, D> {

    T dtoToEntity(D dto);

    D entityToDto(T entity);

    List<D> entityToDto(List<T> entity);

    List<T> dtoToEntity(List<D> dto);

    void mergeToEntity(Object entityOld, @MappingTarget T entityNew);

    void mergeToDtos(Object dtoOld, @MappingTarget D dtoNew);

}
