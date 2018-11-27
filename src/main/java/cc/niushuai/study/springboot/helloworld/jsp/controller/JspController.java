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

import cc.niushuai.study.springboot.helloworld.enums.LogTypeEnum;
import cc.niushuai.study.springboot.helloworld.jsp.annotation.Log;
import cc.niushuai.study.springboot.helloworld.jsp.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class JspController {

    @RequestMapping("/jspIndex")
    @ResponseBody
	public String indexJsp() {

        /**
         * 需要指定日志级别 否则不能全部输出 默认级别为info
         *
         * 打印日志信息从多到少排序为
         * trace > debug > info > warn > error
         *
         */
        //测试日志文件归档
        int i = 1;
        while (i-->0) {
            log.info("this is info level log");
            log.debug("this is debug level log");
            log.error("this is error level log");
            log.warn("this is warn level log");
            log.trace("this is trace level log");
        }
		return "indexOfJsp";
	}

	@Log(logContent = "测试log操作", logType = LogTypeEnum.OTHER)
	@RequestMapping("/testLog")
    @ResponseBody
	public String testLog(){

	    return "testLog";
    }

    @Log(logContent = "测试testLogWithArgs操作", logType = LogTypeEnum.OTHER)
	@RequestMapping("/testLogWithArgs")
    @ResponseBody
	public String testLogWithArgs(String arg){

	    return "testLogWithArgs";
    }

    @Autowired
    private TestService testService;

    @RequestMapping("/testAysnc")
    @ResponseBody
    public String testAysnc() {
        log.info("1");
        String result = testService.testAsync();
        log.info("4");
        return result;
    }

    @Value("${httpurl}")
    private String url;

    @RequestMapping("/getUrl")
    @ResponseBody
    public String getUrl(){
        return url;
    }
}
