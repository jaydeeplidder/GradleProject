package ProjectModel;

public class EmployeeModel {

	private int id;
	private String firstname;
	private String lastname;
	private String address1;
	private String address2;
	private String address3;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
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
		return "EmployeeIModel [firstname=" + firstname + ", lastname=" + lastname + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + ", month=" + month + ", amount=" + amount
				+ ", id=" + id + "]";
	}




}
