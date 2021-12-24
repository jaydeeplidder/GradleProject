package in.sts.gradleproject.service;

import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;


import org.apache.log4j.Logger;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import in.sts.gradleproject.daos.AddressDao;
import in.sts.gradleproject.models.Address;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.tagnameinterface.Tagnames;
import in.sts.gradleproject.xmlreader.Reader;

//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................

public class AddressService {
	AddressDao addressdao=new AddressDao();
	Address addressmodel=new Address();


	int count=1;//no of time the method is called to run the for loop
	int value=0;//getting the next item index of the Element Address
	public int addressdetails(Employee empmodel) throws Exception
	{


		int result=0;


		final Logger logger=Logger.getLogger("AddressServiceClass.class");


		try {

			NodeList addressnodeList = Reader.reader(Tagnames.Employee) ;


			for (int k = value; k <count ; k++)   
			{  
				logger.info(addressnodeList.getLength());
				Node addressnode = addressnodeList.item(value);  
				logger.info("\nNode Name :" + addressnode.getNodeName());  
				if (addressnode.getNodeType() == Node.ELEMENT_NODE)   
				{   
					Element addressElement = (Element)addressnode; 

					// ..................set and read the XmL simultaneously store it to the data...............................


					String city=addressElement.getElementsByTagName(Tagnames.City).item(0).getTextContent();
					String country=addressElement.getElementsByTagName(Tagnames.Country).item(0).getTextContent();
					int pincode=Integer.parseInt(addressElement.getElementsByTagName(Tagnames.Pincode).item(0).getTextContent());

					empmodel.setAddressmodel(addressmodel);
					empmodel.getAddressmodel().setCity(city);
					empmodel.getAddressmodel().setCountry(country);
					empmodel.getAddressmodel().setPincode(pincode);


					logger.info("Address  :");

					logger.info("City: "+ city); 
					logger.info("Country: "+ country);
					logger.info("Pincode: "+ pincode);

					addressdao.addressdetailsinsert(empmodel);
					//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
				}
			}
			value++;
			count++;//gets increment the no of times the class method is called
		}	catch (ParserConfigurationException e) {

			logger.error("ParserConfiguration Exception occurs check your file name is proper or not?");
		} catch (SAXException e) {

			logger.error(" SAXException occurs check your Xml file is properply wriiten or not ");
		} catch (IOException e) {

			logger.error("Throwing Input /Output Exception");
		}
		return result;
	}

}
