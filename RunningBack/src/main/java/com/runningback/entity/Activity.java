package com.runningback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private String images;

    private String type;

    private float distance;

    @Column(nullable = false)
    private Time time;

    private Time pace;

    private int calories;

    private int pulse;

    @ManyToOne
    @JoinColumn(name = "effort_id")
    private Effort effort;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shoes_id")
    private Shoes shoes;

    private String location;

    @Temporal(TemporalType.DATE)
    private Date date;

}
