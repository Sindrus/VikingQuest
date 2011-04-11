package v1;

public class Move{
	
	public static void executeMove(Player p, char c){
		Coordinate retning = new Coordinate(c);
		if (!isSomethingBlocking(p,c)){
			p.getcMap().updateMap(retning, p);
		}
	}

	public static boolean isSomethingBlocking(Player p, char c) {
		Coordinate retning = new Coordinate(c);
		Coordinate player = new Coordinate(p.getPlayerPos());
		if (Map.isGrass(p.getcMap(), (Coordinate.plus(player, retning))) ||
			Map.isBridge(p.getcMap(), Coordinate.plus(player, retning))){
			return false;
		} else {
			return true;
		}
	}

	public static boolean isMarketNearby(Player p, char c) {
		Coordinate retning = new Coordinate(c);
		Coordinate player = new Coordinate(p.getPlayerPos());
		if (Map.isMarket(p.getcMap(), Coordinate.plus(player, retning))){
			return true;
		} else {
			return false;
		}
	}

	public static boolean isVillageNearby(Player p, char c) {
		Coordinate retning = new Coordinate(c);
		Coordinate player = new Coordinate(p.getPlayerPos());
		if (Map.isVillage(p.getcMap(), Coordinate.plus(player, retning))){
			return true;
		} else {
			return false;
		}
	}
}