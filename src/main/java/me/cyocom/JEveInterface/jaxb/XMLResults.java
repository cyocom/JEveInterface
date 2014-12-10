package me.cyocom.jeveinterface.jaxb;

import java.util.List;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "results")
public class XMLResults {

	@XmlElementRefs({@XmlElementRef(type = XMLLogonCount.class, name = "logonCount"),
		@XmlElementRef(type = XMLLogonMinutes.class, name = "logonMinutes"),
		@XmlElementRef(type = XMLPaidUntil.class, name = "paidUntil"),
		@XmlElementRef(type = XMLCreateDate.class, name = "createDate")
	
	})
	@XmlMixed
	protected List<Object> content;
	
	protected List<XMLResultContent> fixedContent;

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
    	fixedContent = ResultContentConverter.convertToResultContent(content);
    }

    public boolean beforeMarshal(Marshaller marshaller) {
        content = ResultContentConverter.convertFromResultContent(fixedContent);
        return true;
    }
}