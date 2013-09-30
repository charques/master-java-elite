package edu.masterjava.spring.tarea03.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class ExampleAspect  {
	
	
	@Pointcut("execution(* edu.masterjava.spring.tarea03.beans.ExampleBean*.*(..))")
    public void businessMethods() { }
 
    @Before("businessMethods()")
    public void before() {
        System.out.println("Before");
    }
    @After("businessMethods()")
    public void after() {
        System.out.println("After");
    }
    @AfterReturning("businessMethods()")
    public void afterReturning() {
        System.out.println("After returning");
    }
    @AfterThrowing("businessMethods()")
    public void afterThrowing() {
        System.out.println("After throwing");
    }
}