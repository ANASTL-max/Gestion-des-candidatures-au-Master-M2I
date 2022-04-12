package com.example.demo;

public class CountSession2 {
	 private String s2session;
 	 private Long pct;
	public String getS2session() {
		return s2session;
	}
	public void setS2session(String s2session) {
		this.s2session = s2session;
	}
	public Long getPct() {
		return pct;
	}
	public void setPct(Long pct) {
		this.pct = pct;
	}
	public CountSession2(String s2session, Long pct) {
		super();
		this.s2session = s2session;
		this.pct = pct;
	}
}
