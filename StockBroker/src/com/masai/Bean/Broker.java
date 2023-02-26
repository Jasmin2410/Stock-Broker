package com.masai.Bean;

public class Broker {
	private String Broker_id;
	private String Broker_password;
	
	public Broker() {}
	
	public Broker(String Broker_id, String Broker_password) {
		super();
		this.Broker_id = Broker_id;
		this.Broker_password = Broker_password;
	}

	@Override
	public String toString() {
		return "Broker [Broker_id=" + Broker_id + ", Broker_password=" + Broker_password + "]";
	}

	public String getBroker_id() {
		return Broker_id;
	}

	public void setBroker_id(String broker_id) {
		Broker_id = broker_id;
	}

	public String getBroker_password() {
		return Broker_password;
	}

	public void setBroker_password(String broker_password) {
		Broker_password = broker_password;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
