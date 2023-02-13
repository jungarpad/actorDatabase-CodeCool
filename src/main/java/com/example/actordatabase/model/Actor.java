package com.example.actordatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Actor {
    private int id;
    private String name;
    private String famousRole;
    private String specialSkill;
    private String bestMovie;
}
