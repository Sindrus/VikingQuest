package grensesnitt;

import v1.Coordinate;
import v1.Player;

/*
 * 	//Hvordan kartet er bygd opp og bygger kartet on the go
 *	//Ikke bosetninger og barbarer og markeder ved siden av hverandre
 *	//Vi b�r vente med barbarer til resten av spillet funker som det skal
 *
 *	Gress:		�g�
 *	Tre:		�t�
 *	Spiller:	�p�
 *	Barbar:		�b�
 *	Landsby:	�l�
 *	Vann:		�v�
 *	Stein:		�s�
 *	Marked:		�m�
 *	Bro:		'c'
 *
 */

public interface Kart {
	// ArrayList<ArrayList<character>> charMap
	// public void Map(int x, int y);		//Constructor, skal initialisere ArrayListen og omr�det som er synlig
	
	public void updateMap(Coordinate c, Player P);		//Oppdaterer kartet iforhold til playerinput char c
}
