package cc.niushuai.study.springboot.mybaits;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
/**
 * 一换三
 */
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan("cc.niushuai.study.springboot.mybaits")
@MapperScan("cc.niushuai.study.springboot.mybaits.mapper")
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class);
        System.out.println();
    }
}
