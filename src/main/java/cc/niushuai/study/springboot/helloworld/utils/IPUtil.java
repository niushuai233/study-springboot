package cc.niushuai.study.springboot.helloworld.utils;

import cn.hutool.http.HttpUtil;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {

    public static String getClientIP(HttpServletRequest request){
        return HttpUtil.getClientIP(request);
    }
}
