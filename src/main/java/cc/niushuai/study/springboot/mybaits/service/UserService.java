package cc.niushuai.study.springboot.mybaits.service;

import cc.niushuai.study.springboot.mybaits.entity.User;

public interface UserService {

    public User findUser(String name);

    public void insertUser(String name, Integer age);

}
