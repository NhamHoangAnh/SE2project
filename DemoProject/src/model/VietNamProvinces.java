package model;

public class VietNamProvinces {

	private String name;
	private double confirmed;
	private double deaths;
	private double recovered;
	private double underTreatment;
	private String date;
	
	
	public VietNamProvinces( String name, double confirmed, double deaths, double recovered, double underTreatment, String date) {
		super() ;
		
		this.name = name;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.underTreatment = underTreatment;
		this.date = date;
				
	}
	
	

	public VietNamProvinces() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Double confirmed) {
		this.confirmed = confirmed;
	}

	public double getDeaths() {
		return deaths;
	}

	public void setDeaths(Double deaths) {
		this.deaths = deaths;
	}

	public double getRecovered() {
		return recovered;
	}

	public void setRecovered(Double recovered) {
		this.recovered = recovered;
	}

	public double getUnderTreatment() {
		return underTreatment;
	}

	public void setUnderTreatment(Double underTreatment) {
		this.underTreatment = underTreatment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "VietNamProvinces [name=" + name + ", confirmed=" + confirmed + ", deaths=" + deaths + ", recovered="
				+ recovered + ", underTreatment=" + underTreatment + ", date=" + date + "]";
	}
	
}
