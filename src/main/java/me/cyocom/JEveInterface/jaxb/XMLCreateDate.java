package me.cyocom.jeveinterface.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "createDate")
public class XMLCreateDate implements XMLResultContent {
	@XmlValue
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}