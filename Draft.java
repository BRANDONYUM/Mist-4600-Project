import java.util.*;

public class Draft {
	
	private static HashSet<Player> draftedPlayers;
	private static HashMap<Integer, Team> draftOrder;
	private Team[] teams;
	Random rand = new Random();
	
	public void startDraft() {
		
		draftedPlayers = new HashSet<Player>();
		teams = new Team[30];
		draftOrder = new HashMap<Integer, Team>();
		
		Team Diamondbacks = new Team("Diamondbacks");
		teams[0] = Diamondbacks;
		Team Athletics = new Team("Athletics");
		teams[1] = Athletics;
		Team Braves = new Team("Braves");
		teams[2] = Braves;
		Team Orioles = new Team("Orioles");
		teams[3] = Orioles;
		Team RedSox = new Team("Red Sox");
		teams[4] = RedSox;
		Team Cubs = new Team("Cubs");
		teams[5] = Cubs;
		Team WhiteSox = new Team("White Sox");
		teams[6] = WhiteSox;
		Team Reds = new Team("Reds");
		teams[7] = Reds;
		Team Guardians = new Team("Guardians");
		teams[8] = Guardians;
		Team Rockies = new Team("Rockies");
		teams[9] = Rockies;
		Team Tigers = new Team("Tigers");
		teams[10] = Tigers;
		Team Astros = new Team("Astros");
		teams[11] = Astros;
		Team Royals = new Team("Royals");
		teams[12] = Royals;
		Team Angels = new Team("Angels");
		teams[13] = Angels;
		Team Dodgers = new Team("Dodgers");
		teams[14] = Dodgers;
		Team Marlins = new Team("Marlins");
		teams[15] = Marlins;
		Team Brewers = new Team("Brewers");
		teams[16] = Brewers;
		Team Twins = new Team("Twins");
		teams[17] = Twins;
		Team Mets = new Team("Mets");
		teams[18] = Mets;

		Team Yankees = new Team("Yankees");
		teams[19] = Yankees;
		Team Phillies = new Team("Phillies");
		teams[20] = Phillies;
		Team Pirates = new Team("Pirates");
		teams[21] = Pirates;
		Team Padres = new Team("Padres");
		teams[22] = Padres;
		Team Giants = new Team("Giants");
		teams[23] = Giants;
		Team Mariners = new Team("Mariners");
		teams[24] = Mariners;
		Team Cardinals = new Team("Cardinals");
		teams[25] = Cardinals;
		Team Rays = new Team("Rays");
		teams[26] = Rays;
		Team Rangers = new Team("Rangers");
		teams[27] = Rangers;
		Team BlueJays = new Team("Blue Jays");
		teams[28] = BlueJays;
		Team Nationals = new Team("Nationals");
		teams[29] = Nationals;
		
		while(draftOrder.size() < 30) {
			for(int i = 0; i < 30; i++) {
				draftOrder.putIfAbsent(rand.nextInt(30), teams[i]);
			}
		}
		
		System.out.println("Welcome to the 2024 MLB Draft");

			
	}
	
	public void draftPlayer(Player p) {
		draftedPlayers.add(p);
	}
	
	public Team getNextPick(int i) {
		return draftOrder.get(i);
	}
	
	public HashSet<Player> getDraftedPlayers(){
		return draftedPlayers;
	}
	
	public Team[] getTeams() {
		return teams;
	}
	
	public Team getTeam(String teamName) {
		Team t = new Team("No Name");
		Team[] ts = getTeams();
		for(int i = 0; i < 30; i++) {
			if(ts[i].getTeamName().equalsIgnoreCase(teamName)) {
				t = ts[i];
			}
		}
		return t;
	}
	//lists drafted pitchers by name
	public void printPitchers() {
		for(Player p : draftedPlayers) {
			if (p.getPosition().equalsIgnoreCase("P")) {
				System.out.println("-"+p.getName());
			}
		}
	}
	// prints drafted pitchers ranked by ERA
	public void printPitchersRanked() {
		// calculate number of pitchers drafted
		int numPitchers = 0;
		for(Player p : draftedPlayers) {
			if (p.getPosition().equalsIgnoreCase("P")) {
				numPitchers++;
			}
		}
		
		//create and populate array of pitchers to be ranked
		Pitcher[] pitchRanks = new Pitcher[numPitchers];
		int count = 0;
		for(Player p : draftedPlayers) {
			if (p.getPosition().equalsIgnoreCase("P")) {
				pitchRanks[count] = (Pitcher) p; 
				count++;
			}
		}
		// ranks pitchRanks pitcher objects by ERA in ascending order
		for(int i = 0; i < numPitchers - 1;i++) {
			int rank = i;
			for(int j = i + 1; j < numPitchers; j++) {
				if(pitchRanks[j].lowerERA(pitchRanks[rank])) {
					rank = j;
					}
			}
			Pitcher temp = pitchRanks[rank];
			pitchRanks[rank] = pitchRanks[i];
			pitchRanks[i] = temp;
		}
		
		for(int i = 0; i < numPitchers; i++) {
			System.out.println("#" + (i + 1) + ". " + pitchRanks[i].getName() + ", Number " + pitchRanks[i].getNumber() + " from " + pitchRanks[i].getSchool() + " - ERA:" + pitchRanks[i].getEarnRunAverage());
		}
		
	}
	
	// prints out hitters listed by name
	public void printHitters() {
		for(Player p : draftedPlayers) {
			if(!p.getPosition().equalsIgnoreCase("P")) {
				System.out.println("-"+p.getName());
				
			}
		}
	}
	
