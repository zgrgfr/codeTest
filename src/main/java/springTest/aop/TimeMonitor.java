package springTest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * Created by guofengrui on 2017/7/7.
 */

@Service
@Aspect
public class TimeMonitor {
    public void monitorAround() throws Throwable {
        System.out.println("method time:" + System.currentTimeMillis());
    }
}
