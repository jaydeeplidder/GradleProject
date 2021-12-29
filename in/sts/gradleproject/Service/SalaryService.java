package in.sts.gradleproject.service;



import org.apache.log4j.Logger;

import in.sts.gradleproject.daos.SalaryDao;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.models.Salary;


//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class SalaryService {





	final Logger logger=Logger.getLogger("SalaryServiceClass.class");

	public int salaryDetails(int id,int yearof,String month,int amount) throws Exception
	{

		int result=0;
		SalaryDao salarydao=new SalaryDao();
		Salary salarymodel=new Salary();
		Employee empmodel=new Employee();

		empmodel.setSalarymodel(salarymodel);//set the Salary model linked with Employee model
		empmodel.setId(id);
		empmodel.getSalarymodel().setYear(yearof);      //............
		empmodel.getSalarymodel().setMonth(month);		//set the month,year,amount of the current node
		empmodel.getSalarymodel().setAmount(amount);	//...........

		salarydao.salarydetailsInsert(empmodel);//......insert each value to database while simultaneously reading the XML file

		logger.info(empmodel.getSalarymodel().getYear());
		logger.info(empmodel.getSalarymodel().getMonth());
		logger.info(empmodel.getSalarymodel().getAmount());

		return result;


	}

}
