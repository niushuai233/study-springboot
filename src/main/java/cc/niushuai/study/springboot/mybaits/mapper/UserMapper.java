package cc.niushuai.study.springboot.mybaits.mapper;

import cc.niushuai.study.springboot.mybaits.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface UserMapper {

    @Select(value = "select * from t_user where name = #{name}")
    public User findUser(@Param("name") String name);

    @Insert(value = "insert into t_user(name,age) values(#{name},#{age})")
    public void insertUser(@Param("name") String name, @Param("age") Integer age);

}
