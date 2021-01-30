package com.repository;

import com.dto.Monster;
import com.querydsl.core.annotations.QueryEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.UUID;


@QueryEntity
@Document
public class MonsterData {

    @Id
    private String id;

    private String type;
    private int level;
    private String name;
    private String created;

    public MonsterData(Monster monster) {
        this.id = monster.getId();
        this.type = monster.getType();
        this.level = monster.getLevel();;
        this.name = monster.getName();
        this.created = new Date().toString();

    }

    @PersistenceConstructor
    public MonsterData(final String name, final String type, final int level, final String id) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.id = id;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

}
