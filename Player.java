
public class Player {
	
	private String name;
	private String school;
	private String position;
	private int number;
	
	
	public Player(String name, int number, String school, String position) {
		this.name = name;
		this.number = number;
		this.school = school;
		this.position = position;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	//equals override for comparing players
	public boolean equals(Player p) {
		if(this.number == p.getNumber() && this.school.contains(p.getSchool())) {
			return true;
		}
		else return false;
	}
	
	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Number: " + number);
		System.out.println("Pos: " + position);
		System.out.println("School: " + school);
	}

}
