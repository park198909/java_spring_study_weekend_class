package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureMockMvc
public class Exam01Test {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Unit 테스트 연습!")
    void test1(){
        int result = 10 +20;
        assertEquals(30,result);
    }
    @Test
    @DisplayName("통합 테스트 연습!")
    void test2() throws Exception {
        mockMvc.perform(get("/hello").param("key1","value1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
