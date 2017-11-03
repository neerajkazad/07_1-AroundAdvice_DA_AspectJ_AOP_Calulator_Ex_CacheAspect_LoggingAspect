package com.aa.notes;

public class Notes {
	 /**
	  * In this example We are writing Calculator as targetClass and LoggingAspect and CacheAspect as a Aspect class
	  * so in the LoggingAspect we have log() method and inside the CacheAspect we have cache() method so we have to
	  * apply logging and caching as a cross cutting logic.
	  * So we are using AroundAdvice with the help of AspectJ AOP integration with Spring. That's the reason we are 
	  * not implementing our class through Spring AOP provided interface so to avoid those thing we are writing all
	  * those things inside the SpringBeanConfigurationFile(xml file).
	  * 
	  * Overall this is the Declarative AspectJ AOP with Spring Example using AroundAdvice.
	  * 
	  * Explaination:
	  * ------------
	  * 
	  * <aop:config>
	  *	   <aop:aspect ref="loggingAspect" order="2">
	  *		  <aop:around method="log" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	   </aop:aspect>
	  *	
	  *	   <aop:aspect ref="cacheAspect" order="1">
	  *	     <aop:around method="cache" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	   </aop:aspect>
	  *	
	  *  </aop:config>
	  *
	  * If we have more than one advice method then by default in the declarative order advice is going to
	  * advice by the ioc container. so interviewer will ask you 
	  * IQ: I have two advice method and i want to execute the advice method in the order then how it is going to advice
	  * on the target class method?
	  * 
	  * Ex: 
	  * <aop:aspect ref="loggingAspect" order="2">
	  *		<aop:around method="log" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	</aop:aspect>
	  *	
	  *	<aop:aspect ref="cacheAspect" order="1">
	  *	  <aop:around method="cache" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	</aop:aspect>
	  *
	  * A: In the order we declare the advice method in that order it is going to execute. means
	  * first "loggingAspect" and then "cacheAspect". Then interview will ask you no, i don't want
	  * to execute "logginAsepct" first i want cacheAspect to execute first then what you will do?
	  * Then you can tell just reverse the declaration positions.
	  * 
	  * Ex:
	  * <aop:aspect ref="cacheAspect" order="1">
	  *	  <aop:around method="cache" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	</aop:aspect>
	  *
	  * <aop:aspect ref="loggingAspect" order="2">
	  *		<aop:around method="log" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	</aop:aspect>
	  *
	  * then interview tell you no i don't want to do it any other solution is there?
	  * then we have to tell you "order" attribute at the <aop:aspect> tag level so by which we don't need to change 
	  * the declaration postion every time based on the requirement.
	  * See the below code...
	  * Ex:
	  * 
	  * <aop:aspect ref="loggingAspect" order="2">
	  *		<aop:around method="log" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	</aop:aspect>
	  *	
	  *	<aop:aspect ref="cacheAspect" order="1">
	  *	  <aop:around method="cache" pointcut="execution(* com.aa.beans.Calculator.add(..))" />
	  *	</aop:aspect>
	  *
	  * So in the above code we define the order also so in this case first "cacheAsepct" method is advice first then 
	  * after that on the "loggingAsepct" will advice.
	  * 
	  * Note2:
	  * 
	  * If we have commonPointcut then how we can write commonPointCut at one place and use it, because when we are writing 
	  * the same pointcut then our code become duplicated. so to avoid this and reuse the pointcut we are writing the 
	  * 
	  * <aop:pointcut expression="" id="" >
	  * 
	  * Ex:
	  * 
	  * <aop:pointcut expression="execution(* com.aa.beans.Calculator.add(..))" id="commonPointcut"/>
	  *	<aop:aspect ref="loggingAspect" order="2">
	  *		<aop:around method="log" pointcut-ref="commonPointcut" />
	  *	</aop:aspect>
	  *	
	  *	<aop:aspect ref="cacheAspect" order="1">
	  *		<aop:around method="cache" pointcut-ref="commonPointcut" />
	  *	</aop:aspect>
	  *
	  * So First we need to write <aop:pointcut> after that only we have to write <aop:aspect> tag
	  * and inside that in place of pointcut we have to write pointcut-ref="idofcommonpointcut" like how we did on the above
	  * snippet of code.
	  * 
	 */
		
	
}
