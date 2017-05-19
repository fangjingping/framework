package com.njpeiyou.framework.util;

import com.jfinal.kit.HttpKit;
import org.nutz.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by fangjingping-xes on 2017/5/3.
 */
public class RequestUtil {

    public static Map<String, Object> getRequestJson(HttpServletRequest request) {
        String data = HttpKit.readData(request);
        System.out.println("getRequestJson-》data-》："+data);
        Map<String, Object> dataMap = (Map<String, Object>) Json.fromJson(data);
        return dataMap;
    }
}
