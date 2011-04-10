package v1;

public class Village implements grensesnitt.Bosetning{
private int gull, soldater, mat;
private boolean destroyed;

	public Village() {
		this.soldater = (int) (51*(Math.random()));
		this.gull = (int) (soldater/4);
		this.mat = (int) (soldater/2);
		destroyed = false;
	}
	
	public boolean isDestroyed(){
		return destroyed;
	}
	
	public void setDestroyed(boolean tf){
		destroyed = tf;
	}
	
	public int getSoldater() {
		return soldater;
	}

	public int getMat() {
		return mat;
	}

	public int getGull() {
		return gull;
	}
	
	public void addSoldater(int soldier) {
		this.soldater += soldier;
	}
	
	public static void buySoldiers(Player p){
		while (p.getGull() > 9) {
			p.addSoldater(10);
			p.addGull(-20);
		}
	}
	
	public static void buyFood(Player p){
		while (p.getGull() > 9) {
			p.addMat(5);
			p.addGull(-10);
		}
	}
}
