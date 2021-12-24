package in.sts.gradleproject.service;


import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import in.sts.gradleproject.daos.EmployeeDao;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.tagnameinterface.Tagnames;
import in.sts.gradleproject.xmlreader.Reader;

import java.io.IOException;


//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class EmployeeService 
{  
	public int Employeeservice() throws Exception

	{

		int result=0;

		AddressService addressservice=new AddressService();

		Employee empmodel=new Employee();
		EmployeeDao empdao=new EmployeeDao();

		SalaryService salaryservice=new SalaryService();



		final Logger logger=Logger.getLogger("EmployeeServiceClass.class");
		BasicConfigurator.configure();

		try {

			//.........................................Employee data fetch here  ...............................................................


			NodeList nodeList =Reader.reader(Tagnames.Employee) ;//gets all the Employee node in the XML


			for (int itr = 0; itr < nodeList.getLength(); itr++)   // run the loop based on the no of Employee node in XML 
			{  
				logger.info(nodeList.getLength());
				Node node = nodeList.item(itr);  // gets the Employee node based on the index e.g if the its the First employee tag its index is 0
				logger.info("\nNode Name :" + node.getNodeName()+" "+(itr+1));  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{   

					// .......set and read the XmL simultaneously store it to the data...............................................
					Element eElement = (Element) node; 

					int id=Integer.parseInt(eElement.getElementsByTagName(Tagnames.Id).item(0).getTextContent());
					String fname=eElement.getElementsByTagName(Tagnames.Firstname).item(0).getTextContent();
					String lname=eElement.getElementsByTagName(Tagnames.Lastname).item(0).getTextContent();


					empmodel.setId(id);
					empmodel.setFirstname(fname);

					empmodel.setLastname(lname);


					logger.info("Student id: "+ id);
					logger.info("First Name: "+ fname);  
					logger.info("Last Name: "+ lname);



					empdao.employeedetailsinsert(empmodel);
					//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

					//....................................................................................................................



					//......................................Fetch  Address details here ...........................................................


					addressservice.addressdetails(empmodel);


					//...............................................................................................................................					






					//...........................................Fetch Salary Data here..................................................


					salaryservice.salarydetails(empmodel);

					//..................................................................................................................................




				}  


			}




		} catch (ParserConfigurationException e) {

			logger.error("ParserConfiguration Exception occurs check your file name is proper or not?");
		} catch (SAXException e) {

			logger.error(" SAXException occurs check your Xml file is properply wriiten or not ");
		} catch (IOException e) {

			logger.error("Throwing Input /Output Exception");
		}
		return result;



	}
}
