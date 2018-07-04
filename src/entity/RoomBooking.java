package entity;

import java.io.Serializable;

public class RoomBooking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;		// ชื่อห้องประชุม
	private String subject; // หัวข้อ
	private String startDate; // เริ่มประชุมวันที่
	private String startTime; // เริ่มประชุมเวลา
	private String createUserName; // ชื่อผู้สร้าง
	private String userBookName; // ชื่อผู้จอง
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getUserBookName() {
		return userBookName;
	}
	public void setUserBookName(String userBookName) {
		this.userBookName = userBookName;
	}
	
}
