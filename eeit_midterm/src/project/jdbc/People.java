package project.jdbc;

public class People {

	private int id;
	private int year;
	private int county;
	private int cause;
	private String sex;
	private int age_code;
	private int amount;

	public People() {

	}

	public People(int id,int year, int county, int cause, String sex, int age_code,int amount) {
		this.id = id;
		this.year=year;
		this.county = county;
		this.cause = cause;
		this.sex = sex;
		this.age_code = age_code;
		this.amount = amount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCounty() {
		return county;
	}

	public void setCounty(int country) {
		this.county = country;
	}

	public int getCause() {
		return cause;
	}

	public void setCause(int cause) {
		this.cause = cause;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge_code() {
		return age_code;
	}

	public void setAge_code(int age_code) {
		this.age_code = age_code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
