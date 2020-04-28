package model;

public class World {
	private Double totalConfirmed;
	private Double newConfirmed;
	private Double totalDeaths;
	private Double newDeaths;
	private Double totalRecovered;
	private Double newRecovered;
	private String date;
	
	public World(Double totalConfirmed, Double newConfirmed, Double totalDeaths, Double newDeaths, Double totalRecovered, Double newRecoverd, String date) {
		super();
		this.totalConfirmed = totalConfirmed;
		this.newConfirmed = newConfirmed;
		this.totalDeaths = totalDeaths;
		this.newDeaths = newDeaths;
		this.totalRecovered = totalRecovered;
		this.newRecovered = newRecoverd;
		this.date = date;
	}
	
	public World() {
		
	}

	public Double getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Double totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public Double getNewConfirmed() {
		return newConfirmed;
	}

	public void setNewConfirmed(Double newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public Double getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Double totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Double getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Double newDeaths) {
		this.newDeaths = newDeaths;
	}

	public Double getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Double totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public Double getNewRecovered() {
		return newRecovered;
	}

	public void setNewRecovered(Double newRecovered) {
		this.newRecovered = newRecovered;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
