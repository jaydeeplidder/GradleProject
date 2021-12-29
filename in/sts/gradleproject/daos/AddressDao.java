package in.sts.gradleproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.apache.log4j.Logger;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.mysqlconnection.MysqlConnection;

public class AddressDao {
	final Logger logger=Logger.getLogger("AddressDao.class");
	public int addressdetailsInsert(Employee empmodel) throws Exception
	{




		Connection con=MysqlConnection.connectivity();
		String query="insert into Address values(AddressId,?,?,?,?)";

		PreparedStatement pstmt=MysqlConnection.preparedstatement(query);;
		int result=0;
		try
		{



			if(con!=null)
			{

				pstmt.setInt(1,empmodel.getId());
				pstmt.setString(2,empmodel.getAddressmodel().getCity());
				pstmt.setString(3,empmodel.getAddressmodel().getCountry());
				pstmt.setInt(4,empmodel.getAddressmodel().getPincode());

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
