package in.sts.gradleproject.models;

public class EmployeeModel {

	private int id;
	private String firstname;
	private String lastname;
	private String city;
	private String country;
	private int pincode;
	private String month;
	private int amount;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city
				+ ", country=" + country + ", pincode=" + pincode + ", month=" + month + ", amount=" + amount + "]";
	}



}
