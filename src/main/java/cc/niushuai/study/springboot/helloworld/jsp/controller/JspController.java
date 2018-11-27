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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {

    private static final Logger logger = LoggerFactory.getLogger(JspController.class);

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
            logger.info("this is info level log");
            logger.debug("this is debug level log");
            logger.error("this is error level log");
            logger.warn("this is warn level log");
            logger.trace("this is trace level log");
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

}
