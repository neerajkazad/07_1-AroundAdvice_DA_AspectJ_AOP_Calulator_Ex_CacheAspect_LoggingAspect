package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.aa.util.Cache;

//Aspect class
public class CacheAspect {
	private Cache cache;

	//Advice Method
	public Object cache(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		String methodName = null;
		Object[] args = null;
		String key = null;

		methodName = proceedingJoinPoint.getSignature().getName();
		args = proceedingJoinPoint.getArgs();
		key = methodName + "(";
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				key += args[i];
				continue;
			}
			key += "," + args[i];
		}
		key += ")";
		//System.out.println("Key : " + key);
		if (cache.containsKey(key) == true) {
			// If data is there inside the cache don't execute target class
			// method rather return the value from the cache
			return cache.get(key);
		}

		// data is not found in the cache so execute target class method
		Object ret = proceedingJoinPoint.proceed();

		// store the data inside the cache
		cache.put(key, ret);

		return ret;

	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

}
