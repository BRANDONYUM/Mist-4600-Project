public class Hitter extends Player{
	
	private double battingAvg;
	
	public Hitter(String name, int number, String school, String position, double ba) {
		super(name, number, school, position);
		this.battingAvg = ba;
	}

	/**
	 * @return the battingAvg
	 */
	public double getBattingAvg() {
		return battingAvg;
	}

	/**
	 * @param battingAvg the battingAvg to set
	 */
	public void setBattingAvg(int battingAvg) {
		this.battingAvg = battingAvg;
	}
	
	/*
	 * Override Player print method 
	 */
	
	public void print() {
		super.print();
		System.out.println("AVG: " + battingAvg);
	}
	
	
	

}
