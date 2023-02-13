package com.example.actordatabase.controller;

import com.example.actordatabase.dto.ActorDto;
import com.example.actordatabase.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actors")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public String actors(Model model) {
        model.addAttribute("actors", actorService.getActors());
        return "index";
    }

    @PostMapping
    public String addActor(@RequestParam("name") String name,
                           @RequestParam("famousRole") String famousRole,
                           @RequestParam("specialSkill") String specialSkill,
                           @RequestParam("bestMovie") String bestMovie) {

        actorService.addActor(new ActorDto(name, famousRole, specialSkill, bestMovie));
        return "redirect:/actors";
    }

    @GetMapping("/{id}")
    public String getActor(@PathVariable("id") int id, Model model){
        model.addAttribute("actor", actorService.findActorById(id));
        return "actor";
    }
}
