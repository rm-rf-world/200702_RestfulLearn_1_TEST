package com.yichaoinc.RESTfulLearn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = HelloApplication.class)
@AutoConfigureMockMvc
class HelloSpringBootTest {

    @Autowired
    private MockMvc mvc;


    @Test
    void byebyeString() throws Exception{
        // URL 和 验证返回内容的代码在 mvc.perform 中
        // andExpect 对返回结果进行验证，如果不正确将视为测试案例运行失败
        this.mvc.perform(get("/byebye/string")).andExpect(status().isOk())
                .andExpect(content().string("Byebye Spring Boot"));

    }

    @Test
    void helloJson() throws Exception {
        this.mvc.perform(get("/hello/json")).andExpect(status().isOk())
                .andExpect(content().json("{'status':'success';'messages':'Hello Spring Boot By JSON'}"));
    }


    @Test
    void param() {
    }

    @Test
    void pathVariable() throws Exception{
        this.mvc.perform(post("/hello/path/xiaoxian")).andExpect(status().isOk())
                .andExpect(content().json("{'status':'success';'messages':'Hello xiaoxian'}"));
    }

    @Test
    void body() {
    }

    @Test
    void formX() throws Exception{
        // contentType 指定上传数据的类型
        // param(key,value) 参数的key和 value 值
        this.mvc.perform(post("/hello/form")
                .contentType("application/x-www-form-urlencoded")
                .param("username", "user")
                .param("password", "springboot"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'status':'success';'messages':'Login  Success'}"));

    }
}