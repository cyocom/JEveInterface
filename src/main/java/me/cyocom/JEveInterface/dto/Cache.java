package me.cyocom.jeveinterface.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cache {
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss"); 
	private final Date accessedDate;
	private final Date cachedUntil;
	// 1 = Short, 2 = M-Short, 3 = Long
	private int cacheMode;
	
	public Cache(String accessedDate, String cachedUntil, int cacheMode){
		try {
			this.accessedDate = sdf.parse(accessedDate);
			this.cachedUntil = sdf.parse(cachedUntil);
		} catch (ParseException e) {
			throw new RuntimeException("Malformed date string in reply");
		}
		this.cacheMode = cacheMode;
	}

	public Date getAccessedDate() {
		return accessedDate;
	}

	public Date getCachedUntil() {
		return cachedUntil;
	}
}
