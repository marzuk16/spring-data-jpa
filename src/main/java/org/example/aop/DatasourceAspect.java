package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatasourceAspect {
    @Around("target(org.example.config.PersistenceConfig)")
    public Object loadDataSourceConnectionInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("DataSource tracker: " + joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
