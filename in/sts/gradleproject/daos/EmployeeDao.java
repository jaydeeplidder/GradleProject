package in.sts.gradleproject.daos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.apache.log4j.Logger;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.mysqlconnection.MysqlConnection;


public class EmployeeDao   {

	final Logger logger=Logger.getLogger("EmployeeDao.class");

	public int employeedetailsInsert(Employee empmodel) throws Exception
	{


		

		Connection con=MysqlConnection.connectivity();
		String query="insert into Employee values(?,?,?,?,?)";
		PreparedStatement pstmt=MysqlConnection.preparedstatement(query);
		int result=0;
		try
		{




			if(con!=null)
			{

				pstmt.setInt(1,empmodel.getId() );
				pstmt.setString(2, empmodel.getFirstname());
				pstmt.setString(3,empmodel.getLastname());
				pstmt.setString(4,empmodel.getDesignation());
				pstmt.setInt(5,empmodel.getReportingto());



				result=pstmt.executeUpdate();
			}
			if(pstmt!=null)
			{
				logger.error("You Successfully Signed In");
			}
			else
			{
				logger.error("details are not inserted");
			}
		}
		catch(SQLException ex)
		{
			logger.error("Sql Exception please cheack the connectivity or the query");
		}
		catch(Exception e)
		{
			logger.error(" Exception please cheack the code");
		}
		finally
		{

			MysqlConnection.closeMysqlconnection();


		}
		return result;


	}
}