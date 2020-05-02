package model;

public class World {
	private double totalConfirmed;
	private double newConfirmed;
	private double totalDeaths;
	private double newDeaths;
	private double totalRecovered;
	private double newRecovered;
	private String date;
	
	public World(double totalConfirmed, double newConfirmed, double totalDeaths, double newDeaths, double totalRecovered, double newRecoverd, String date) {
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

	public double getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Double totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public double getNewConfirmed() {
		return newConfirmed;
	}

	public void setNewConfirmed(Double newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public double getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Double totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public double getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Double newDeaths) {
		this.newDeaths = newDeaths;
	}

	public double getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Double totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public double getNewRecovered() {
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
