package com.service;

import com.dto.Monster;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        return monster;
    }

    public List<Monster> getAll() {
        List<MonsterData> allMonsterData = monsterRepository.findAll();
        List<Monster> allMonsters = new ArrayList<Monster>();
        allMonsterData.forEach((monsterData) -> allMonsters.add(new Monster(monsterData)));

        return allMonsters;
    }

    public Monster getById(String id) {
        MonsterData monsterData = monsterRepository.findById(id).orElse(null);
        if(monsterData != null){
           return new Monster(monsterData);
        } else {
            return null;
        }
    }

    public Monster levelUp(String id){
        MonsterData monsterData = monsterRepository.findById(id).orElse(null);
        if(monsterData != null){
            monsterData.setLevel(monsterData.getLevel()+1);
            monsterRepository.save(monsterData);
            return new Monster(monsterData);
        } else {
            return null;
        }
    }

    public Monster changeType(String id, String type){
        MonsterData monsterData = monsterRepository.findById(id).orElse(null);
        if(monsterData != null){
            monsterData.setType(type);
            monsterRepository.save(monsterData);
            return new Monster(monsterData);
        } else {
            return null;
        }
    }

    public boolean release(String id){
        MonsterData monsterData = monsterRepository.findById(id).orElse(null);
        if(monsterData != null){
            monsterRepository.delete(monsterData);
            return true;
        } else {
            return false;
        }
    }
}
