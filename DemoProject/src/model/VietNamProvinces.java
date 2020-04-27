package model;

public class VietNamProvinces {
	private String name;
	private Double confirmed;
	private Double deaths;
	private Double recovered;
	private Double underTreatment;
	private String date;
	
	public VietNamProvinces(String name, Double confirmed, Double deaths, Double recovered, Double underTreatment, String date) {
		super();
		this.name = name;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.underTreatment = underTreatment;
		this.date = date;
				
	}
	
	public VietNamProvinces() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Double confirmed) {
		this.confirmed = confirmed;
	}

	public Double getDeaths() {
		return deaths;
	}

	public void setDeaths(Double deaths) {
		this.deaths = deaths;
	}

	public Double getRecovered() {
		return recovered;
	}

	public void setRecovered(Double recovered) {
		this.recovered = recovered;
	}

	public Double getUnderTreatment() {
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
	
}
