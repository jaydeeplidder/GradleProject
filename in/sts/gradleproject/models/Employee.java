package in.sts.gradleproject.models;

public class Employee {



	private int id;
	private String firstname;
	private String lastname;
	private Address addressmodel;
	private Salary salarymodel;

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

	public Address getAddressmodel() {
		return addressmodel;
	}
	public void setAddressmodel(Address addressmodel) {
		this.addressmodel = addressmodel;
	}


	public Salary getSalarymodel() {
		return salarymodel;
	}
	public void setSalarymodel(Salary salarymodel) {
		this.salarymodel = salarymodel;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", addressmodel="
				+ addressmodel + ", salarymodel=" + salarymodel + "]";
	}


}
