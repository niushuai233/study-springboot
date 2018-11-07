/**
 * 
 * @Description: <br>
 * @author Shuai_GG <br>
 * @QQ: 1225803134 <br>
 * @Email: niushuai951101@gmail.com <br>
 * @Date 2018年9月10日 下午5:27:13 <br>
 * @Version 1.0
 */

package cc.niushuai.study.springboot.helloworld.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//异常扫描包
@ControllerAdvice(basePackages = "cc.niushuai.study.springboot.helloworld.exception.controller")
public class GlobalHandlerException {

	//将map转为json
	@ResponseBody
	//捕捉运行时异常
	@ExceptionHandler(RuntimeException.class)
	public Map<String, Object> errorResult() {
		Map map = new HashMap();
		map.put("code", "500");
		map.put("msg", "系统错误");

		return map;
	}

}
