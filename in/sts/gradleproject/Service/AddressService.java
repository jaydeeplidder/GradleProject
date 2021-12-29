package in.sts.gradleproject.service;







import org.apache.log4j.Logger;



import in.sts.gradleproject.daos.AddressDao;
import in.sts.gradleproject.models.Address;
import in.sts.gradleproject.models.Employee;


//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................

public class AddressService {

	final Logger logger=Logger.getLogger("AddressServiceClass.class");

	int count=1;//no of time the method is called to run the for loop
	int value=0;//getting the next item index of the Element Address
	public int addressDetails(int id,String city,String country,int pincode) throws Exception
	{
		Employee empmodel =new Employee();
		AddressDao addressdao=new AddressDao();
		Address addressmodel=new Address();

		int result=0;

		empmodel.setAddressmodel(addressmodel);
		empmodel.setId(id);
		empmodel.getAddressmodel().setCity(city);
		empmodel.getAddressmodel().setCountry(country);
		empmodel.getAddressmodel().setPincode(pincode);



		logger.info(empmodel.getId());
		logger.info("City: "+ empmodel.getAddressmodel().getCity()); 
		logger.info("Country: "+ empmodel.getAddressmodel().getCountry());
		logger.info("Pincode: "+ empmodel.getAddressmodel().getPincode());

		addressdao.addressdetailsInsert(empmodel);




		return result;
	}

}
