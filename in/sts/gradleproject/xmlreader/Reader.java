package in.sts.gradleproject.xmlreader;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class Reader {

	final static Logger logger=Logger.getLogger("Reader.class");
	public static NodeList reader(String tagname) throws ParserConfigurationException, Exception, IOException
	{
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse("employee.xml");
		doc.getDocumentElement().normalize();  
		logger.info("Root element: " + doc.getDocumentElement().getNodeName());  
		NodeList nodeList = doc.getElementsByTagName(tagname);  
		return nodeList;
	}
	
}
