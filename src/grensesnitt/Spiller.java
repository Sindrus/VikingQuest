package grensesnitt;

import v1.Coordinate;

/*
 * 	//Klassen tar seg av kamper og handler med markeder
 *	Private int gull;
 *	Private int skatter;
 *	Private int mat;
 *	Private int soldater;
 *	Private int[] playerPos = new int[2]; int[y][x]
 * 
 */

public interface Spiller {
	
	Coordinate getPlayerPos();	//Returnerer koordinatene til spillern
	
}
