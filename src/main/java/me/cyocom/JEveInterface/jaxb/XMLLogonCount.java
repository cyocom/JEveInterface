package me.cyocom.jeveinterface.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "logonCount")
public class XMLLogonCount implements XMLResultContent {
	@XmlValue
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
