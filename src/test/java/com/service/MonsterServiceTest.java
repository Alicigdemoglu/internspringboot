package com.service;

// Adapted from https://github.com/in28minutes/SpringBootForBeginners/blob/96aac7f51218090c1fa45747b9b48de5e0faabac/04.Mockito-Introduction-In-5-Steps/src/test/java/com/in28minutes/mockito/mockitodemo/SomeBusinessMockAnnotationsTest.java


import static org.mockito.Mockito.when;
import com.dto.Monster;
import com.repository.MonsterData;
import com.repository.MonsterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith (MockitoExtension.class)
public class MonsterServiceTest {

    @Mock
    MonsterRepository monsterRepositoryMock;

    @InjectMocks
    MonsterService monsterService;

    @Test
    public void testGetAllMonsters() {
        Monster monster = new Monster("rock","grass");
        when(monsterRepositoryMock.findAll()).thenReturn(Arrays.asList(new MonsterData(monster)));
        List<Monster> expected = Arrays.<Monster>asList(monster);
        Assertions.assertEquals(expected.get(0).getId(), monsterService.getAll().get(0).getId());
    }

}


