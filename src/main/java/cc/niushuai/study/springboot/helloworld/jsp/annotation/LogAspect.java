package cc.niushuai.study.springboot.helloworld.jsp.annotation;

import cc.niushuai.study.springboot.helloworld.enums.LogTypeEnum;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 切点类
 */

@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(cc.niushuai.study.springboot.helloworld.jsp.annotation.Log)")
    public void operationLog() {
    }

    @Before(value = "operationLog()")
    public void beforeOperation(JoinPoint joinPoint) {

        log.info("beforeOperation");
    }

    @After(value = "operationLog()")
    public void afterOperation(JoinPoint joinPoint) {

        log.info("afterOperation");
    }


    /**
     * 得到自定义日志类型
     *
     * @param joinPoint
     * @return
     */
    private LogTypeEnum getLogType(JoinPoint joinPoint) {

        return ((Log) getAnnotation(joinPoint)).logType();
    }

    /**
     * 得到自定义日志内容
     *
     * @param joinPoint
     * @return
     */
    private String getLogContent(JoinPoint joinPoint) {

        return ((Log) getAnnotation(joinPoint)).logContent();
    }

    /**
     * 得到自定义注解
     *
     * @param joinPoint
     * @return
     */
    private Annotation getAnnotation(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotation(Log.class);
    }
}
