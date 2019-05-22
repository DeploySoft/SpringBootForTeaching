package com.andres.alianzabe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private MetaData meta;
    //PODRIA SER UNA LISTA DE PARAMETRO <T> PARA VOLVERLA MAS GENERICO
    private List<UserDto> data;
}
