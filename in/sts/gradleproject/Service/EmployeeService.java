package in.sts.gradleproject.Service;

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

import in.sts.gradleproject.daos.EmployeeDao;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.tagnameinterface.Tagnames;


import java.io.IOException;


//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class EmployeeService 
{  
	public int Employeeservice() throws Exception

	{

		int result=0;

		AddressService addressclass=new AddressService();

		Employee empmodel=new Employee();
		EmployeeDao empdao=new EmployeeDao();

		SalaryService salaryclass=new SalaryService();

		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();

		final Logger logger=Logger.getLogger("EmployeeServiceClass.class");
		BasicConfigurator.configure();

		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse("employee.xml");
			doc.getDocumentElement().normalize();  
			logger.info("Root element: " + doc.getDocumentElement().getNodeName());  

			//.........................................Employee data fetch here  ...............................................................


			NodeList nodeList = doc.getElementsByTagName(Tagnames.Employee);  


			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
				logger.info(nodeList.getLength());
				Node node = nodeList.item(itr);  
				logger.info("\nNode Name :" + node.getNodeName()+" "+(itr+1));  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{   
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

					//....................................................................................................................



					//......................................Fetch  Address details here ...........................................................


					addressclass.addressdetails(empmodel);


					//...............................................................................................................................					






					//...........................................Fetch Salary Data here..................................................


					salaryclass.salarydetails(empmodel);

					//..................................................................................................................................




				}  


			}




		} catch (ParserConfigurationException e) {

			logger.error("Throwing Exception in the ParserConfiguration");
		} catch (SAXException e) {

			logger.error("Throwing SAXException");
		} catch (IOException e) {

			logger.error("Throwing Input /Output Exception");
		}
		return result;



	}
}
