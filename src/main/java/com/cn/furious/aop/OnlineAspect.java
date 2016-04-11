package com.cn.furious.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cn.furious.json.result.ResultJB;
import com.cn.furious.utils.CodeEnum;


@Aspect
@Order(10)
public class OnlineAspect {

    @Around("execution(public * com.cn.furious.resource.*.* (..) )")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
    	//如果是注册和登陆,就放行
    	Signature signature = joinPoint.getSignature();  
    	MethodSignature methodSignature = (MethodSignature) signature;  
    	Method method = methodSignature.getMethod();  
    	if(method.getName().startsWith("regist") || method.getName().startsWith("login")){
    		return joinPoint.proceed();
    	}
    	
    	//拦截
    	Object[] args = joinPoint.getArgs();
    	Object user = null;
    	for(Object arg : args){
    		//如果session中有user就放行
    		if(arg instanceof HttpSession){
    			user = ((HttpSession)arg).getAttribute("user");
    			if(user == null){
    				String returName = joinPoint.getSignature().toString().split(" ")[0];
    				//如果是重定向
    				if(returName.equals(String.class.getSimpleName())){
    					return "user/login";
        			//如果是ajax请求
    				}else if(returName.equals(ResultJB.class.getSimpleName())){
    					ResultJB rBean = new ResultJB();
    					rBean.code = CodeEnum.ERROR_LOGIC.code;
    					rBean.message = "你没有登陆";
    					return rBean;
    				}	
    			}
    			return joinPoint.proceed();
    		}
    	}
    	ResultJB rBean = new ResultJB();
		rBean.code = CodeEnum.ERROR_SYS.code;
		return user;
    }
}
