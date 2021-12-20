package in.sts.gradleproject.models;


import java.util.List;





public class SalaryModel {

	private String month;
	@Override
	public String toString() {
		return "SalaryModel [month=" + month + ", amount=" + amount + ", salarylist=" + salarylist + "]";
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

	private int amount;
	List<String> salarylist;

	public List<String> getStringlist() {
		return salarylist;
	}

	public void setStringlist(List<String> stringlist) {
		this.salarylist = stringlist;
	}
}
