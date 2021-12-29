package in.sts.gradleproject.daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;


import in.sts.gradleproject.models.Employee;


public class TeamLeaderDao {








	public int tldetails(Employee empmodel)
	{
		int result=0;

		int id;
		String TLname;

		String TMname;


		int count = 0;

		HashMap<String,String> hp=new HashMap<>();
		LinkedHashSet<String> TL=new LinkedHashSet<>();
		List<String> detail=new ArrayList<>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/jaydeep";
			String user="root";
			String pass="root";


			Connection  con=DriverManager.getConnection(url,user,pass);




			String query="select e1.EmployeeId,e1.Firstname,e2.firstname from Employee e1,Employee e2 where e2.reportingto=? AND e1.EmployeeId=e2.reportingto";
			String query2="select max(employeeid) from employee";
			PreparedStatement pstmt=con.prepareStatement(query);
			PreparedStatement pstmt2=con.prepareStatement(query2);
			ResultSet rs2=pstmt2.executeQuery();
			
			
			
			while(rs2.next())
			{
				count=rs2.getInt("max(employeeid)");
				System.out.println(count);
			}
			for(int d=1;d<=count;d++)
			{
				
				pstmt.setInt(1, d);
				ResultSet rs=pstmt.executeQuery();
			
			
			
			
			






			while(rs.next())
			{


				id=rs.getInt("e1.EmployeeId");
				TLname=rs.getString("e1.Firstname");
				TMname=rs.getString("e2.firstname");



				detail.add(TMname);
				TL.add(TLname);

				hp.put(TMname, TLname);

				System.out.println("id:-"+id+"  "+TLname+"  "+TMname+"    ");


			}

			empmodel.setTL(TL);
			empmodel.setTLdetail(detail);
			empmodel.setHp(hp);
			

			}
			
			
			

			if(pstmt!=null)
			{
				System.out.println("You Successfully Signed In");
			}
			if(con!=null)
			{
				System.out.println("You Successfully Signed In");
			}

		}
		catch(SQLException ex)
		{
			System.out.println("Sql Exception please cheack the connectivity or the query");
		}
		catch(Exception e)
		{
			System.out.println(" Exception please cheack the code");
		}
		return result;




	}
}


