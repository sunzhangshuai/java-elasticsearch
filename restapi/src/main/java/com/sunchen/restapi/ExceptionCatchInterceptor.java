package com.sunchen.restapi;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Proxy:
 *
 * @author sunchen
 * @date 2020/9/6 3:41 下午
 */
public class ExceptionCatchInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object o1 = null;
        try{
            o1 = methodProxy.invokeSuper(o, objects);
        }catch (Exception e){
            e.printStackTrace();
        }
        return o1;
    }
}
