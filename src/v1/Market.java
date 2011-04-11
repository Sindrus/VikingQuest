package v1;

public class Market {

	public static void buySoldiers(Player p){
		if(p.getGull() > 19) {
			p.addSoldater(10);
			p.addGull(-20);
		}
	}
	
	public static void buyFood(Player p){
		if(p.getGull() > 9) {
			p.addMat(5);
			p.addGull(-10);
		}
	}
}
