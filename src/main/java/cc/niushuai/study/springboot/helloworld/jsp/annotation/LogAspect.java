package cc.niushuai.study.springboot.helloworld.jsp.annotation;

import cc.niushuai.study.springboot.helloworld.entity.SysLog;
import cc.niushuai.study.springboot.helloworld.utils.IPUtil;
import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.OperatingSystem;
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
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 切点类
 */

@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(cc.niushuai.study.springboot.helloworld.jsp.annotation.Log)")
    public void log() {
    }

    @Before(value = "log()")
    public void before(JoinPoint joinPoint) {
        SysLog logEntity = getLogEntity(joinPoint);

        String log = JSONObject.toJSONString(logEntity);

        System.out.println(log);
    }

    @After(value = "log()")
    public void after(JoinPoint joinPoint) {


    }

    /**
     * 添加日志记录
     *
     * @param joinPoint
     */
    private SysLog getLogEntity(JoinPoint joinPoint) {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();

            SysLog log = new SysLog();

            //得到ip地址
            String ip = IPUtil.getClientIP(request);
            log.setIp(ip);
            //得到日志类型
            log.setType(getLogType(joinPoint));
            //得到自定义日志内容
            log.setContent(getLogContent(joinPoint));
            //得到参数列表内容
            log.setParams(getParams(joinPoint));

            UserAgent userAgent = new UserAgent(request.getHeader("user-agent"));

            OperatingSystem operatingSystem = userAgent.getOperatingSystem();
            //操作系统
            log.setOperatingSystem(operatingSystem.getName());
            //设备类型 电脑 手机 平板...
            log.setDeviceType(operatingSystem.getDeviceType().getName());
            //浏览器类型
            String browser = userAgent.getBrowser().getName();
            //浏览器版本
            String browserVersion = userAgent.getBrowserVersion().getVersion();
            log.setBrowser(browser + " " + browserVersion);

            log.setCreateDate(new Date());

            return log;
        } catch (Exception e) {
            log.error("记录日志信息出错", e.getMessage());
        }
        return null;
    }

    /**
     * 得到方法的参数列表 并转换为json
     * @param joinPoint
     * @return
     */
    private String getParams(JoinPoint joinPoint) {
        Object[] obj = joinPoint.getArgs();
        StringBuffer buffer = new StringBuffer();
        if (obj != null) {
            for (int i = 0; i < obj.length; i++) {
                buffer.append("[参数" + (i + 1) + ":");
                Object o = obj[i];
                if (o instanceof Model) {
                    continue;
                }
                String parameter = null;
                try {
                    parameter = JSONObject.toJSONString(o);
                } catch (Exception e) {
                    continue;
                }
                buffer.append(parameter);
                buffer.append("]");
            }
        }

        return buffer.toString();
    }


    /**
     * 得到自定义日志类型
     *
     * @param joinPoint
     * @return
     */
    private String getLogType(JoinPoint joinPoint) {

        return ((Log) getAnnotation(joinPoint)).logType().getValue();
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
