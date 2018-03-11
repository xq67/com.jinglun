package entity;

import java.io.Serializable;

public class DvdInfo implements Serializable{
	private int id;
	private int status;//nihao 
	private int count;
	private String name;
	private String lenttime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLenttime() {
		return lenttime;
	}
	public void setLenttime(String lenttime) {
		this.lenttime = lenttime;
	}
	
}
