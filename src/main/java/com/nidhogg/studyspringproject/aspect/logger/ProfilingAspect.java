package com.nidhogg.studyspringproject.aspect.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@Aspect
public class ProfilingAspect {

    @Pointcut("execution(* registerNewUser(..))")
    private void profileUserRegistration() {
    }

    @Pointcut("within(com.nidhogg.studyspringproject.application.service..*)")
    private void inService() {
    }

    @Around("profileUserRegistration() && inService()")
    public Object profileMethod(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch(getClass().getSimpleName());

        stopWatch.start(pjp.getSignature().getName());
        Object result = pjp.proceed();
        stopWatch.stop();

        log.info(classMethodString(pjp) + " method invocation has taken " + stopWatch.getTotalTimeMillis() + " milliseconds.");
        return result;
    }

    private String classMethodString(ProceedingJoinPoint pjp) {
        return pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName();
    }


}
