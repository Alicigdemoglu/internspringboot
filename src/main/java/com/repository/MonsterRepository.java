package com.repository;

// Adapted from https://github.com/in28minutes/SpringBootForBeginners/blob/96aac7f51218090c1fa45747b9b48de5e0faabac/05.Spring-Boot-Advanced/src/main/java/com/in28minutes/springboot/jpa/UserRepository.java
// Find and modify: https://www.baeldung.com/spring-data-mongodb-tutorial#6-findandmodify
// Remove https://www.baeldung.com/spring-data-mongodb-tutorial#8-remove
// Find all https://www.baeldung.com/spring-data-mongodb-tutorial#7-findall-with-sort

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MonsterRepository extends MongoRepository<MonsterData, String> {
}