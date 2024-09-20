package com.runningback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private int weight;
    private int height;
    private String token;

    //RELACIONES
    private CountryDto country;
    private List<ActivityDto> activities;
    private List<ShoesDto> shoes;

}
