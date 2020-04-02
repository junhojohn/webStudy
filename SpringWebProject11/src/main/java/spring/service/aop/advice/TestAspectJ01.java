package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAspectJ01 {

	@Pointcut("execution(public !void get*(..))")
	public void work() {
		
	}
	
	@Before(value="work()")
	public void before(JoinPoint joinPoint) throws Throwable {
		System.out.println("[before LOG] " + getClass() + ".before() start......");
		System.out.println("[before LOG] targetObject call Method :" + joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length != 0) {
			System.out.println("[before LOG] targetObject Method 전달 argument: " + joinPoint.getArgs()[0]);
		}
		System.out.println("[before LOG] " + getClass() + ".before() end......");
	}

	@AfterReturning(value="work()", returning="returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
		System.out.println("[after LOG] " + getClass() + ".afterReturning start......");
		System.out.println("[after LOG] targetObject call Method :" + joinPoint.getSignature().getName());
		System.out.println("[after LOG] 타겟 객체 호출 후 returnValue :" + returnValue);
		System.out.println("[after LOG] " + getClass() + ".afterReturning end......");
	}	
	
	@Around(value="work()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[around before] " + getClass() + ".invoke() start......");
		System.out.println("[around before] targetObject call Method : " + joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length != 0) {
			System.out.println("[around before] targetObject Method 전달 argument: " + joinPoint.getArgs()[0]);
		}
		Object obj = joinPoint.proceed();
		System.out.println("[around after] 타겟 객체 호출 후 returnValue:" + obj);
		System.out.println("[around after] " + getClass() + ".invoke() end......");
		return obj;
	}
	
	@AfterThrowing(value="work()", throwing="throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		System.out.println("[exception] " + getClass() + ".afterThrowing() start......");
		System.out.println("[exception] Exception 발생......");
		System.out.println("[exception] Exception Message: " + throwable.getMessage());
		System.out.println("[exception] " + getClass() + ".afterThrowing() end......");
	}
}
