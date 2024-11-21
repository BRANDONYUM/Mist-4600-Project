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
	
	
	//compares BA of a hitter object to a passed in hitter. returns true if the hitter object has a greater BA than the hitter passed in.
	public boolean betterBatAvg(Hitter h) {
		
		Hitter hit;
		hit = h;
		if(this.battingAvg > hit.getBattingAvg()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/*
	 * Override Player print method 
	 */
	public void print() {
		super.print();
		System.out.println("AVG: " + battingAvg);
	}
	
	
	

}

