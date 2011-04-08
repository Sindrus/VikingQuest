package v1;

import grensesnitt.Spiller;

public class Barbarian implements Spiller{
private Coordinate playerPos = new Coordinate(0,0);
private int gull, mat, soldater;
private Map cMap;

	public Barbarian(Map newMap, int x, int y){
		this.soldater = (int) (51*(Math.random()));
		this.gull = (int) (soldater/8);
		this.mat = (int) (soldater/4);
	}

	public Coordinate getPlayerPos() {
		this.setPlayerPos();
		return playerPos;
	}
	
	private void setPlayerPos(){
		for (int i = 0; i < this.cMap.charMap.size(); i++){
			for (int j = 0; j < this.cMap.charMap.get(i).size(); j++){
				if (this.cMap.charMap.get(i).get(j) == 'p'){
					this.playerPos.coord[0] = i;
					this.playerPos.coord[1] = j;
				}
			}
		}
	}

	public int getGull() {
		return gull;
	}

	public int getMat() {
		return mat;
	}

	public int getSoldater() {
		return soldater;
	}
	
	public void addSoldater(int soldier) {
		this.soldater += soldier;
	}
}
