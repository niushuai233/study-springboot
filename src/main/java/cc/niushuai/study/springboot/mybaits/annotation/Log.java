package cc.niushuai.study.springboot.mybaits.annotation;

import cc.niushuai.study.springboot.mybaits.enums.LogTypeEnum;

import java.lang.annotation.*;


/**
 * 自定义注解, 用于存储系统操作
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface Log {

    /**
     * 日志类型 默认其他
     *
     * @return
     */
    public LogTypeEnum logType() default LogTypeEnum.OTHER;

    /**
     * 日志内容
     *
     * @return
     */
    public String logContent() default "";


}
