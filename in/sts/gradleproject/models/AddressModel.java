package in.sts.gradleproject.models;

public class AddressModel {

	private String city;
	@Override
	public String toString() {
		return "AddressModel [city=" + city + ", country=" + country + ", pincode=" + pincode + "]";
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
	private String country;
	private int pincode;
}
