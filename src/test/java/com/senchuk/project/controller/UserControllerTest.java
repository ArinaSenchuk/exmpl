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

//FIXME add abstract test class and move annotations to it

//FIXME everywhere add final before reference variable

//FIXME where get users as list?

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest  extends RuntimeException {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //FIXME use GIVEN, WHEN, THEN approach
    //FIXME substitute Successful with _happyPath

    @Test
    public void getUserSuccessful() throws Exception {

        //FIXME where assert that returned model has id 5?

        mockMvc.perform(get("/get/5"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //FIXME there could be lots of unsuccessful outcomes

    @Test
    public void getUserUnsuccessful() throws Exception {
        mockMvc.perform(get("/get/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    //FIXME on delete should be no content not ok

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

        //FIXME code should be less then 110 symbols

        //FIXME add asserts

        mockMvc.perform(put("/update").content(objectMapper.writeValueAsString(user)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateUserUnsuccessful() throws Exception {
        UserDto user = new UserDto(1, "name");
        mockMvc.perform(put("/update").content(objectMapper.writeValueAsString(user)).contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    //FIXME on post should be created not ok

    @Test
    public void createUserSuccessful() throws Exception {
        UserDto user = new UserDto( "name");

        //FIXME add asserts

        mockMvc.perform(post("/create").content(objectMapper.writeValueAsString(user)).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }





}
