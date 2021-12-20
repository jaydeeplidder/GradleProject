package in.sts.gradleproject.daos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import in.sts.gradleproject.models.EmployeeModel;
import in.sts.gradleproject.mysqlconnection.MysqlConn;


public class EmployeeDao   {
	
	

	public int employeedetailsinsert(EmployeeModel empmodel) throws Exception
	{
		
		
		final Logger logger=Logger.getLogger("EmployeeImpl.class");
		BasicConfigurator.configure();
		Connection con=MysqlConn.Connecivity();
		PreparedStatement pstmt=null;
		int result=0;
		try
		{
			
			
			String query="insert into Employee values(?,?,?)";
			
			if(con!=null)
			{
				pstmt=con.prepareStatement(query);
				pstmt.setInt(1,empmodel.getId() );
				pstmt.setString(2, empmodel.getFirstname());
				pstmt.setString(3,empmodel.getLastname());
				
				

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

			if(pstmt!=null)
			{
				pstmt.close();
			}

			if(con!=null)
			{
				con.close();
			}


		}
		return result;


	}
}