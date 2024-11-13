import java.util.*;

public class Team {
	
	private String teamName;
	protected ArrayList<Player> teamPlayers;
	
	public Team(String name) {
		this.teamName = name;
		teamPlayers = new ArrayList<Player>();
		
	}
	
	public void draftPlayer(Player p) {
		teamPlayers.add(p);
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	
	public int getTeamPlayersSize() {
		return teamPlayers.size();
	}
	
	public void printTeamDraft() {
		for(int i = 0; i < teamPlayers.size(); i++) {
			System.out.println("Pick " + (i+1) + ": " + teamPlayers.get(i).getName());
		}
	}

}
