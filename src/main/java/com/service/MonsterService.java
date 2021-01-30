package com.service;

import com.dto.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import com.repository.MonsterRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.repository.MonsterData;
import com.repository.MonsterRepository;

@Component
public class MonsterService {

    private final MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public Monster create(Monster monster){
        monsterRepository.save(new MonsterData(monster));
        // repository.create(monster.getId(), monster.getName(), monster.getType(), monster.getLevel());
        return monster;
    }

    public List<Monster> getAll() {
        List<MonsterData> allMonsterData = monsterRepository.findAll();
        List<Monster> allMonsters = new ArrayList<Monster>();
        allMonsterData.forEach((monsterData) -> allMonsters.add(new Monster(monsterData)));

        return allMonsters;
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

    public static Monster levelUp(String id){

        // repository.updateLevel(id, "level", selected.getLevel()+1)
        Monster modifiedMon = getById(id);
        return modifiedMon;
    }

    public static Monster changeType(String id, String type){

        // repository.update(id, "type", type);
        Monster modifiedMon = getById(id);
        return modifiedMon;
    }

    public static boolean release(String id){

        // repository.delete(id);
        return true;
    }
}
