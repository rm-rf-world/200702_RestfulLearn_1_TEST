package com.yichaoinc.RESTfulLearn.controller;

import com.yichaoinc.RESTfulLearn.Message;



import com.yichaoinc.RESTfulLearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mybatis")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "param")
    public String param(@RequestParam(value = "id",
            defaultValue = "10001") String id){
        int idX = Integer.parseInt(id);
        String passwordX = userService.getUserPassword(idX);
        return passwordX;
    }


    @GetMapping(value = "paramx")
    public Message paramx(@RequestParam(value = "username",
            defaultValue = "Boot") String username){
        return new Message("success",
                "Hello," + username,
                101);
    }

    @RequestMapping("json")
    public Message helloJson(){
        return new Message("success",
                "Hello my fucking SB by json",100);
    }
}
