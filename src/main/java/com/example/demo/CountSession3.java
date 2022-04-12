package com.example.demo;

public class CountSession3 {
	 private String s3session;
 	 public String getS3session() {
		return s3session;
	}
	public void setS3session(String s3session) {
		this.s3session = s3session;
	}
	public Long getPct() {
		return pct;
	}
	public void setPct(Long pct) {
		this.pct = pct;
	}
	private Long pct;
	public CountSession3(String s3session, Long pct) {
		super();
		this.s3session = s3session;
		this.pct = pct;
	}
}
