package me.cyocom.jeveinterface.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eveapi")
public class XMLEveApi {
	
	@XmlElement(name = "currentTime")
	private String currentTime;
	
	@XmlElement(name = "results")
	private XMLResults results;
	
	@XmlElement(name = "cachedUntil")
	private String cachedUntil;
}
