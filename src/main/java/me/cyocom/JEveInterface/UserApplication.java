package me.cyocom.jeveinterface;

public class UserApplication {
	
	private final String applicationName;
	private final String developerEmail;
	private final String applicationVersion;
	
	public UserApplication( String developerEmail, String applicationName, String applicationVersion){
		this.applicationName = applicationName;
		this.developerEmail = developerEmail;
		this.applicationVersion = applicationVersion;
	}
	public UserApplication( String developerEmail, String applicationName, int applicationVersion){
		this.applicationName = applicationName;
		this.developerEmail = developerEmail;
		this.applicationVersion = Integer.toString(applicationVersion);
	}
	public String getApplicationVersion() {
		return applicationVersion;
	}
	public String getDeveloperEmail() {
		return developerEmail;
	}
	public String getApplicationName() {
		return applicationName;
	}
}
