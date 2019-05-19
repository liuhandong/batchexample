package com.sony.ifbatch.adapter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.adapter.AbstractMethodInvokingDelegator.InvocationTargetThrowableWrapper;
import org.springframework.batch.item.adapter.DynamicMethodInvocationException;
import org.springframework.batch.item.adapter.HippyMethodInvoker;
import org.springframework.batch.support.transaction.TransactionAwareProxyFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.MethodInvoker;

import com.sony.app.Application;

public class ServiceAdapterWriter<F,T> implements ItemWriter<F>, InitializingBean {
	
	List<String> list;
	
	Map<String,T> entity;

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	/**
	 * Create a new configured instance of {@link MethodInvoker}.
	 */
	private MethodInvoker createMethodInvoker(Object targetObject, String targetMethod,Object[] arguments) {
		HippyMethodInvoker invoker = new HippyMethodInvoker();
		invoker.setTargetObject(targetObject);
		invoker.setTargetMethod(targetMethod);
		invoker.setArguments(arguments);
		return invoker;
	}
	
	/**
	 * Prepare and invoke the invoker, rethrow checked exceptions as unchecked.
	 * @param invoker configured invoker
	 * @return return value of the invoked method
	 */
	@SuppressWarnings("unchecked")
	private T doInvoke(MethodInvoker invoker) throws Exception {
		try {
			invoker.prepare();
		}
		catch (ClassNotFoundException | NoSuchMethodException e) {
			throw new DynamicMethodInvocationException(e);
		}

		try {
			return (T) invoker.invoke();
		}
		catch (InvocationTargetException e) {
			if (e.getCause() instanceof Exception) {
				throw (Exception) e.getCause();
			}
			else {
				throw new InvocationTargetThrowableWrapper(e.getCause());
			}
		}
		catch (IllegalAccessException e) {
			throw new DynamicMethodInvocationException(e);
		}
	}

	@Override
	public void write(List<? extends F> items) throws Exception {
		
		List<F> output = TransactionAwareProxyFactory.createTransactionalList();
		
		for(String cm:list) {
			int position = cm.lastIndexOf(".");
			String methodName=cm.substring(position+1);
			String className=cm.substring(0,position);
			int classposition = className.lastIndexOf(".");
			String sampleName = className.substring(classposition+1);

			for(F t:items) {
				output.add(t);			
				doInvoke(createMethodInvoker(Application.context.getBean(firstLowerCase(sampleName)), methodName,new Object[] {new Convertor<F,T>(entity.get(cm)).convert(t)}));
			}
		}
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setEntity(Map<String,T> entity) {
		this.entity = entity;
	}
	
	public static String firstLowerCase(String realName) {
		Boolean flag = isUpperOrLowerCase(realName.charAt(0));
		if (flag != null && flag) {
			char[] cs = realName.toCharArray();
			StringBuffer stringBuffer = new StringBuffer();
			int i = 0;
			for (char c : cs) {
				if (i++ == 0) {
					char temp = (char) (c + 32);
					stringBuffer.append(String.valueOf(temp));
				}else {
					stringBuffer.append(String.valueOf(c));
				}
			}

			return stringBuffer.toString();

		}else if(flag != null && !flag){
			return realName;
		}else {
			return null;
		}
	}

	public static Boolean isUpperOrLowerCase(char c){

		int cint = c - 0;

		if (cint <= 90 && cint >= 65) {
			return true;
		}else if (cint <= 122 && cint >= 97) {
			return false;
		}else {
			return null;
		}
	}

}

class Convertor<F, T>{
	T entity;
	public Convertor(T entity) {
		this.entity = entity;
	}
	
	public T convert(F f) {		
		BeanUtils.copyProperties(f, entity);
		return entity;
	}
}
