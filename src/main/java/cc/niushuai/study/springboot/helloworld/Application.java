package cc.niushuai.study.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cc.niushuai.study.springboot.helloworld.controller")
@EnableAutoConfiguration // 自动配置 扫描范围为当前类
// @SpringBootApplication //一键配置
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
	
}
