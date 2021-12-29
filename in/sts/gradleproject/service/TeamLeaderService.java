package in.sts.gradleproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import in.sts.gradleproject.daos.TeamLeaderDao;
import in.sts.gradleproject.models.Employee;

public class TeamLeaderService {



	public void tlservice()

	{
		
		TeamLeaderDao tldao=new TeamLeaderDao();

		Employee empmodel=new Employee();


		tldao.tldetails(empmodel);

		List<String> detail=new ArrayList<>();
		LinkedHashSet<String> TL=new LinkedHashSet<>();

		TL.addAll(empmodel.getTL());
		detail.addAll(empmodel.getTLdetail());




		for(String tlname:TL)
		{
			System.out.println("                                   "+tlname+"(TL)");
			System.out.println("           ___________________________|______________________________");




			for(Map.Entry m :empmodel.getHp().entrySet()){   

				if(tlname.equals(m.getValue()))
					System.out.print("     -->"+m.getKey()+"(TM)             ");  
			}  

			System.out.println();
			System.out.println();
			System.out.println();
		}




	}
}
