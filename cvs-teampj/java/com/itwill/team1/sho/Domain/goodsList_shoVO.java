
package com.itwill.team1.sho.Domain;

import java.util.Date;


public class goodsList_shoVO {
	String cvs_title,category,g_name;
	int g_num,stock,price,discount;
	Date term_date;
	public String getCvs_title() {
		return cvs_title;
	}
	public void setCvs_title(String cvs_title) {
		this.cvs_title = cvs_title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public Integer getG_num() {
		return g_num;
	}
	public void setG_num(int g_num) {
		this.g_num = g_num;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getTerm_date() {
		return term_date;
	}
	public void setTerm_date(Date term_date) {
		this.term_date = term_date;
	}
	@Override
	public String toString() {
		return "goodsList_shoVO [cvs_title=" + cvs_title + ", category=" + category + ", g_name=" + g_name + ", g_num="
				+ g_num + ", stock=" + stock + ", price=" + price + ", discount=" + discount + ", term_date="
				+ term_date + "]";
	}
	
	
}

