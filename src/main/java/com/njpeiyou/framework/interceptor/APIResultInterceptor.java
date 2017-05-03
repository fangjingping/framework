package com.njpeiyou.framework.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.njpeiyou.framework.controller.BaseController;
import com.njpeiyou.framework.exception.BusinessException;
import com.njpeiyou.framework.exception.RedirectException;
import com.njpeiyou.framework.util.BaseConst;
import com.njpeiyou.framework.util.RenderUtil;

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
            RenderUtil.renderSuccess(controller, controller.getResult());
        } catch (RedirectException e) {
            return;
        } catch (BusinessException e) {
            RenderUtil.renderFail(controller, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            RenderUtil.renderFail(controller, e.getMessage());
        }
    }



}
