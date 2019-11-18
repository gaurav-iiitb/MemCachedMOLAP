package com.memcachced.ClientSideCaching;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.memcachced.utils.Constants;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/**
 * 
 * author Gaurav Joshi
 */

public class MemcachedJavaClient {

	public static ReadingBinaries readBinary;
	
	public static void main(String[] args) {
		
		initializeServer();
		MemCachedClient memCachedClient = getMemCachedClient();
		
		readBinary.display();
		Map<String, HashMap<String,double[]>> cachedMap = readBinary.getBinaryFileContent();
		
		if(!cachedMap.isEmpty()) {
			for(String key : cachedMap.keySet()) {
				Constants.setKeySet(key);
				memCachedClient.set(key, cachedMap.get(key));
			}
		} else {
			System.out.println("Error Storing Data In Cache/ Nothing To Cache. Check Cube Binaries.");
		}
		
		readFromCache();
	}
	
	public static void initializeServer() {
		
		String[] servers = {Constants.server};
		SockIOPool pool = SockIOPool.getInstance(Constants.MemCachedClientName);
		pool.setServers( servers );
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMinConn( 5 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		
	}
	
	public static MemCachedClient getMemCachedClient() {
		
		return new MemCachedClient(Constants.MemCachedClientName);				
	}
	
	public static void readFromCache() {
		
		Set<String> keys = Constants.getKeySet();
		String[] myArray = new String[keys.size()];
		keys.toArray(myArray);
		
		HashMap<String,Object> map = (HashMap<String, Object>) getMemCachedClient().getMulti(myArray);

		for(String key : map.keySet()){
			System.out.println("KEY: " + key + " VALUE: " + map.get(key));
		}

	}

}