package com.memcachced.ClientSideCaching;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import com.memcachced.utils.Constants;

/**
 * 
 * author Gaurav Joshi
 */
public class ReadingBinaries {

	public static Map<String, HashMap<String,double[]>> getBinaryFileContent() {
	
		try {
	
			Map<String, HashMap<String,double[]>> cachedMap = new HashMap<String, HashMap<String,double[]>>();
			File file = new File(Constants.filepath);
			FileInputStream fs = new FileInputStream(Constants.filepath);
			ObjectInputStream os= new ObjectInputStream(fs);
			HashMap<String,double[]> baseCube = (HashMap<String,double[]>)os.readObject();
			String mapKey = Constants.filepath.substring(Constants.filepath.lastIndexOf("\\")+1, Constants.filepath.length());
			cachedMap.put(mapKey, baseCube);
			
			partitionMap(cachedMap);
			
			return cachedMap;
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
			return new HashMap<String, HashMap<String,double[]>>();
		}
	}
	
	public static void display() {
		System.out.println("Testing Static Keyword");
	}
	
	public static void partitionMap(Map<String, HashMap<String,double[]>> map) {
		
		HashMap<String,double[]> cubeMap = new HashMap<String,double[]>();
		int size = cubeMap.size();
		for(int i=0; i<size; i++) {
			
		}
		
	}
	
}