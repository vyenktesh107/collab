package com.cjc.Consumer_InevntoryApp.model;

public class Product {
	private int id;
	private String pname;
	private String pdetail;
	private Supplier sup;
	public Supplier getSup() {
		return sup;
	}
	public void setSup(Supplier sup) {
		this.sup = sup;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}

}
