package cc.niushuai.study.springboot.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController 为微服务提供返回json格式数据
public class MethodController {

	@RequestMapping("/memberIndex")
	public String memberIndex() {

		return "Hello SpringBoot 2.0";
	}
}
