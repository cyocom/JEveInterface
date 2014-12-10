package me.cyocom.jeveinterface.domain;

public class UserAccount {
	private int apiKey;
	private String vCode;
	private int accessMask;
	
	public UserAccount(int apiKey, String vCode){
		this.apiKey = apiKey;
		this.vCode = vCode;
	}
}
