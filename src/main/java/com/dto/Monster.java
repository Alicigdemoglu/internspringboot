package com.dto;

import com.repository.MonsterData;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class Monster {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden=true)
    private String id;

    @NotNull
    @Size(min=2, message="Type should have at least 2 characters")
    private String type;
    @NotNull
    @Size(min=2, message="Name should have at least 2 characters")
    private String name;

    @ApiModelProperty(hidden=true)
    @Value("${level:1}")
    private int level;

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

    public Monster(Monster monsterToClone){
        this.name = monsterToClone.getName();
        this.type = monsterToClone.getType();
        this.level = monsterToClone.getLevel() < 1 ? 1 : monsterToClone.getLevel();
        this.id = monsterToClone.getId() instanceof String ?  monsterToClone.getId() : UUID.randomUUID().toString();
    }

    public Monster() {

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

    @Override
    public final int hashCode() {
        return this.id.hashCode();
    }
}
