package entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
@Component
public class Course {

	private int courseid;
	private String coursename;
	private int institutionid;
	private String info;
	private int weekNum;
	private int classesPerWeek;
	private int bigClassNum;
	private int bigClassCurrentNum;
	private double bigClassPrice;
	private int smallClassNum;
	private int smallClassCurrentNum;
	private double smallClassPrice;
	private LocalDate beginTime;

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getInstitutionid() {
		return institutionid;
	}

	public void setInstitutionid(int institutionid) {
		this.institutionid = institutionid;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(int weekNum) {
		this.weekNum = weekNum;
	}

	public int getClassesPerWeek() {
		return classesPerWeek;
	}

	public void setClassesPerWeek(int classesPerWeek) {
		this.classesPerWeek = classesPerWeek;
	}

	public int getBigClassNum() {
		return bigClassNum;
	}

	public void setBigClassNum(int bigClassNum) {
		this.bigClassNum = bigClassNum;
	}

	public double getBigClassPrice() {
		return bigClassPrice;
	}

	public void setBigClassPrice(double bigClassPrice) {
		this.bigClassPrice = bigClassPrice;
	}

	public int getSmallClassNum() {
		return smallClassNum;
	}

	public void setSmallClassNum(int smallClassNum) {
		this.smallClassNum = smallClassNum;
	}

	public double getSmallClassPrice() {
		return smallClassPrice;
	}

	public void setSmallClassPrice(double smallClassPrice) {
		this.smallClassPrice = smallClassPrice;
	}

	public LocalDate getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(LocalDate beginTime) {
		this.beginTime = beginTime;
	}

	public int getBigClassCurrentNum() {
		return bigClassCurrentNum;
	}

	public void setBigClassCurrentNum(int bigClassCurrentNum) {
		this.bigClassCurrentNum = bigClassCurrentNum;
	}

	public int getSmallClassCurrentNum() {
		return smallClassCurrentNum;
	}

	public void setSmallClassCurrentNum(int smallClassCurrentNum) {
		this.smallClassCurrentNum = smallClassCurrentNum;
	}
}
