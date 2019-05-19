package com.sony.ifbatch.partitioner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class ConditionPartitioner implements Partitioner{

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();
		
		//query service
		
		ExecutionContext value = new ExecutionContext();
        value.putString("param0", "sample0");
        result.put("partition", value);
        return result;
	}

}
