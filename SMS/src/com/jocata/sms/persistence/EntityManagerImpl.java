package com.jocata.sms.persistence;
import com.jocata.sms.database.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SuppressWarnings("rawtypes")
public class EntityManagerImpl implements EntityManager {

	@Override
	public void save(Class clazz, Object entity) {
		
		try {
			FileSystem.writeDataToFile(entity, clazz);
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	@Override
	public List<Object> get(Class clazz) {
		
		try {
			Map<String, List<Object>> data = FileSystem.getDataMap();
			return data.getOrDefault(clazz.getName(), new ArrayList<>());
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return null;
	}

	@Override
	public Object get(Class clazz, Object primaryKeyName, Object primaryKeyValue) {

		try {
			Map<String, List<Object>> data = FileSystem.getDataMap();
			List<Object> lstData = data.getOrDefault(clazz.getName(), new ArrayList<>());
			for (Object object : lstData) {
				Object fieldValue = getPrimaryKeyValue(clazz, object, primaryKeyName);
				if (fieldValue != null && (fieldValue.equals(primaryKeyValue))) {
					return object;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object> get(Class clazz, Object... columns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Class clazz, Object entity) {
		
		try {
			FileSystem.updateDataToFile(entity, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Class clazz, Object entity) {
		
		try {
			FileSystem.deleteDataToFile(entity, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private Object getPrimaryKeyValue(Class clazz, Object object, Object primaryKeyName) throws NoSuchFieldException, IllegalAccessException {
	    
		String primaryKeyFieldName = (String) primaryKeyName;
	    java.lang.reflect.Field field = clazz.getDeclaredField(primaryKeyFieldName);
	    field.setAccessible(true);
	    return field.get(object);
	}
}
