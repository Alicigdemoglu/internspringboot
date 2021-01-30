package com.api;

// Adapted from https://github.com/in28minutes/SpringBootForBeginners/blob/96aac7f51218090c1fa45747b9b48de5e0faabac/04.Mockito-Introduction-In-5-Steps/src/test/java/com/in28minutes/mockito/mockitodemo/SomeBusinessMockAnnotationsTest.java


import com.dto.Monster;
import com.repository.MonsterData;
import com.repository.MonsterRepository;
import com.service.MonsterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith (MockitoExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
public class MonsterControllerTest {

    @Mock
    MonsterRepository monsterRepositoryMock;

    @InjectMocks
    MonsterService monsterService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToCreateAndValidMonster_thenCorrectResponse() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String monster = "{\"type\": \"fire\", \"name\" : \"watermonster\"}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(monster))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(textPlainUtf8))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        // Check UUID Regex Match for ID
        assertTrue(response.matches("Monster ID: [a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}"));
    }

    @Test
    public void whenPostRequestToCreateAndInvalidMonster_thenThrowError() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        // Input less than 2 characters
        String monster = "{\"type\": \"s\", \"name\" : \"n\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(monster))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}