	// prints hitters ranked by batting average in descending order
	public void printHittersRanked() {
		 // calculate number of hitters drafted
	    int numHitters = 0;
	    for (Player p : draftedPlayers) {
	        if (!p.getPosition().equalsIgnoreCase("P")) { 
	            numHitters++;
	        }
	    }
	    
	    // create and populate array of hitters to be ranked
	    Hitter[] hitRanks = new Hitter[numHitters];
	    int count = 0;
	    for (Player p : draftedPlayers) {
	        if (!p.getPosition().equalsIgnoreCase("P")) { 
	            hitRanks[count] = (Hitter) p;
	            count++;
	        }
	    }
	    
	 // Rank hitterRanks hitter objects by batting average in descending order
	    for (int i = 0; i < numHitters - 1; i++) {
	        int rank = i;
	        for (int j = i + 1; j < numHitters; j++) {
	            if (hitRanks[j].betterBatAvg(hitRanks[rank])) { 
	                rank = j;
	            }
	        }
	        Hitter temp = hitRanks[rank];
	        hitRanks[rank] = hitRanks[i];
	        hitRanks[i] = temp;
	    }
	    
	    // prints hitters ranked by BA in descending order
	    for(int i = 0; i < numHitters; i++) {
			System.out.println("#" + (i + 1) + ". " + hitRanks[i].getName() + ", Number " + hitRanks[i].getNumber() + " from " + hitRanks[i].getSchool() + " - AVG: " + hitRanks[i].getBattingAvg());
		}
	    
	}
	
	public static void main (String []args) {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		String name = "";
		int num = 999;
		String school = "";
		String pos = "";
		Draft d = new Draft();
		d.startDraft();
		//boolean draftDone = false;
		for(int i = 0; i < 3; i++) {
			int pickIn = 0;
			while(pickIn == 0) {
			System.out.println("The " + draftOrder.get(i).getTeamName() + " are on the clock:");

			System.out.println("Who would you like to draft?");
			System.out.println("Name:");
			name = input.nextLine();
			
			
			System.out.println("Position (enter abbreviation ex. C, P, etc.): ");
			pos = input.nextLine();
			System.out.println("Number:");
			num = input.nextInt();
			input.nextLine();
			System.out.println("School:");
			school = input.nextLine();
			
			
			//check to see if player was already drafted
			boolean picked = false;
			if(i != 0) {
				for(Player p: draftedPlayers) {
				
					Player check = new Player(name,num,school,pos);
					if(p.equals(check)) {
						System.out.println("The player has already been drafted. Please pick another player");
						picked = true;
						break;
					}
				}
				if(!picked) {
					pickIn = 1;
				}
			}
			else {
				pickIn = 1;
			}
			}
			if(pos.equalsIgnoreCase("P")){
				System.out.println("Please enter pitchers era:");
				double era = input.nextDouble();
				input.nextLine();
				Pitcher p = new Pitcher(name, num, school, pos, era);
				
					d.draftPlayer(p);
					draftOrder.get(i).draftPlayer(p);
					p.print();
					System.out.println();
				
			} else {
				System.out.println("Please enter hitters batting average:");
				double ba = input.nextDouble();
				input.nextLine();
				Hitter h = new Hitter(name, num, school, pos, ba);
				
				d.draftPlayer(h);
				draftOrder.get(i).draftPlayer(h);
				h.print();
				System.out.println();
				
			}
			
		}
		
		boolean isDone = false;
		System.out.println();
		System.out.println("The draft has been completed:");
		while(!isDone) {
			System.out.println("The following options are available:");
			System.out.println("1. Print a teams drafted players:");
			System.out.println("2. Print out all hitters or all pitchers from draft class:");
			System.out.println("3. Print out the entire 2024 draft class:");
			System.out.println("4. Exit the draft");
			int option = input.nextInt();
			input.nextLine();
			
			switch (option) {
	
			case 1:
				/*Team[] t = d.getTeams();
				System.out.println("Please enter a team to list players:");
				String team = input.nextLine();
				for(int i = 0; i < 30; i++){
					if(t[i].getTeamName().equalsIgnoreCase(team)) {
						t[i].printTeamDraft();
					}
					
				}*/
				System.out.println("Please enter a team to list players:");
				String team = input.nextLine();
				Team t = d.getTeam(team);
				t.printTeamDraft();
				
				
			
				break;
				
			case 2:
				System.out.println("Would you like to print out hitters or pitchers? For pitchers, enter \"Pitcher\"");
				String printPos = input.nextLine();
				System.out.println();
				if(printPos.equalsIgnoreCase("Pitcher")) {
					d.printPitchers();
					System.out.println();
					
					System.out.println("View pitchers ranked by ERA? 1 = YES, 0 = NO");
					int pitchResponse = input.nextInt();
					if(pitchResponse == 1) {
						d.printPitchersRanked();
						System.out.println();
					}
				} 
				else {
					d.printHitters();
					System.out.println();
					
					System.out.println("View hitters ranked by batting average? 1 = YES, 0 = NO");
					int hitResponse = input.nextInt();
					if(hitResponse == 1) {
						d.printHittersRanked();
						System.out.println();
					}
					
				}	
				
				
				break;
				
			case 3:

				for(Player p: d.getDraftedPlayers()) {
					p.print();
					System.out.println("**********************************");
				}
				System.out.println();
				
				break;
			
			case 4:
				
				System.out.println("Exiting the draft.  Thank you for attending.");
				isDone = true;
				break;
		
			}
		}
		
				
			
		
		
	}

}

		
				
