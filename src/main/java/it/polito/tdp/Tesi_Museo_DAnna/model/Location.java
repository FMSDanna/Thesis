package it.polito.tdp.Tesi_Museo_DAnna.model;

public class Location {
	int objectid;
	String room;
	
	public Location(int objectid, String room) {
		this.objectid = objectid;
		this.room = room;
	}
	public int getObjectid() {
		return objectid;
	}
	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
}