package spring.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class GreetingStatisticAspect {

    @Autowired
    protected GreetingStatisticBean statisticBean;

    @Pointcut("execution(* *.sayGreetingIn*(..))")
    private void allSayGreetingMethods() {
    }

    // Pointcut methods must return void
    @Pointcut("execution(* *.getGreeting(..))")
    private void allGetGreetingMethod() {
    }

    @Before("allSayGreetingMethods()")
    public void beforeSayGreeting(JoinPoint joinPoint) {
        System.out.println("Before " + joinPoint.getSignature().getName());
    }

    @Before("allGetGreetingMethod()")
    public void beforeGetGreeting(JoinPoint joinPoint) {
        System.out.println("Before " + joinPoint.getSignature().getName());
        statisticBean.incrementLanguage(joinPoint.getArgs()[0].toString());
        Arrays.asList(joinPoint.getArgs()).forEach(System.out::println);
    }

    // Executed after method returned value and we can intercept result as well
    // TODO how to do it?
    @AfterReturning(pointcut = "allGetGreetingMethod()", returning = "returnedValue")
    public void afterGetGreeting(String returnedValue) {
        System.out.println("Greeting returned " + returnedValue);
        statisticBean.incrementResponse(returnedValue);
    }

    @AfterThrowing(pointcut = "allGetGreetingMethod()", throwing = "ex")
    public void afterGetGreetingThrowException(RuntimeException ex) {
        System.out.println("Aspect got exception " + ex.getMessage());
    }

    // We can even avoid method execution, and return something except it
    // Goo example - security check/cache
    @Around("allGetGreetingMethod()")
    public Object aroundGetGreeting(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around BEFORE");

        if (Math.random() * 100 > 20) {
            return joinPoint.proceed();
        } else {
            return "Kaboo!";
        }
    }

    public void setStatisticBean(GreetingStatisticBean statisticBean) {
        this.statisticBean = statisticBean;
    }
}