public class Pitcher extends Player {
	
	private double earnRunAverage;
	
	public Pitcher(String name, int number, String school, String position, double era) {
		super(name, number, school, position);
		this.earnRunAverage = era;
	}

	/**
	 * @return the earnRunAverage
	 */
	public double getEarnRunAverage() {
		return earnRunAverage;
	}

	/**
	 * @param earnRunAverage the earnRunAverage to set
	 */
	public void setEarnRunAverage(double earnRunAverage) {
		this.earnRunAverage = earnRunAverage;
	}
	
	/*
	 * Override Player print method
	 */
	
	public void print() {
		super.print();
		System.out.println("ERA: " + earnRunAverage);
	}

}
