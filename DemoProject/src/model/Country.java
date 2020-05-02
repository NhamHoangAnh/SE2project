package model;

public class Country {
	private int cId;
	private double newConfirmed;
	private double totalConfirmed;
	private double newDeaths;
	private double totalDeaths;
	private double newRecovered;
	private double totalRecovered;
	private String country;
	private String date;
	private String countryCode;
	
	public Country(int cId, String country, double newConfirmed, double totalConfirmed, double newDeaths, double totalDeaths, double newRecovered, double totalRecovered, String date, String countryCode) {
		super();
		this.cId = cId;
		this.newConfirmed = newConfirmed;
		this.totalConfirmed = totalConfirmed;
		this.newDeaths = newDeaths;
		this.totalDeaths = totalDeaths;
		this.newRecovered = newRecovered;
		this.totalRecovered = totalRecovered;
		this.country = country;     
		this.date = date;
		this.countryCode = countryCode;

	}
	
	public Country() {}

	public int getcId() {
		return cId;
	}

	public double getNewConfirmed() {
		return newConfirmed;
	}

	public void setNewConfirmed(Double newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public double getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Double totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public double getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Double newDeaths) {
		this.newDeaths = newDeaths;
	}

	public double getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Double totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public double getNewRecovered() {
		return newRecovered;
	}

	public void setNewRecovered(Double newRecovered) {
		this.newRecovered = newRecovered;
	}

	public double getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Double totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
}
