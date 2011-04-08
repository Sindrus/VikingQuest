package grensesnitt;

import v1.Barbarian;
import v1.Player;
import v1.Village;

/*
 * Move-klassen sjekker etter hver move om en fiendtlig village er i nærheten.
 * Engine sjekker for normalCombat er tilstede.
 */

public interface Kampsystem {
	
	public void normalCombat(Player player, Barbarian barbar);
	
	public void villageCombar(Player player, Village village);
	
}
