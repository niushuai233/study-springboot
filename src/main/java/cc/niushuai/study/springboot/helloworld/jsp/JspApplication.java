/**
 * 
 * @Description: <br>
 * @author Shuai_GG <br>
 * @QQ: 1225803134 <br>
 * @Email: niushuai981101@gmail.com <br>
 * @Date 2018年9月10日 下午4:22:50 <br>
 * @Version 1.0
 */

package cc.niushuai.study.springboot.helloworld.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan("cc.niushuai.study.springboot.helloworld.jsp.controller")
public class JspApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JspApplication.class, args);
	}

}
