package in.sts.gradleproject.main;



import in.sts.gradleproject.service.TeamLeaderService;
import in.sts.gradleproject.xmlreader.EmployeeReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//
//		EmployeeReader employeeRead=new EmployeeReader();
//		employeeRead.employeeRead();
		
		
		TeamLeaderService TL=new TeamLeaderService();
		TL.tlservice();
	}

}
