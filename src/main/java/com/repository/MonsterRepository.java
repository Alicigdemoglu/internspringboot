package com.repository;

// Adapted from https://github.com/in28minutes/SpringBootForBeginners/blob/96aac7f51218090c1fa45747b9b48de5e0faabac/05.Spring-Boot-Advanced/src/main/java/com/in28minutes/springboot/jpa/UserRepository.java
// Find and modify: https://www.baeldung.com/spring-data-mongodb-tutorial#6-findandmodify
// Remove https://www.baeldung.com/spring-data-mongodb-tutorial#8-remove
// Find all https://www.baeldung.com/spring-data-mongodb-tutorial#7-findall-with-sort
//import java.util.List;
//
//import com.dto.Monster;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
////@RepositoryRestResource(collectionResourceRel = "monster", path = "monster")
//public interface MonsterRepository extends MongoRepository<Monster, String> {
//
//    List<Monster> getAllMonsters();
//    Monster getMonsterByID(@Param("id") String id);
//    Monster updateMonsterByID(@Param("id") String id);
//
//}
//

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.repository.MonsterData;

public interface MonsterRepository extends MongoRepository<MonsterData, String> {


}