package in.sts.gradleproject.classes;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import in.sts.gradleproject.daos.AddressDao;
import in.sts.gradleproject.models.AddressModel;
import in.sts.gradleproject.models.EmployeeModel;


public class AddressClass {
	AddressDao addressdao=new AddressDao();

	public int addressdetails(AddressModel addressmodel,EmployeeModel empmodel) throws Exception
	{
		
		
		int result=0;
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();

		final Logger logger=Logger.getLogger("AddressClass.class");
		BasicConfigurator.configure();

		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse("employee.xml");
			doc.getDocumentElement().normalize();  
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  

			NodeList nodeList = doc.getElementsByTagName("Employee");  


			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  

				Node node = nodeList.item(itr);  
				logger.info("\nNode Name :" + node.getNodeName());  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{   
					Element addressElement = (Element) node; 


					String city=addressElement.getElementsByTagName("City").item(itr).getTextContent();
					String country=addressElement.getElementsByTagName("Country").item(itr).getTextContent();
					int pincode=Integer.parseInt(addressElement.getElementsByTagName("Pincode").item(itr).getTextContent());


					addressmodel.setCity(city);
					addressmodel.setCountry(country);
					addressmodel.setPincode(pincode);


					logger.info("Address  :");

					logger.info("City: "+ city); 
					logger.info("Country: "+ country);
					logger.info("Pincode: "+ pincode);
					
					addressdao.addressdetailsinsert(addressmodel,empmodel);

				}
			}
		}	catch (ParserConfigurationException e) {

			logger.error("Throwing Exception in the ParserConfiguration");
		} catch (SAXException e) {

			logger.error("Throwing SAXException");
		} catch (IOException e) {

			logger.error("Throwing Input /Output Exception");
		}
		return result;
	}

}
