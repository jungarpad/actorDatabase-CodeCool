package com.example.actordatabase.service;

import com.example.actordatabase.dto.ActorDto;
import com.example.actordatabase.model.Actor;
import com.example.actordatabase.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getActors() {
        return actorRepository.getActorList();
    }

    public void addActor(ActorDto actorDto) {
        Actor actor = new Actor(1, actorDto.getName(), actorDto.getFamousRole(), actorDto.getSpecialSkill());
        actorRepository.addActor(actor);
    }

    public Actor findActorById(int id){
        return actorRepository.getActor(id);
    }
}
