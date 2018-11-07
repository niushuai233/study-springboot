/**
 * 
 * @Description: <br>
 * @author Shuai_GG <br>
 * @QQ: 1225803134 <br>
 * @Email: niushuai951101@gmail.com <br>
 * @Date 2018年9月10日 下午4:36:41 <br>
 * @Version 1.0
 */

package cc.niushuai.study.springboot.helloworld.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	
	@RequestMapping("/jspIndex")
	public String indexJsp() {
		
		return "indexOfJsp";
	}

}
