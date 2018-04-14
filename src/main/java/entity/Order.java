package entity;

import common.OrderState;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
public class Order {

	private int orderid;
	private String userid;
	private int courseid;
	private String courseName;
	private String classType;
	private String state;
	private double price;
	private double discount;
	private double consumption;
	private double actualConsumption;
	private double institutionIncome;
	private double collegeIncome;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	public double getInstitutionIncome() {
		return institutionIncome;
	}

	public void setInstitutionIncome(double institutionIncome) {
		this.institutionIncome = institutionIncome;
	}

	public double getCollegeIncome() {
		return collegeIncome;
	}

	public void setCollegeIncome(double collegeIncome) {
		this.collegeIncome = collegeIncome;
	}

	public double getActualConsumption() {
		return actualConsumption;
	}

	public void setActualConsumption(double actualConsumption) {
		this.actualConsumption = actualConsumption;
	}
}
