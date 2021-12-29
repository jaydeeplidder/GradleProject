package in.sts.gradleproject.service;



import org.apache.log4j.Logger;



import in.sts.gradleproject.daos.EmployeeDao;

import in.sts.gradleproject.models.Employee;



//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class EmployeeService 
{  
	final Logger logger=Logger.getLogger("EmployeeServiceClass.class");
	public int Employeeservice(int id,int report,String designation,String fname,String lname) throws Exception

	{
		int result=0;

		Employee empmodel=new Employee();
		EmployeeDao empdao=new EmployeeDao();
		empmodel.setId(id);
		empmodel.setReportingto(report);
		empmodel.setDesignation(designation);
		empmodel.setFirstname(fname);

		empmodel.setLastname(lname);
		logger.info("Student id: "+ empmodel.getId());
		logger.info("First Name: "+ empmodel.getFirstname());  
		logger.info("Last Name: "+ empmodel.getLastname());
		logger.info("Designation: "+ empmodel.getDesignation());
		logger.info("Reportingto"+ empmodel.getReportingto());



		empdao.employeedetailsInsert(empmodel);
		return result;



	}
}
