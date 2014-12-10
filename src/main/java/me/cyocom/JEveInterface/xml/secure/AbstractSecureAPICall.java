package me.cyocom.jeveinterface.xml.secure;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import me.cyocom.jeveinterface.EVExAPI;
import me.cyocom.jeveinterface.UserApplication;
import me.cyocom.jeveinterface.domain.UserAccount;
import me.cyocom.jeveinterface.dto.Cache;

public abstract class AbstractSecureAPICall {
	private final EVExAPI api;
	private Cache cache;
	private final UserAccount account;
	private final UserApplication app;
	private final int cachedMode;
	
	public AbstractSecureAPICall(EVExAPI api, UserAccount account, UserApplication app, int cachedMode){
		this.api = api;
		this.account = account;
		this.app = app;
		this.cachedMode = cachedMode;
	}
	
	public boolean isUpToDate() {

		if(getCache().getCachedUntil().before(new Date())){
			return false;
		}
		
		return true;
	}
	
	protected String getUpdatedData(URL url){
		try {
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "JEveInterface 0.1 for " + getApp().getApplicationName() + " v" + getApp().getApplicationVersion() + "see " + getApp().getDeveloperEmail() );
			InputStream response = connection.getInputStream();
			return response.toString();
		} catch (IOException e) {
			System.err.println("ERROR: IOException when opening " + url);
			throw new RuntimeException("Unable to get updated data");
		}
	}

	public Cache getCache() {
		return cache;
	}

	public void updateCache(String accessedDate,String cachedUntil) {
		this.cache = new Cache(accessedDate, cachedUntil, cachedMode);
	}

	public EVExAPI getApi() {
		return api;
	}

	public UserAccount getAccount() {
		return account;
	}

	public UserApplication getApp() {
		return app;
	}

	public void refreshData() {
		if(cache.getCachedUntil().before(new Date())){
			update();
		}
	}
	
	public abstract void update();
	
}
