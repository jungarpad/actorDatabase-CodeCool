package com.example.actordatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActorDto {
    private String name;
    private String famousRole;
    private String specialSkill;
}
