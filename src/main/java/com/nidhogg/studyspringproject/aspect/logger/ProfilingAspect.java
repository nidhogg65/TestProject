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

    @Pointcut("@annotation(com.nidhogg.studyspringproject.annotation.ProfilePerformance)")
    private void atProfiledMethod() {
    }

    @Pointcut("@within(com.nidhogg.studyspringproject.annotation.ProfilePerformance)")
    private void atProfiledClass() {
    }

    @Around("atProfiledMethod() || atProfiledClass()")
    public Object profileMethod(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch(getClass().getSimpleName());

        try {
            stopWatch.start(pjp.getSignature().getName());
            return pjp.proceed();

        } finally {
            stopWatch.stop();
            log.info(classMethodString(pjp) + " method invocation has taken " + stopWatch.getTotalTimeMillis() + " milliseconds.");
        }
    }

    private String classMethodString(ProceedingJoinPoint pjp) {
        return pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName();
    }

}
