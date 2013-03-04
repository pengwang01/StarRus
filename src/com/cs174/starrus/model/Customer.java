package com.cs174.starrus.model;

public class Customer {
	private String username;
	private String psd;
	private String cname;
	private int age;
	private String phone_num;
	private String state;
	private int tax_id;
	private String email;
	private int m_account_id;
	private int s_account_id;
	private int clevel;
	private MarketAcc m_account;
	private StockAcc s_account;
	
	public Customer(){}
	
	public Customer(String username, String psd){
		this.username = username;
		this.psd = psd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getTax_id() {
		return tax_id;
	}

	public void setTax_id(int tax_id) {
		this.tax_id = tax_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getM_account_id() {
		return m_account_id;
	}

	public void setM_account_id(int m_account_id) {
		this.m_account_id = m_account_id;
	}

	public int getS_account_id() {
		return s_account_id;
	}

	public void setS_account_id(int s_account_id) {
		this.s_account_id = s_account_id;
	}

	public MarketAcc getM_account() {
		return m_account;
	}

	public void setM_account(MarketAcc m_account) {
		this.m_account = m_account;
	}

	public StockAcc getS_account() {
		return s_account;
	}

	public void setS_account(StockAcc s_account) {
		this.s_account = s_account;
	}

	public int getClevel() {
		return clevel;
	}

	public void setClevel(int clevel) {
		this.clevel = clevel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", psd=" + psd + ", cname="
				+ cname + ", age=" + age + ", phone_num=" + phone_num
				+ ", state=" + state + ", tax_id=" + tax_id + ", email="
				+ email + ", m_account_id=" + m_account_id + ", s_account_id="
				+ s_account_id + ", clevel=" + clevel + ", m_account="
				+ m_account + ", s_account=" + s_account + "]";
	}
	
}
