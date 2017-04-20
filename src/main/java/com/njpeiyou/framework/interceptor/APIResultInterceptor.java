package com.njpeiyou.framework.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.njpeiyou.framework.controller.BaseController;
import com.njpeiyou.framework.exception.BusinessException;
import com.njpeiyou.framework.util.BaseConst;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangjingping-xes on 2017/4/12.
 */
public class APIResultInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        BaseController controller = (BaseController) inv.getController();
        try {
            inv.invoke();
            renderSuccess(controller, controller.getResult());
            return;
        } catch (BusinessException e) {
            renderFail(controller, e.getMessage());
            return;
        } catch (Exception e) {
            e.printStackTrace();
            renderFail(controller, e.getMessage());
            return;
        }
    }


    private void renderSuccess(BaseController c, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", BaseConst.CODE_SUCCESS);
        result.put("data", data);
        c.renderJson(result);
    }

    public void renderFail(BaseController c, String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", BaseConst.CODE_FAIL);
        result.put("msg", msg);
        c.renderJson(result);
    }
}
