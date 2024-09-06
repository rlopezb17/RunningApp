package com.runningback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {

    private int id;
    private String title;
    private String description;
    private float distance;
    private String time;
    private String pace;
    private int calories;
    private int pulse;
    private Date date;

    // RELACIONES
    private TypeDto type;
    private EffortDto effort;

}
