package com.sony.ifbatch.builder;

import java.util.List;

import com.sony.ifbatch.adapter.ServiceAdapterReader;

public class ServiceAdapterReaderBuilder<T> {
	
	private List<T> list;
	
	public ServiceAdapterReaderBuilder<T> list(List<T> list) {
		this.list = list;
		return this;
	}
	
	
	public ServiceAdapterReader<T> build() {
		ServiceAdapterReader<T> reader = new ServiceAdapterReader<>();
		reader.setList(list);
	    return reader;
	  }

}
