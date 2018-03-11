package advice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class AdviceLog {
	
	static Logger log=Logger.getLogger(AdviceLog.class);
	//前置增强
	public void before(JoinPoint jp){
		log.info("前置增强:调用"+jp.getTarget()+
				"的"+jp.getSignature().getName()+
				"(),入参是:"+Arrays.toString(jp.getArgs()));
	}
	//方法正常执行没有报错
	public void after(JoinPoint jp,Object res){
		log.info("正常执行后增强：调用"+jp.getTarget()+
				"的"+jp.getSignature().getName()+"()方法，返回值是:"+res);
	}
	//异常增强
	public void excep(JoinPoint jp,Throwable e){
		log.info("异常增强：调用"+jp.getTarget()+
				"的"+jp.getSignature().getName()+"()方法，发生了异常:"+e.getMessage());
	}
	//最终增强，不管方法是否发生异常都会执行
	public void ends(JoinPoint jp){
		log.info("最终增强：调用"+jp.getTarget()+
				"的"+jp.getSignature().getName()+"()方法over");
	}
	//环绕增强必须有返回值
	public Object arround(ProceedingJoinPoint jp){
		Object res=null;
		//前置
		log.info("前置增强:调用"+jp.getTarget()+
				"的"+jp.getSignature().getName()+
				"(),入参是:"+Arrays.toString(jp.getArgs()));
		try {
			//执行对象方法
			res=jp.proceed(jp.getArgs());//具体执行需要执行的方法。//void finsstudentByid(1001)
			//后置增强
			log.info("正常执行后增强：调用"+jp.getTarget()+
					"的"+jp.getSignature().getName()+"()方法，返回值是:"+res);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("异常增强：调用"+jp.getTarget()+
					"的"+jp.getSignature().getName()+"()方法，发生了异常:"+e.getMessage());
		}finally{
			//最终
			log.info("最终增强：调用"+jp.getTarget()+
					"的"+jp.getSignature().getName()+"()方法over");
		}
		return res;
	}
	
}
