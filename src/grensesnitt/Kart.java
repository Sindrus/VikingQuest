package grensesnitt;

import v1.Coordinate;
import v1.Player;

/*
 * 	//Hvordan kartet er bygd opp og bygger kartet on the go
 *	//Ikke bosetninger og barbarer og markeder ved siden av hverandre
 *	//Vi bør vente med barbarer til resten av spillet funker som det skal
 *
 *	Gress:		’g’
 *	Tre:		‘t’
 *	Spiller:	‘p’
 *	Barbar:		‘b’
 *	Landsby:	‘l’
 *	Vann:		‘v’
 *	Stein:		‘s’
 *	Marked:		’m’
 *	Bro:		'c'
 *  Spiller_på_bro 'k'
 *
 */

public interface Kart {
	// ArrayList<ArrayList<Character>> charMap
	// public void Map(int x, int y);		//Constructor, skal initialisere ArrayListen og området som er synlig
	
	public void updateMap(Coordinate c, Player P);		//Oppdaterer kartet iforhold til playerinput char c
}
