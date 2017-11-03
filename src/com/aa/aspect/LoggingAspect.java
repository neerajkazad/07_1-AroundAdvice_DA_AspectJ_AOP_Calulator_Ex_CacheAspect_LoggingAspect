package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//Cross Cutting logic class[Aspect Class]
public class LoggingAspect {
	
	//Advice method
	public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String methodName = null;
		Object[] args = null;
		
		methodName = proceedingJoinPoint.getSignature().getName();
		args = proceedingJoinPoint.getArgs();
		
		//cross-cutting logic before calling to target class method
		System.out.print("Entering into "+methodName+"(");
		for(int i=0;i<args.length;i++) {
			if(i==0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print(","+args[i]);
		}		
		System.out.println(")");
		
		//call target class method
		Object ret = proceedingJoinPoint.proceed();
		
		//cross cutting logic after calling target class method
		System.out.println("Exiting from "+methodName + " with ret "+ret);
		
		return ret;
	}
}
