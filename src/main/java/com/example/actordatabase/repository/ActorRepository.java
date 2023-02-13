package com.example.actordatabase.repository;

import com.example.actordatabase.model.Actor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ActorRepository {
    private List<Actor> actorList = new ArrayList<>() {{
        add(new Actor(1, "Bud Spencer", "Piedone", "slap", "Piedone"));
        add(new Actor(2, "Lisa Kudrow", "Pheobe", "Smelly Cat", "Friends"));
    }};

    public void addActor(Actor actor) {
        actor.setId(actorList.get(actorList.size() - 1).getId() + 1);
        actorList.add(actor);
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public Actor getActor(int id) {
        return actorList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

}
