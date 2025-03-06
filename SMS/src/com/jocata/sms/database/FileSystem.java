package com.jocata.sms.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class FileSystem {

	private static final String FILE_NAME = "appData.ser";
	private static Map<String, List<Object>> dataMap = new HashMap<>(); 
	
	static {
		try {
			loadDataFromFile();
		} catch (Exception e) {
			System.err.println("Unexpected error occurred: " + e.getMessage());
		}
	}

	public static void writeDataToFile(Object entity, Class clazz) throws Exception {

		try {
			Map<String, List<Object>> tableData = dataMap;
			List<Object> rows = dataMap.getOrDefault(clazz.getName(), new ArrayList<>());
			rows.add(entity);
			tableData.put(clazz.getName(), rows);
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
				oos.writeObject(tableData);
			}
		} catch (Exception e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}
	
	public static void updateDataToFile(Object entity, Class clazz) {
	    
		try {
			Map<String, List<Object>> tableData = dataMap;
			List<Object> rows = tableData.getOrDefault(clazz.getName(), new ArrayList<>());
		    boolean objectUpdated = false;
		    for (int i = 0; i < rows.size(); i++) {
		        Object existingEntity = rows.get(i);
		        if (existingEntity.equals(entity)) {
		            rows.set(i, entity);  
		            objectUpdated = true;
		            break;
		        }
		    }
		    if (!objectUpdated) {
		        rows.add(entity);
		    }
		    tableData.put(clazz.getName(), rows);
		    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
		        oos.writeObject(tableData);
		    }
	    } catch (Exception e) {
	        System.err.println("Unexpected error occurred while writing data: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
	public static void deleteDataToFile(Object entity, Class clazz) {

		try {
			Map<String, List<Object>> tableData = dataMap;
			List<Object> rows = tableData.getOrDefault(clazz.getName(), new ArrayList<>());
			rows.removeIf(existingEntity -> existingEntity.equals(entity));
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
				oos.writeObject(tableData);
			}
		} catch (Exception e) {
			System.err.println("Unexpected error occurred while writing data: " + e.getMessage());
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unchecked")
	public static void loadDataFromFile() throws Exception {
		
	    File file = new File(FILE_NAME);
	    if (!file.exists()) {
	        dataMap = new HashMap<>();
	        System.out.println("File not found. Initialized empty data map.");
	        return;
	    }
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
	        dataMap = (Map<String, List<Object>>) ois.readObject();
	        System.out.println("Loaded data from file.");
	    } catch (Exception e) {
	        System.out.println("Unexpected error occurred while loading data from file: " + e.getMessage());
	    }
	}


	public static Map<String, List<Object>> getDataMap() {
		return dataMap;
	}

}
