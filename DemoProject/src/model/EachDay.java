package model;

public class EachDay {
	private String date;
	private double confirmed;
	private double recovered;
	private double deaths;
	
	public EachDay(String date, double confirmed, double recovered, double deaths) {
		this.date = date;
		this.confirmed = confirmed;
		this.recovered = recovered;
		this.deaths = deaths;
	}
	public EachDay() {
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(double confirmed) {
		this.confirmed = confirmed;
	}

	public double getRecovered() {
		return recovered;
	}

	public void setRecovered(double recovered) {
		this.recovered = recovered;
	}

	public double getDeaths() {
		return deaths;
	}

	public void setDeaths(double deaths) {
		this.deaths = deaths;
	}
}
