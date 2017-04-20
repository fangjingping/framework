package com.njpeiyou.framework.interceptor;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by fangjingping-xes on 2017/4/6.
 */
public class CrossOriginInterceptor implements Interceptor{
    public void intercept(Invocation inv) {
        inv.getController().getResponse().setHeader("Access-Control-Allow-Origin","*");
        inv.invoke();
    }
}
