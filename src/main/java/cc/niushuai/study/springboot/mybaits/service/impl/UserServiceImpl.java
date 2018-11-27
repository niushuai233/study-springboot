package cc.niushuai.study.springboot.mybaits.service.impl;

import cc.niushuai.study.springboot.mybaits.entity.User;
import cc.niushuai.study.springboot.mybaits.mapper.UserMapper;
import cc.niushuai.study.springboot.mybaits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(String name) {
        return userMapper.findUser(name);
    }

    @Override
    public void insertUser(String name, Integer age) {
        userMapper.insertUser(name, age);
    }

}
