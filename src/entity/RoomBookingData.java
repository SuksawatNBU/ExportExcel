package entity;

import java.io.Serializable;

public class RoomBookingData implements Serializable {
	
	private static final long serialVersionUID = 3800015505381915589L;
	
	private String eventIdFocus;
	private String eventIdSelected;
	private String roomIdSelected;
	private String bookingIdSelected;
	private String methodSelected;
	
	private String startEventDate;
	private String endEventDate;
	
	private String currentDateTime; // YYYYMMDDHHss
	private String currentDay; // DD/MM/YYYY
	private String currentMode; // Day, Week, Month
	private String currentStep; // Previous, Next
	
	private boolean dataAdmin;
	private boolean dataOwner;
	private boolean dataOverLimitCheckOut;
	private String timeOverLimitCheckOut;
	
//	Getter and Setter
	public String getEventIdFocus() {
		return eventIdFocus;
	}
	public void setEventIdFocus(String eventIdFocus) {
		this.eventIdFocus = eventIdFocus;
	}
	public String getEventIdSelected() {
		return eventIdSelected;
	}
	public void setEventIdSelected(String eventIdSelected) {
		this.eventIdSelected = eventIdSelected;
	}
	public String getRoomIdSelected() {
		return roomIdSelected;
	}
	public void setRoomIdSelected(String roomIdSelected) {
		this.roomIdSelected = roomIdSelected;
	}
	public String getBookingIdSelected() {
		return bookingIdSelected;
	}
	public void setBookingIdSelected(String bookingIdSelected) {
		this.bookingIdSelected = bookingIdSelected;
	}
	public String getMethodSelected() {
		return methodSelected;
	}
	public void setMethodSelected(String methodSelected) {
		this.methodSelected = methodSelected;
	}
	public String getStartEventDate() {
		return startEventDate;
	}
	public void setStartEventDate(String startEventDate) {
		this.startEventDate = startEventDate;
	}
	public String getEndEventDate() {
		return endEventDate;
	}
	public void setEndEventDate(String endEventDate) {
		this.endEventDate = endEventDate;
	}
	public String getCurrentDateTime() {
		return currentDateTime;
	}
	public void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
	public String getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(String currentDay) {
		this.currentDay = currentDay;
	}
	public String getCurrentMode() {
		return currentMode;
	}
	public void setCurrentMode(String currentMode) {
		this.currentMode = currentMode;
	}
	public String getCurrentStep() {
		return currentStep;
	}
	public void setCurrentStep(String currentStep) {
		this.currentStep = currentStep;
	}
	public boolean isDataAdmin() {
		return dataAdmin;
	}
	public void setDataAdmin(boolean dataAdmin) {
		this.dataAdmin = dataAdmin;
	}
	public boolean isDataOwner() {
		return dataOwner;
	}
	public void setDataOwner(boolean dataOwner) {
		this.dataOwner = dataOwner;
	}
	public boolean isDataOverLimitCheckOut() {
		return dataOverLimitCheckOut;
	}
	public void setDataOverLimitCheckOut(boolean dataOverLimitCheckOut) {
		this.dataOverLimitCheckOut = dataOverLimitCheckOut;
	}
	public String getTimeOverLimitCheckOut() {
		return timeOverLimitCheckOut;
	}
	public void setTimeOverLimitCheckOut(String timeOverLimitCheckOut) {
		this.timeOverLimitCheckOut = timeOverLimitCheckOut;
	}
	
	

}
