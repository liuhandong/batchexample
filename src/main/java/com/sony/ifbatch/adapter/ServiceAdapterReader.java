package com.sony.ifbatch.adapter;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;

public class ServiceAdapterReader<T> extends AbstractItemCountingItemStreamItemReader<T> implements InitializingBean {
	
	private List<T> list;

	private Iterator<T> listIterator;
	
	public ServiceAdapterReader() {
		setName("ServiceAdapterReaderContext");
	}

	@Override
	protected T doRead() throws Exception {		
		T next = null;
		
		if (listIterator.hasNext()) {
			next = listIterator.next();
		}
		return next;
	}

	@Override
	protected void doOpen() throws Exception {
		listIterator = list.iterator();
	}

	@Override
	protected void doClose() throws Exception {
		list = null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
