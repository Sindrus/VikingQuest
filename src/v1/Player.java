package v1;

public class Player implements grensesnitt.Spiller {
private int[] playerPos = new int[2];
private int gull;
private int mat;
private int soldater;
private Map cMap;

	public int[] getPlayerPos() {
		this.setPlayerPos();
		return playerPos;
	}
		
	private void setPlayerPos(){
		for (int i = 0; i < this.cMap.charMap.size(); i++){
			for (int j = 0; j < this.cMap.charMap.get(i).size(); j++){
				if (this.cMap.charMap.get(i).get(j) == 'p'){
					this.playerPos[0] = i;
					this.playerPos[1] = j;
				}
			}
		}
	}
	
	public Player(Map newMap, int x, int y){
			newMap.charMap.get(y/2).set(x/2, 'p');
			this.cMap = newMap;
			newMap.players.add(this);
			this.gull = 100;
			this.mat = 50;
			this.soldater = 100;
	}
	
	public void removePlayerFromMap(Map oldMap){
		oldMap.players.remove(this);
		this.cMap = null;
	}

	public int getGull() {
		return gull;
	}


	public void setGull(int gold) {
		this.gull = gold;
	}
	
	public void addGull(int gold){
		this.gull+=gold;
	}

	
	public void buySoldater(){
		this.addGull(-20);
		this.addSoldater(10);
	}
	
	
	public int getMat() {
		return mat;
	}


	public void setMat(int food) {
		this.mat = food;
	}
	
	public void addFMat(int food){
		this.mat +=food;
	}


	public int getSoldater() {
		return soldater;
	}


	public void setSoldater(int soldier) {
		this.soldater = soldier;
	}
	
	public void addSoldater(int soldiers){
		this.soldater+=soldiers;
	}


	public Map getcMap() {
		return cMap;
	}


	public void setcMap(Map cMap) {
		this.cMap = cMap;
	}
}
