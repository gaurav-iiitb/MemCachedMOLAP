package com.memcachced.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * author Gaurav Joshi
 */
public class Constants {
	
	public static String filepath = "C:\\Users\\Gaurav Joshi\\eclipse-workspace\\com.memcachced\\db_sales_dwh\\lattice\\cuboid02";
	public static String server = "localhost:11211";
	public static String MemCachedClientName = "TestClient";
	
	public static Set<String> keys = new HashSet<String>();
	
	public static void setKeySet(String key) {
		keys.add(key);
	}
	
	public static Set<String> getKeySet() {
		return keys;
	}

}
