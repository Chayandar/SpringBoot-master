package com.example.autospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AutoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllAutos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/auto")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAutoById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/auto/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindAutoByModel() throws Exception {
        String model = "Марк 2";
        mockMvc.perform(MockMvcRequestBuilders.get("/auto/find")
                        .param("model", model)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddAuto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/auto")
                        .content("{ \"marka\": \"Тойота\", \"model\": \"Марк 2\", \"nalichie\": \"Да\", \"sena\": \"52000\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateAuto() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.put("/auto/" + id)
                        .content("{ \"marka\": \"Обновленный\", \"model\": \"Обновленный\", \"nalichie\": \"Обновленный\", \"sena\": \"53000\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAuto() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/auto/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}