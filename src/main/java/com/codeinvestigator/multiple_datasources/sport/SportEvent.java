package com.codeinvestigator.multiple_datasources.sport;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class SportEvent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String eventname;
    @Column
    private String description;

    public static SportEvent of(String event, String description){
        SportEvent weather = new SportEvent();
        weather.description = description;
        weather.eventname = event;
        return weather;
    }
}
