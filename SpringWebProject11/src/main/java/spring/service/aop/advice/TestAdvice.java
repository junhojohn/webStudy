package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class TestAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("[before LOG] " + getClass() + ".before() start......");
		System.out.println("[before LOG] targetObject call Method :" + method);
		if(args.length != 0) {
			System.out.println("[before LOG] targetObject Method 전달 argument: " + args[0]);
		}
		System.out.println("[before LOG] " + getClass() + ".before() end......");
	}

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("[after LOG] " + getClass() + ".afterReturning start......");
		System.out.println("[after LOG] targetObject call Method :" + method);
		System.out.println("[after LOG] 타겟 객체 호출 후 returnValue :" + returnValue);
		System.out.println("[after LOG] " + getClass() + ".afterReturning end......");
	}	
	
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("[around before] " + getClass() + ".invoke() start......");
		System.out.println("[around before] targetObject call Method : " + arg0.getMethod());
		if(arg0.getArguments().length != 0) {
			System.out.println("[around before] targetObject Method 전달 argument: " + arg0.getArguments()[0]);
		}
		Object obj = arg0.proceed();
		System.out.println("[around after] 타겟 객체 호출 후 returnValue:" + obj);
		System.out.println("[around after] " + getClass() + ".invoke() end......");
		return null;
	}
	
	public void afterThrowing(Throwable throwable) {
		System.out.println("[exception] " + getClass() + ".afterThrowing() start......");
		System.out.println("[exception] Exception 발생......");
		System.out.println("[exception] Exception Message: " + throwable.getMessage());
		System.out.println("[exception] " + getClass() + ".afterThrowing() end......");
	}
}
