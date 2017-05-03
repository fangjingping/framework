package com.njpeiyou.framework.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.njpeiyou.framework.controller.BaseController;
import com.njpeiyou.framework.util.BaseConst;
import com.njpeiyou.framework.util.RenderUtil;
import com.njpeiyou.framework.util.Validator;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * Created by fangjingping-xes on 2017/4/11.
 */
public class ValidatorInterceptor implements Interceptor {
    public void intercept(Invocation inv) {
        BaseController controller = (BaseController)inv.getController();

        Annotation[] annotations = inv.getMethod().getAnnotationsByType(com.njpeiyou.framework.annotation.Validator.class);
        for (Annotation annotation : annotations) {
            try {
                com.njpeiyou.framework.annotation.Validator customValidator = (com.njpeiyou.framework.annotation.Validator) annotation;
                String paramName = customValidator.paramName();
                String[] paramNames = customValidator.paramNames();

                Class[] customValidateClasses = customValidator.validateClass();
                for (Class customValidateClass : customValidateClasses) {
                    Validator validator = (Validator) customValidateClass.newInstance();

                    Boolean validateResult = true;
                    String errmsg = null;
                    if(!"null".equals(paramName)) {
                        validateResult = validator.validate(controller.getPara(paramName));
                        errmsg = validator.getErrorMsg(paramName);
                    } else if(!"null".equals(paramNames)){
                        //Lambda 将参数值 通过controller.getPara拿到新建的String[]中。
                        String[] paramValues = Arrays.stream(paramNames).map(name -> controller.getPara(name)).toArray(String[]::new);
                        validateResult = validator.validate(paramValues);
                        errmsg = validator.getErrorMsg(paramNames);
                    }


                    if (!validateResult) {
                        APIResultInterceptor apiResultInterceptor = new APIResultInterceptor();
                        RenderUtil.renderFail(controller,errmsg);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                RenderUtil.renderFail(controller, BaseConst.MSG_FAIL);
                return;
            }
        }

        inv.invoke();
    }
}
