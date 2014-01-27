package org.au.dynamicflame.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * AOPLogging.java - Uses AspectJ to add logging messages around method calls. Logs the method execution time, class and
 * method names, arguments and return values.
 * 
 * @author Alasdair
 * @since 26/01/2014
 */
@Component
@Aspect
public class AOPLogging {

    private static final Logger LOGGER = Logger.getLogger("AOPLogging");

    /**
     * logTimeMethod - Logs method details on entry and exit of methods. Records class name, method name and arguements
     * as well as execution time in ms.
     * 
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* org.au.dynamicflame..*.*(..))")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object retVal = joinPoint.proceed();

        stopWatch.stop();

        StringBuffer logMessage = new StringBuffer();
        logMessage.append(joinPoint.getTarget().getClass().getName());
        logMessage.append(".");
        logMessage.append(joinPoint.getSignature().getName());
        logMessage.append("(");
        // append args
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }

        logMessage.append(")");
        logMessage.append(" execution time: ");
        logMessage.append(stopWatch.getTotalTimeMillis());
        logMessage.append(" ms");
        LOGGER.info(logMessage.toString());
        return retVal;
    }

}
