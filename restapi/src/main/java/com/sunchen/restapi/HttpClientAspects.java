package com.sunchen.restapi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.Resource;

/**
 * HttpClientProxy:
 *
 * @author sunchen
 * @date 2020/9/6 3:21 下午
 */
@Aspect
public class HttpClientAspects {
    @Pointcut("execution(* com.sunchen.restapi.*.*(..))")
    public void pointCut(){

    }
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try{
            result = joinPoint.proceed();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
