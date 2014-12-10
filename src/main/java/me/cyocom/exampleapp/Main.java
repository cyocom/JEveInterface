package me.cyocom.exampleapp;

import me.cyocom.jeveinterface.EVExAPI;
import me.cyocom.jeveinterface.UserApplication;

public class Main {

	public static void main(String[] args) {
		UserApplication userApplication = new UserApplication( "ibook@ibooklive.info", "JEveInterface ExampleApp", "0.1");
		EVExAPI oldApi = new EVExAPI("https://api.eveonline.com");
		
	}

}
