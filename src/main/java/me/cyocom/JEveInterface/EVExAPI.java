package me.cyocom.jeveinterface;

import java.net.MalformedURLException;
import java.net.URL;

public class EVExAPI {
	private final URL baseURL;
	
	public EVExAPI(final String baseURL){
		try {
			this.baseURL = new URL(baseURL);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid Base URL");
		}
	}

	public URL getBaseURL() {
		return baseURL;
	}
}
