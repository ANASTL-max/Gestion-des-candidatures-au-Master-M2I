package com.example.demo;

public class CountSession6 {
	 private String s5session;
	 public CountSession6(String s5session, Long pct) {
		super();
		this.s5session = s5session;
		this.pct = pct;
	}
	public String getS5session() {
		return s5session;
	}
	public void setS5session(String s5session) {
		this.s5session = s5session;
	}
	public Long getPct() {
		return pct;
	}
	public void setPct(Long pct) {
		this.pct = pct;
	}
	private Long pct;
}
