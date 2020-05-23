package com.itwill.team1.sho.Domain;

public class address_latlng_shoVO {

	String cvs_title,id;
	Double cvs_locationX,cvs_locationY;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCvs_title() {
		return cvs_title;
	}
	public void setCvs_title(String cvs_title) {
		this.cvs_title = cvs_title;
	}
	public Double getCvs_locationX() {
		return cvs_locationX;
	}
	public void setCvs_locationX(Double cvs_locationX) {
		this.cvs_locationX = cvs_locationX;
	}
	public Double getCvs_locationY() {
		return cvs_locationY;
	}
	public void setCvs_locationY(Double cvs_locationY) {
		this.cvs_locationY = cvs_locationY;
	}
	@Override
	public String toString() {
		return "address_latlng_shoVO [cvs_title=" + cvs_title + ", id=" + id + ", cvs_locationX=" + cvs_locationX
				+ ", cvs_locationY=" + cvs_locationY + "]";
	}
	
	
}
