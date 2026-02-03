package models;

public class Room {

	private int id;
	private String roomNo;
	private String roomName;
	private int status;
	
	public Room() {
		super();
	}
	
	public Room(String roomNo, String roomName, int status) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.status = status;
	}


	public Room(int id, String roomNo, String roomName, int status) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

}
