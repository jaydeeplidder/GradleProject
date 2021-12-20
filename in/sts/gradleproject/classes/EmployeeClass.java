package in.sts.gradleproject.classes;

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
import in.sts.gradleproject.models.AddressModel;
import in.sts.gradleproject.models.EmployeeModel;
import in.sts.gradleproject.models.SalaryModel;

import java.io.IOException;




public class EmployeeClass 
{  
	public static void main(String argv[]) throws Exception

	{
		
		SalaryClass salaryclass=new SalaryClass();
		AddressClass addressclass=new AddressClass();
		SalaryModel salarymodel=new SalaryModel();
		AddressModel addressmodel=new AddressModel();
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
			
//.........................................Employee data fetch here  ...............................................................
			
			
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
					
					
					empmodel.setId(id);
					empmodel.setFirstname(fname);

					empmodel.setLastname(lname);
					
					
					logger.info("Student id: "+ id);
					logger.info("First Name: "+ fname);  
					logger.info("Last Name: "+ lname);

					
					
					empdao.employeedetailsinsert(empmodel);

//....................................................................................................................
					
					
					
//......................................Fetch  Address details here ...........................................................
					
					
					addressclass.addressdetails(addressmodel,empmodel);
					
					
//...............................................................................................................................					
					
					
					
					
					
					
//...........................................Fetch Salary Data here..................................................
					
					
					salaryclass.salarydetails(salarymodel,empmodel);

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



	}
}
