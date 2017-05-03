package com.njpeiyou.framework.util;

import com.njpeiyou.framework.controller.BaseController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangjingping-xes on 2017/5/3.
 */
public class RenderUtil {

    public static void renderSuccess(BaseController c, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", BaseConst.CODE_SUCCESS);
        result.put("data", data);
        c.renderJson(result);
    }
    public static void renderFail(BaseController c, String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", BaseConst.CODE_FAIL);
        result.put("msg", msg);
        c.renderJson(result);
    }
}
