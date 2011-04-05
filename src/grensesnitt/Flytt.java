package grensesnitt;

public interface Flytt {

	boolean isSomethingBlocking();	//Finner ut om det er noe i veien for spilleren
	boolean isMarketNearby();		//Sjekker om spilleren er ved siden av spilleren
	boolean isVillageNearby();		//Sjekker om det er en bosetning ved siden av

}
