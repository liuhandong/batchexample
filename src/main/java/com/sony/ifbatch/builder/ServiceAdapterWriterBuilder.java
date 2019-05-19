package com.sony.ifbatch.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sony.ifbatch.adapter.ServiceAdapterWriter;

public class ServiceAdapterWriterBuilder<T,U> {
	
	List<String> list = new ArrayList<>();
	
	Map<String,U> entity = new HashMap<>();
	
	public ServiceAdapterWriterBuilder<T,U> serviceIds(String list) {
		this.list.add(list);
		return this;
	}
	
	public ServiceAdapterWriterBuilder<T,U> entity(U entity,String list) {
		this.entity.put(list, entity);
		return this;
	}
	
	public ServiceAdapterWriter<T,U> builder() {
		ServiceAdapterWriter<T,U> writer = new ServiceAdapterWriter<>();
		writer.setList(list);
		writer.setEntity(entity);
		return writer;
	}

}
