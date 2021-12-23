package in.sts.gradleproject.Service;

import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import in.sts.gradleproject.daos.EmployeeDao;
import in.sts.gradleproject.daos.SalaryDao;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.models.Salary;
import in.sts.gradleproject.tagnameinterface.Tagnames;

//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class SalaryService {


	SalaryDao salarydao=new SalaryDao();
	Salary salarymodel=new Salary();

	Employee empmodel=new Employee();
	EmployeeDao empdao=new EmployeeDao();
	int count=1;
	int value=0;

	public int salarydetails(Employee empmodel) throws Exception
	{

		int result=0;
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();

		final Logger logger=Logger.getLogger("SalaryServiceClass.class");


		try {
			empmodel.setSalarymodel(salarymodel);
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse("employee.xml");
			doc.getDocumentElement().normalize();  
			logger.info("Root element: " + doc.getDocumentElement().getNodeName());  

			NodeList salarynodeList = doc.getElementsByTagName(Tagnames.Employee);
			for (int i = value; i < count; i++) {
				Node s=salarynodeList.item(value);
				logger.info(salarynodeList.getLength());


				if(s.getNodeType()==Node.ELEMENT_NODE)
				{
					Element salary=(Element)s;

					NodeList yearnodelist = doc.getElementsByTagName(Tagnames.Year);
					for(int l=0;l<salary.getElementsByTagName(Tagnames.Year).getLength();l++)
					{
						Node yearnode = yearnodelist.item(l);
						if(yearnode.getNodeType()==Node.ELEMENT_NODE)
						{
							Element year=(Element) yearnode;
							logger.info("Year  ="+year.getTagName()+" "+year.getAttribute("name"));

							int yearof=Integer.parseInt(year.getAttribute("name"));
							int numberofmonths=year.getElementsByTagName(Tagnames.Month).getLength();
							logger.info(numberofmonths);
							for(int j=0;j<numberofmonths;j++)
							{
								String month=year.getElementsByTagName(Tagnames.Month).item(j).getTextContent();
								int amount=Integer.parseInt(year.getElementsByTagName(Tagnames.Amount).item(j).getTextContent().toString());

								logger.info(month);
								logger.info(amount);

								empmodel.getSalarymodel().setYear(yearof);
								empmodel.getSalarymodel().setMonth(month);
								empmodel.getSalarymodel().setAmount(amount);

								salarydao.salarydetailsinsert(empmodel);
							}
						}
					}


				}
			}


			count++;
			value++;
		} catch (ParserConfigurationException ex) {
			// TODO Auto-generated catch block
			logger.error("Throwing Exception in the ParserConfiguration");
		} catch (SAXException ep) {
			// TODO Auto-generated catch block
			logger.error("Throwing SAXException");
		} catch (IOException ed) {
			// TODO Auto-generated catch block
			logger.error("Throwing Input /Output Exception");
		}catch(NullPointerException ne)
		{
			logger.error("Throwing Null  Exception");
		}
		return result;


	}

}
