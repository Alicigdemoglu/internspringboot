package com.dto;

import com.repository.MonsterData;

import java.util.UUID;

public class Monster {

    private String type;
    private int level;
    private String name;
    private String id;

    public Monster(MonsterData monsterData) {
        this.id = monsterData.getId();
        this.type = monsterData.getType();
        this.level = monsterData.getLevel();
        this.name = monsterData.getName();
    }

    public Monster(String name, String type){
        this.name = name;
        this.type = type;
        this.level = 1;
        this.id = UUID.randomUUID().toString();
    }

    public Monster(String name, String type, int level){
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public String getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }



    @Override
    public String toString() {
        return "Monster [id=" + id + ", type=" + type + ", name="
                + name + ", level=" + level +"]";
    }
}
