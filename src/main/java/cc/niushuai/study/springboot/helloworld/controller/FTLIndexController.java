/**
 * 
 * @Description: <br>
 * @author TheodoreShuai <br>
 * @QQ: 1225803134 <br>
 * @Email: niushuai981101@gmail.com <br>
 * @Date 2018年9月10日 下午3:00:44 <br>
 * @Version 1.0
 */

package cc.niushuai.study.springboot.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FTLIndexController {

	@RequestMapping("/ftlIndex")
	public String ftlIndex(Model model) {

		model.addAttribute("name", "牛帅");
		model.addAttribute("age","121");
		model.addAttribute("sex", "boy");
		
		return "ftlIndex";
	}

	@RequestMapping("/msg")
	@ResponseBody
	public String msg() {
		return "Ftl Message.";
	}
	
}
