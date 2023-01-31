package com.dsoumaila.integrationtestingh2;

import com.dsoumaila.integrationtestingh2.repository.UserRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
        @Sql(value = "classpath:sql/reset-user.sql", executionPhase = BEFORE_TEST_METHOD),
        @Sql(value = "classpath:sql/user-insert-data.sql", executionPhase = BEFORE_TEST_METHOD)
})
public class UserControllerTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_create_user() throws Exception {
        final File jsonFile = new ClassPathResource("sql/user.json").getFile();
        final String userToCreate = Files.readString(jsonFile.toPath());

        mockMvc.perform(post("/users/create")
                        .contentType(APPLICATION_JSON)
                        .content(userToCreate))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("$", aMapWithSize(3)));

        assertThat(userRepository.findAll()).hasSize(6);
    }

    @Test
    void should_retrieve_all_users() throws Exception {
        this.mockMvc.perform(get("/users/fetch-all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[2].id").value(3))
                .andExpect(jsonPath("$.[3].id").value(4))
                .andExpect(jsonPath("$.[4].id").value(5));
    }

    @Test
    void should_retrieve_one_user() throws Exception {
        this.mockMvc.perform(get("/users/{id}", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("Julien Mael"))
                .andExpect(jsonPath("$.email").value("laura.royer@yahoo.fr"));
    }

    @Test
    void should_delete_one_user() throws Exception {
        this.mockMvc.perform(delete("/users/{id}/delete", 2))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertThat(userRepository.findAll()).hasSize(4);
    }
}
