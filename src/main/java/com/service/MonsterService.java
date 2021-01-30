package com.service;

import com.dto.Monster;
import org.springframework.stereotype.Component;
//import com.repository.MonsterRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonsterService {


    public static Monster create(Monster monster){

        // repository.create(monster.getId(), monster.getName(), monster.getType(), monster.getLevel());
        return monster;
    }

    public static List<Monster> getAll() {

        // repository.getAll();
        List<Monster> monsters = new ArrayList<Monster>(Arrays.asList(new Monster("a","fire")));

        return monsters;
    }

    public static Monster getById(String id) {
        List<Monster> monsters = new ArrayList<Monster>(Arrays.asList(new Monster("a","fire")));
        for (Monster monster : monsters) {
            if (monster.getId().equals(id)) {
                return monster;
            }
        }
        return new Monster("siksok","sik");
    }

    public static boolean levelUp(String id){

        // repository.update(id, "level", selected.getLevel()+1)
        Monster selected = getById(id);
        return true;
    }

    public static boolean changeType(String id, String type){

        // repository.update(id, "type", type);
        return true;
    }

    public static boolean release(String id){

        // repository.delete(id);
        return true;
    }
}
