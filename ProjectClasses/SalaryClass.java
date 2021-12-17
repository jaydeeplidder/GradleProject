package ProjectClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ProjectDaos.EmployeeDao;
import ProjectDaos.SalaryDao;
import ProjectModel.EmployeeModel;
import ProjectModel.SalaryModel;

public class SalaryClass {


	SalaryDao salarydao=new SalaryDao();
	SalaryModel salarymodel=new SalaryModel();

	List<String> array1=new ArrayList<String>();
	List<String> array2=new ArrayList<String>();
	List<String> array3=new ArrayList<String>();

	EmployeeModel empmodel=new EmployeeModel();
	EmployeeDao empdao=new EmployeeDao();

	public int salarydetails(EmployeeModel empmodel) throws Exception
	{

		int result=0;
	DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();

	final Logger logger=Logger.getLogger("SalaryClass.class");
	

	try {
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse("employee.xml");
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
		
	NodeList salaryList = doc.getElementsByTagName("Salary");
	for (int i = 0; i < salaryList.getLength(); i++) {
		Node s=salaryList.item(i);
		logger.info(salaryList.getLength());
		if(s.getNodeType()==Node.ELEMENT_NODE)
		{
			Element salary=(Element)s;
			NodeList childList = salary.getChildNodes();
			for (int j = 0; j < childList.getLength(); j++) {
				Node childNode = childList.item(j);
				if (childNode.getNodeType()==Node.ELEMENT_NODE) {
					Element name=(Element) childNode;
					String value=name.getTextContent();



					array1.add(value);

				}
			}
		}

	}

	salarymodel.setStringlist(array1);
	
	for(int l=0;l<array1.size();l++)
	{
		String value=array1.get(l);
		array2.add(value);
		
		l=l+1;
	}
	for(int l=1;l<array1.size();l++)
	{
		String value=array1.get(l);
		array3.add(value);
		
		l=l+1;
	}

	for(int v=0;v<array2.size();v++)
	{
		empmodel.setMonth(array2.get(v));
		empmodel.setAmount(Integer.parseInt(array3.get(v)));

		logger.info("emp     "+empmodel.getMonth());
		logger.info("emp     "+empmodel.getAmount());

		salarydao.salarydetailsinsert(empmodel);
	}
	} catch (ParserConfigurationException ex) {
		// TODO Auto-generated catch block
		logger.error("Throwing Exception in the ParserConfiguration");
	} catch (SAXException ep) {
		// TODO Auto-generated catch block
		logger.error("Throwing SAXException");
	} catch (IOException ed) {
		// TODO Auto-generated catch block
		logger.error("Throwing Input /Output Exception");
	}
	return result;

	
}

}
