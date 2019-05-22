package com.andres.alianzabe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotNull
    private String userName;
    @NotNull
    private String userPhone;
    private String userEmail;
    private LocalDate userStartDate;
    private LocalDate userEndDate;

}