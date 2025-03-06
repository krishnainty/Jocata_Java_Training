package com.jocata.sms.persistence;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface EntityManager {
	
	public void save(Class clazz, Object entity);
	
	public List<Object> get(Class clazz);
	
	public Object get(Class clazz, Object primaryKeyName, Object primaryKeyValue);
	
	public List<Object> get(Class clazz, Object... columns);
	
	public void update(Class clazz, Object entity);
	
	public void delete(Class clazz, Object entity);
}
