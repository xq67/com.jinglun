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

@Aspect
public class AdviceLogAspactJ {
	static Logger log=Logger.getLogger(AdviceLogAspactJ.class);
	
	//Ϊ�˶���ȫ�ֵ�������ʽ
	@Pointcut("execution(* biz..*.*(..))")
	public void xx(){}
	
	//ǰ����ǿ
	@Before("xx()")
	public void before(JoinPoint jp){
		log.info("ǰ����ǿ:����"+jp.getTarget()+
				"��"+jp.getSignature().getName()+
				"(),�����:"+Arrays.toString(jp.getArgs()));
	}
	//��������ִ��û�б���
	@AfterReturning(pointcut="xx()",returning="res")
	public void after(JoinPoint jp,Object res){
		log.info("����ִ�к���ǿ������"+jp.getTarget()+
				"��"+jp.getSignature().getName()+"()����������ֵ��:"+res);
	}
	//�쳣��ǿ
	@AfterThrowing(pointcut="xx()",throwing="e")
	public void excep(JoinPoint jp,Throwable e){
		log.info("�쳣��ǿ������"+jp.getTarget()+
				"��"+jp.getSignature().getName()+"()�������������쳣:"+e.getMessage());
	}
	//������ǿ�����ܷ����Ƿ����쳣����ִ��
	@After("xx()")
	public void ends(JoinPoint jp){
		log.info("������ǿ������"+jp.getTarget()+
				"��"+jp.getSignature().getName()+"()����over");
	}
	//������ǿ�����з���ֵ
//	@Around(value="xx()")
	public Object arround(ProceedingJoinPoint jp){
		Object res=null;
		//ǰ��
		log.info("ǰ����ǿ:����"+jp.getTarget()+
				"��"+jp.getSignature().getName()+
				"(),�����:"+Arrays.toString(jp.getArgs()));
		try {
			//ִ�ж��󷽷�
			res=jp.proceed(jp.getArgs());//����ִ����Ҫִ�еķ�����//void finsstudentByid(1001)
			//������ǿ
			log.info("����ִ�к���ǿ������"+jp.getTarget()+
					"��"+jp.getSignature().getName()+"()����������ֵ��:"+res);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("�쳣��ǿ������"+jp.getTarget()+
					"��"+jp.getSignature().getName()+"()�������������쳣:"+e.getMessage());
		}finally{
			//����
			log.info("������ǿ������"+jp.getTarget()+
					"��"+jp.getSignature().getName()+"()����over");
		}
		return res;
	}
	
}
