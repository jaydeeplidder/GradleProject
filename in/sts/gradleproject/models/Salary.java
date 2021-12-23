package in.sts.gradleproject.models;








public class Salary {

	private String month;
	private int amount;
	private int year;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
		return "Salary [month=" + month + ", amount=" + amount + ", year=" + year + "]";
	}

}
