package me.cyocom.jeveinterface.xml.secure.account;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import me.cyocom.jeveinterface.EVExAPI;
import me.cyocom.jeveinterface.UserApplication;
import me.cyocom.jeveinterface.domain.UserAccount;
import me.cyocom.jeveinterface.xml.secure.AbstractSecureAPICall;

public class AccountStatus extends AbstractSecureAPICall {
	private final URL url;
	private Date paidUntil;
	private Date createDate;
	private int logonCount;
	private int longonMinutes;
	static int cachedMode = 1;
	
	public AccountStatus(EVExAPI api, UserAccount account, UserApplication app){
		super(api, account, app, cachedMode);
		try {
			this.url = new URL(super.getApi().getBaseURL(), "/account/AccountStatus.xml.aspx");
		} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid URL for AccountStatus");
		}
	}
	@Override
	public void update(){
		String xmlData = super.getUpdatedData(url);
		
	}

	public int getLongonMinutes() {
		super.refreshData();
		return longonMinutes;
	}

	public int getLogonCount() {
		super.refreshData();
		return logonCount;
	}

	public Date getCreateDate() {
		super.refreshData();
		return createDate;
	}

	public Date getPaidUntil() {
		super.refreshData();
		return paidUntil;
	}

}
