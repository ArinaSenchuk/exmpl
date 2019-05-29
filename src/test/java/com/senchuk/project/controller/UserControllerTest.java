package com.senchuk.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senchuk.project.model.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest  extends RuntimeException {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getUserSuccessful() throws Exception {
        mockMvc.perform(get("/get/5"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUserUnsuccessful() throws Exception {
        mockMvc.perform(get("/get/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteUserSuccessful() throws Exception {
        mockMvc.perform(delete("/delete/5"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUserUnsuccessful() throws Exception {
        mockMvc.perform(delete("/delete/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateUserSuccessful() throws Exception {
        UserDto user = new UserDto(5, "name");
        mockMvc.perform(put("/update").content(objectMapper.writeValueAsString(user)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateUserUnsuccessful() throws Exception {
        UserDto user = new UserDto(1, "name");
        mockMvc.perform(put("/update").content(objectMapper.writeValueAsString(user)).contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void createUserSuccessful() throws Exception {
        UserDto user = new UserDto( "name");
        mockMvc.perform(post("/create").content(objectMapper.writeValueAsString(user)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }





}
