package ProjectClasses;

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

import ProjectDaos.EmployeeDao;

//import ProjectDaos.EmployeeDao;
import ProjectModel.EmployeeModel;


import java.io.IOException;




public class EmployeeClass 
{  
	public static void main(String argv[]) throws Exception

	{
		
		SalaryClass salaryclass=new SalaryClass();


		EmployeeModel empmodel=new EmployeeModel();
		EmployeeDao empdao=new EmployeeDao();



		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();

		final Logger logger=Logger.getLogger("EmployeeClass.class");
		BasicConfigurator.configure();

		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse("employee.xml");
			doc.getDocumentElement().normalize();  
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			
//.........................................Employee data fetch here................................................................
			
			
			NodeList nodeList = doc.getElementsByTagName("Employee");  


			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  

				Node node = nodeList.item(itr);  
				logger.info("\nNode Name :" + node.getNodeName());  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{   
					Element eElement = (Element) node; 

					int id=Integer.parseInt(eElement.getElementsByTagName("Id").item(itr).getTextContent());
					String fname=eElement.getElementsByTagName("FirstName").item(itr).getTextContent();
					String lname=eElement.getElementsByTagName("LastName").item(itr).getTextContent();
					String address1=eElement.getElementsByTagName("AddressLine1").item(itr).getTextContent();
					String address2=eElement.getElementsByTagName("AddressLine2").item(itr).getTextContent();
					String address3=eElement.getElementsByTagName("AddressLine3").item(itr).getTextContent();
					
					empmodel.setId(id);
					empmodel.setFirstname(fname);

					empmodel.setLastname(lname);
					empmodel.setAddress1(address1);
					empmodel.setAddress2(address2);
					empmodel.setAddress3(address3);
					
					logger.info("Student id: "+ id);
					logger.info("First Name: "+ fname);  
					logger.info("Last Name: "+ lname);

					logger.info("Address  :");

					logger.info("Address1: "+ address1); 
					logger.info("Address2: "+ address2);
					logger.info("Address3: "+ address3);
					
					empdao.employeedetailsinsert(empmodel);

//....................................................................................................................
					
					
//...........................................Fetch Salary Data here..................................................
					
					
					salaryclass.salarydetails(empmodel);

//..................................................................................................................................




				}  


			}


		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			logger.error("Throwing Exception in the ParserConfiguration");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			logger.error("Throwing SAXException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Throwing Input /Output Exception");
		}



	}
}
