package com.sony.ifbatch.sample.adapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;

public class ServiceAdapterReader<T> extends AbstractItemCountingItemStreamItemReader<T> implements InitializingBean {

	private String queryId;

	//private SqlSessionFactory sqlSessionFactory;
	//private SqlSession sqlSession;

	private Map<String, Object> parameterValues;

	private Cursor<T> cursor;
	private Iterator<T> cursorIterator;

	@Override
	protected T doRead() throws Exception {
		T next = null;
		if (cursorIterator.hasNext()) {
			next = cursorIterator.next();
		}
		return next;
	}

	@Override
	protected void doOpen() throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		if (parameterValues != null) {
			parameters.putAll(parameterValues);
		}

//		sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
//		cursor = sqlSession.selectCursor(queryId, parameters);
		cursorIterator = cursor.iterator();
	}

	@Override
	protected void doClose() throws Exception {
		if (cursor != null) {
			cursor.close();
		}
//		if (sqlSession != null) {
//			sqlSession.close();
//		}
		cursorIterator = null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * Public setter for {@link SqlSessionFactory} for injection purposes.
	 *
	 * @param sqlSessionFactory a factory object for the {@link SqlSession}.
	 */
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		//this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * Public setter for the statement id identifying the statement in the SqlMap
	 * configuration file.
	 *
	 * @param queryId the id for the statement
	 */
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	/**
	 * The parameter values to be used for the query execution.
	 *
	 * @param parameterValues the values keyed by the parameter named used in the
	 *                        query string.
	 */
	public void setParameterValues(Map<String, Object> parameterValues) {
		this.parameterValues = parameterValues;
	}

}
