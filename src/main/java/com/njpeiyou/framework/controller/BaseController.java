package com.njpeiyou.framework.controller;

import com.jfinal.core.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangjingping-xes on 2017/4/11.
 */

public class BaseController extends Controller{

    private Object data;
    private Map<String,Object> resultMap = new HashMap<String,Object>();
    public void setResult(String key,Object value){
        resultMap.put(key,value);
    }

    public void setResult(Object value){
        this.data = value;
    }

    public Object getResult(){
        return data == null ? resultMap : data;
    }

    @Override
    public void renderJson(Object object) {
        super.renderJson(object);
    }
}
