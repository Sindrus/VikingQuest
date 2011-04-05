package grensesnitt;

/*
 * 
 * 	Private int gull;
 *	Private int skatter;
 *	Private int mat;
 *	Private int soldater; 
 * 
 */

public interface Bosetning {

	public void Village();		//Constructor, initialiserer, gull, mat, soldater, skatter
	public int getSoldater();	//Returnerer soldater i byen
	public int getSkatter();	//Returnerer skatter i byen
	public int getMat();		//Returnerer mat i byen
	public int getGull();		//Returnerer gull i byen
	
}
