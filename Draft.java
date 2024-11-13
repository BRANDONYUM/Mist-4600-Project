import java.util.*;

public class Draft {
	
	private static HashSet<Player> draftedPlayers;
	private HashMap<Team, Integer> draftOrder;
	private static Team[] teams;
	private Team onClock;
	Random rand = new Random();
	
	public void startDraft() {
		
		draftedPlayers = new HashSet<Player>();
		teams = new Team[30];
		
		Team az = new Team("Dimondbacks");
		teams[0] = az;
		Team oak = new Team("Athletics");
		teams[1] = oak;
		Team atl = new Team("Braves");
		teams[2] = atl;
		Team bal = new Team("Orioles");
		teams[3] = bal;
		Team bos = new Team("Red Sox");
		teams[4] = bos;
		Team cubs = new Team("Cubs");
		teams[5] = cubs;
		Team whiteSox = new Team("White Sox");
		teams[6] = whiteSox;
		Team cinci = new Team("Reds");
		teams[7] = cinci;
		Team clev = new Team("Guardians");
		teams[8] = clev;
		Team col = new Team("Rockies");
		teams[9] = col;
		Team det = new Team("Tigers");
		teams[10] = det;
		Team hou = new Team("Astros");
		teams[11] = hou;
		Team kc = new Team("Royals");
		teams[12] = kc;
		Team laA = new Team("Angels");
		teams[13] = laA;
		Team laD = new Team("Dodgers");
		teams[14] = laD;
		Team mia = new Team("Marlins");
		teams[15] = mia;
		Team mil = new Team("Brewers");
		teams[16] = mil;
		Team min = new Team("Twins");
		teams[17] = min;
		Team nyM = new Team("Mets");
		teams[18] = nyM;
		Team nyY = new Team("Yankees");
		teams[19] = nyY;
		Team phil = new Team("Phillies");
		teams[20] = phil;
		Team pit = new Team("Pirates");
		teams[21] = pit;
		Team sd = new Team("Padres");
		teams[22] = sd;
		Team sf = new Team("Giants");
		teams[23] = sf;
		Team sea = new Team("Mariners");
		teams[24] = sea;
		Team stl = new Team("Cardinals");
		teams[25] = stl;
		Team tb = new Team("Rays");
		teams[26] = tb;
		Team tx = new Team("Rangers");
		teams[27] = tx;
		Team tor = new Team("Blue Jays");
		teams[28] = tor;
		Team wash = new Team("Nationals");	
		teams[29] = wash;
		
		
		for(int i = 0; i < 30; i++) {
			draftOrder.putIfAbsent(teams[1], rand.nextInt(30));
		}
		
		
		System.out.println("Welcome to the 2024 MLB Draft");
		onClock = teams[rand.nextInt(30)];
		System.out.println(onClock.getTeamName() + " are on the clock");
			
	}
	
	public void draftPlayer(Player p) {
		draftedPlayers.add(p);
	}
	
	public Team getOnClock() {
		return onClock;
	}
	
	public void nextPick() {
		onClock = teams[rand.nextInt(30)];
		System.out.println(onClock.getTeamName() + " are on the clock");
	}
	
	
	public static void main (String []args) {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		Draft d = new Draft();
		d.startDraft();
		boolean draftDone = false;
		
		for(int i = 0; i < 1; i++) {
			System.out.println("Who would you like to draft:");
			System.out.println("Name:");
			String name = input.nextLine();
			System.out.println("Position (enter abbriviation ex. C, P, etc.): ");
			String pos = input.nextLine();
			System.out.println("Number:");
			int num = input.nextInt();
			input.nextLine();
			System.out.println("School:");
			String school = input.nextLine();
			
			if(pos.equalsIgnoreCase("P")){
				System.out.println("Please enter pitchers era:");
				double era = input.nextDouble();
				input.nextLine();
				Pitcher p = new Pitcher(name, num, school, pos, era);
				if(draftedPlayers.contains(p)) {
					System.out.println("This player has already been drafted");
				} else {
					d.draftPlayer(p);
					d.getOnClock().draftPlayer(p);
					p.print();
					System.out.println();
					d.nextPick();
					
				}
			} else {
				System.out.println("Please enter hitters batting average:");
				double ba = input.nextDouble();
				input.nextLine();
				Hitter h = new Hitter(name, num, school, pos, ba);
				if (draftedPlayers.contains(h)) {
					System.out.println("This player has already been drafted");
				} else {
					d.draftPlayer(h);
					d.getOnClock().draftPlayer(h);
					h.print();
					System.out.println();
					d.nextPick();
				}
			}
			
		}
		
		boolean isDone = false;
		System.out.println();
		System.out.println("The draft has been completed:");
		while(!isDone) {
			System.out.println("The following options are avalible:");
			System.out.println("1. Print a teams drafted players:");
			System.out.println("2. Print a players info from draft:");
			System.out.println("3. Exit the draft");
			int option = input.nextInt();
			input.nextLine();
			
			switch (option) {
	
			case 1:
				
				System.out.println("Please enter a team to list players:");
				String team = input.nextLine();
				for(int i = 0; i < 30; i++){
					if(teams[i].getTeamName().equals(team)) {
						teams[i].printTeamDraft();
					}
					
				}
				
			
				break;
				
			case 2:
				
				System.out.println("Please enter team name:");
				team = input.nextLine();
				System.out.println("Please enter player name:");
				String playerName = input.nextLine();
				for(int i = 0; i < 30; i++){
					if(teams[i].getTeamName().equals(team)) {
						for(int j = 0; i < teams[i].getTeamPlayersSize(); j++) {
							if(teams[i].teamPlayers.get(j).getName().equals(playerName)) {
								teams[i].teamPlayers.get(j).print();
							}
							else {
								System.out.println("Invalid input:");
							}
						}
					}
					
				}
				
				
				break;
				
			case 3:

				System.out.println("Exiting the draft.  Thank you for attending.");
				isDone = true;
				break;
		
			}
		}
		
				
			
		
		
	}

}
