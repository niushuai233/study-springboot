package cc.niushuai.study.springboot.mybaits.controller;

import cc.niushuai.study.springboot.mybaits.entity.User;
import cc.niushuai.study.springboot.mybaits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public void insertUser(String name, Integer age){
        userService.insertUser(name, age);
    }

    @RequestMapping("/findUser")
    public User findUser(String name){
        return userService.findUser(name);
    }

}
