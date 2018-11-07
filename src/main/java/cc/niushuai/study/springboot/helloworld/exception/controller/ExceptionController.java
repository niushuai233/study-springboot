/**
 * 
 * @Description: <br>
 * @author Shuai_GG <br>
 * @QQ: 1225803134 <br>
 * @Email: niushuai951101@gmail.com <br>
 * @Date 2018年9月10日 下午4:52:06 <br>
 * @Version 1.0
 */

package cc.niushuai.study.springboot.helloworld.exception.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
	
	@RequestMapping("/add")
	public String getResult(int i, int j) {

		return "result=" + (i / j);
	}
}
