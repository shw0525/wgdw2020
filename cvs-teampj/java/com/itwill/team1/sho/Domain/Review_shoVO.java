
package com.itwill.team1.sho.Domain;

import java.sql.Timestamp;

public class Review_shoVO {
	String cvs_title,category,g_name,content,nickname;
	int re_ref,starScore,r_num,g_num;
	Timestamp re_date;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCvs_title() {
		return cvs_title;
	}
	public void setCvs_title(String cvs_title) {
		this.cvs_title = cvs_title;
	}
	public int getG_num() {
		return g_num;
	}
	public void setG_num(int g_num) {
		this.g_num = g_num;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getStarScore() {
		return starScore;
	}
	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public Timestamp getRe_date() {
		return re_date;
	}
	public void setRe_date(Timestamp re_date) {
		this.re_date = re_date;
	}
	@Override
	public String toString() {
		return "Review_shoVO [cvs_title=" + cvs_title + ", category=" + category + ", g_name=" + g_name + ", content="
				+ content + ", nickname=" + nickname + ", re_ref=" + re_ref + ", starScore=" + starScore + ", r_num="
				+ r_num + ", g_num=" + g_num + ", re_date=" + re_date + "]";
	}
	
	
	
}

