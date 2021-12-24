package in.sts.gradleproject.service;

import java.io.IOException;



import javax.xml.parsers.ParserConfigurationException;


import org.apache.log4j.Logger;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import in.sts.gradleproject.daos.EmployeeDao;
import in.sts.gradleproject.daos.SalaryDao;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.models.Salary;
import in.sts.gradleproject.tagnameinterface.Tagnames;
import in.sts.gradleproject.xmlreader.Reader;

//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class SalaryService {


	SalaryDao salarydao=new SalaryDao();
	Salary salarymodel=new Salary();

	Employee empmodel=new Employee();
	EmployeeDao empdao=new EmployeeDao();
	int count=1;//no of time the method is called to run the for loop
	int value=0;//getting the next item index of the Element Salary

	public int salarydetails(Employee empmodel) throws Exception
	{

		int result=0;


		final Logger logger=Logger.getLogger("SalaryServiceClass.class");


		try {
			empmodel.setSalarymodel(salarymodel);//set the Salary model linked with Employee model

			NodeList salarynodeList =Reader.reader(Tagnames.Salary);//Salary node in XML
			for (int i = value; i < count; i++) {
				Node s=salarynodeList.item(value);
				logger.info(salarynodeList.getLength());


				if(s.getNodeType()==Node.ELEMENT_NODE)
				{
					Element salary=(Element)s;

					NodeList yearnodelist = salary.getElementsByTagName(Tagnames.Year);//Child node of the salary node
					for(int l=0;l<salary.getElementsByTagName(Tagnames.Year).getLength();l++)
					{
						Node yearnode = yearnodelist.item(l);
						if(yearnode.getNodeType()==Node.ELEMENT_NODE)
						{
							Element year=(Element) yearnode;
							logger.info("Year  ="+year.getTagName()+" "+year.getAttribute("name"));

							int yearof=Integer.parseInt(year.getAttribute("name"));//gets the attribute value of the year node
							int numberofmonths=year.getElementsByTagName(Tagnames.Month).getLength();
							logger.info(numberofmonths);
							for(int j=0;j<numberofmonths;j++)//current no of months and amount child node present in the current year node
							{
								String month=year.getElementsByTagName(Tagnames.Month).item(j).getTextContent();
								int amount=Integer.parseInt(year.getElementsByTagName(Tagnames.Amount).item(j).getTextContent().toString());

								logger.info(month);
								logger.info(amount);

								empmodel.getSalarymodel().setYear(yearof);      //............
								empmodel.getSalarymodel().setMonth(month);		//set the month,year,amount of the current node
								empmodel.getSalarymodel().setAmount(amount);	//...........

								salarydao.salarydetailsinsert(empmodel);//......insert each value to database while simultaneously reading the XML file
							}
						}
					}


				}
			}


			count++;      //gets increment the no of times the class method is called
			value++;		//...
		} catch (ParserConfigurationException ex) {

			logger.error("ParserConfiguration Exception occurs check your file name is proper or not?");
		} catch (SAXException ep) {

			logger.error(" SAXException occurs check your Xml file is properply wriiten or not ");
		} catch (IOException ed) {

			logger.error("Throwing Input /Output Exception");
		}catch(NullPointerException ne)
		{
			logger.error("Throwing Null  Exception");
		}
		return result;


	}

}
