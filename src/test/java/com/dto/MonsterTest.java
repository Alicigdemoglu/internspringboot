package com.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MonsterTest {

    @Test
    public void testGetFields() {
        Monster monster = new Monster("rock","grass");
        Assertions.assertEquals(monster.getType(), "grass");
        Assertions.assertEquals(monster.getName(), "rock");
    }

}
