package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodCallTracker {

    @Pointcut("within(org..service.*) || within(org..dao.*)")
    public void logMethodPointCut(){

    }

    //When the logic here should run before/after/before or after
    @Before("logMethodPointCut()")
    public void logBeforeMethodCall(){
        System.out.println("Method Is Starting.....");

    }

    //When the logic here should run before/after/before or after
    @After("logMethodPointCut()")
    public void logAfterMethodCall(){
        System.out.println("Method Execution Completed.....");

    }

    //When the logic here should run before/after/before or after
    @Around("logMethodPointCut()") // combined of after and before
    public Object logBeforeAndAfterMethodCall(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Method: " + joinPoint.getSignature().getName() + " Started");
        Object returnValue = joinPoint.proceed();
        System.out.println(returnValue);

        System.out.println("Method: " + joinPoint.getSignature().getName() + " Ended.");

        return returnValue;
    }
}
