package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {

	private int id;
	
	private int roomId;
	private String roomNo;
	private String roomName;
	
	private int userId;
	private String userName;
	private String userPhone;
	
	private LocalDateTime bookingDateTime;
	
	private String Remark;
	
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}
	
	
	public String getBookingDateTimeFormat() {
		return bookingDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
	
	public String getDate() {
		String formattedDate = bookingDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return formattedDate;
	}
	
	public String getTime() {
		String formattedTime = bookingDateTime.format(DateTimeFormatter.ofPattern("HH:mm")); 
		return formattedTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Booking() {
		super();
	}
	
	public Booking(int roomId, int userId, LocalDateTime bookingDateTime, String remark, int status) {
		super();
		this.roomId = roomId;
		this.userId = userId;
		this.bookingDateTime = bookingDateTime;
		Remark = remark;
		this.status = status;
	}

	public Booking(int id, int roomId, int userId, LocalDateTime bookingDateTime, String remark, int status) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.userId = userId;
		this.bookingDateTime = bookingDateTime;
		Remark = remark;
		this.status = status;
	}

	public Booking(int id, int roomId, String roomNo, String roomName, int userId, String userName, String userPhone,
			LocalDateTime bookingDateTime, String remark, int status) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.bookingDateTime = bookingDateTime;
		Remark = remark;
		this.status = status;
	}
	
	
}
