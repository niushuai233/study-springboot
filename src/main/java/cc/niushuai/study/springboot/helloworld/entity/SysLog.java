package cc.niushuai.study.springboot.helloworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysLog {

    private String id;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志内容
     */
    private String content;

    /**
     * 方法参数
     */
    private String params;

    /**
     * 请求ip
     */
    private String ip;

    /**
     * 本次请求使用的操作系统
     */
    private String operatingSystem;

    /**
     * 本次请求使用的设备
     */
    private String deviceType;

    /**
     * 本次请求使用的浏览器
     */
    private String browser;

    /**
     * 本次请求访问时间
     */
    private Date createDate;

}
