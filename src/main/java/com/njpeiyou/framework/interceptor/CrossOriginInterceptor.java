package com.njpeiyou.framework.interceptor;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by fangjingping-xes on 2017/4/6.
 */
public class CrossOriginInterceptor implements Interceptor{
    public void intercept(Invocation inv) {
        inv.getController().getResponse().setHeader("Access-Control -Allow-Origin","*");
        inv.getController().getResponse().setHeader("Access-Control-Allow-Methods", "GET,PUT,DELETE,OPTIONS");
//        inv.getController().getResponse().setHeader("Access-Control-Allow-Headers", "Content-Type");
//        inv.getController().getResponse().setHeader("Access-Control-Allow-Headers", "Accept,Origin,XRequestedWith,Content-Type,LastModified,content-type");
        inv.getController().getResponse().setHeader("Access-Control-Allow-Headers", "content-type");
        inv.invoke();
    }
}
