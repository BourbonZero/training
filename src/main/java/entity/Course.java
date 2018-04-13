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

	private String courseid;
	private String coursename;
	private String institutionid;
	private String institutionName;
	private String courseInfo;
	private int weekNum;
	private int classesPerWeek;
	private int bigClassNum;
	private int bigClassCurrentNum;
	private double bigClassPrice;
	private int smallClassNum;
	private int smallClassCurrentNum;
	private double smallClassPrice;
	private LocalDate beginTime;

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getInstitutionid() {
		return institutionid;
	}

	public void setInstitutionid(String institutionid) {
		this.institutionid = institutionid;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
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
