package com.andres.alianzabe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    @NotNull
    @Size(min = 3, max = 100)
    private String userName;

    @Column(name = "userPhone")
    @Size(min = 2, max = 200)
    private String userPhone;

    @Column(name = "userEmail")
    @Size(min = 2, max = 200)
    private String userEmail;

    @Column(name = "userStartDate")
    private LocalDate userStartDate;

    @Column(name = "userEndDate")
    private LocalDate userEndDate;


}
