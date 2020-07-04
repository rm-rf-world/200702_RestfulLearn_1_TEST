package com.yichaoinc.RESTfulLearn.service;

import com.yichaoinc.RESTfulLearn.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public String getUserPassword(int id){
        return userMapper.findUserPassword(id);
    }
}
