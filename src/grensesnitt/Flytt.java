package grensesnitt;

import v1.Map;
import v1.Player;




public interface Flytt {
	public void executeMove(Map m, Player p, char c);
	boolean isSomethingBlocking(Map m, Player p, char c );	//Finner ut om det er noe i veien for spilleren
	boolean isMarktNearby(Map m, Player p, char c);		//Sjekker om spilleren er ved siden av spilleren
	boolean isVillageNearby(Map m, Player p, char c);		//Sjekker om det er en bosetning ved siden av

}
