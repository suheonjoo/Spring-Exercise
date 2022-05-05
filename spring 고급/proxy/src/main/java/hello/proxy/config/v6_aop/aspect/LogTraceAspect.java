package hello.proxy.config.v6_aop.aspect;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class LogTraceAspect {


    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }


    @Around("execution(* hello.proxy.app..*(..))")//포인트컷
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {//이 함수가 어드바이스 //포인트컷, 어드바이스 합쳐서 어드바이져
       TraceStatus status = null;

       //joinpoint에서 아래와 같은 것들 다 확인 가능함
       log.info("target={}", joinPoint.getTarget());  //실제 호출 대상
       log.info("getArgs={}", joinPoint.getArgs()); //전달인자
       log.info("getSignature={}", joinPoint.getSignature()); //join point

       try {
           String message = joinPoint.getSignature().toShortString();
           status = logTrace.begin(message);

           //로직 호출
           Object result = joinPoint.proceed();

           logTrace.end(status);
           return result;
       } catch (Exception e) {
           logTrace.exception(status, e);
           throw e;
       }
    }
}