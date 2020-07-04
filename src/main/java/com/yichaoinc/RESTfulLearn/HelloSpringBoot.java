package com.yichaoinc.RESTfulLearn;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.handler.MessageContext;

@RestController
@RequestMapping("byebye")
public class HelloSpringBoot {
    @RequestMapping("string")
    @ResponseStatus(HttpStatus.OK)
    public String byebyeString(){
        return "Byebye Spring Boot";
    }

    @RequestMapping("json")
    public Message helloJson(){
        return new Message("success",
                "Hello my fucking SB by json",100);
    }

    @GetMapping(value = "param")
    public Message param(@RequestParam(value = "username",
            defaultValue = "Boot") String username){
        return new Message("success",
                "Hello," + username,
                101);
    }

    @PostMapping(value = "path/{username}")
    public Message pathVariable(@PathVariable("username") String username){
        return new Message("success","Hello"+username,102);
    }

    @PostMapping("body")
    public Message body(@RequestBody SysUser sysUser){
        Message message = new Message();
        if(sysUser.getUsername()!=null && sysUser.getPassword()!=null &&
                sysUser.getUsername().equals("user")&&
                sysUser.getPassword().equals("springboot!")){
            message.setStatus("success");
            message.setMessages("Login success");
            message.setId(999);//如果注释掉了默认是会返回0
        }else{
            message.setStatus("error");
            message.setMessages("Login fail");
            message.setId(000);
        }
        return message;
    }

    @PostMapping("form")
    public Message formX(SysUser sysUser){
        Message message = new Message();
        if(sysUser.getUsername()!=null && sysUser.getPassword()!=null &&
                sysUser.getUsername().equals("user")&&
                sysUser.getPassword().equals("springboot!")){
            message.setStatus("success");
            message.setMessages("Login success");
            message.setId(999);//如果注释掉了默认是会返回0
        }else{
            message.setStatus("error");
            message.setMessages("Login fail");
            message.setId(000);
        }
        return message;
    }



}
