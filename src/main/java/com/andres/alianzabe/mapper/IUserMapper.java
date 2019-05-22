package com.andres.alianzabe.mapper;


import com.andres.alianzabe.domain.User;
import com.andres.alianzabe.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IUserMapper extends IMapperGeneric<User, UserDto> {

}
