package v1;

public class Move /*implements grensesnitt.Flytt*/{
	
	public static void executeMove(Player p, char c){
		Coordinate retning = new Coordinate(c);
		if (!isSomethingBlocking(p,c)){
			p.getcMap().updateMap(retning, p);
			p.getcMap().increaseColoumns(p);
			p.getcMap().increaseRows(p);
		}
	}

	public static boolean isSomethingBlocking(Player p, char c) {
		Coordinate retning = new Coordinate(c);
		Coordinate player = new Coordinate(p.getPlayerPos());
		if (p.getcMap().charMap.get(Coordinate.plus(player, retning).coord[0]).get(Coordinate.plus(player, retning).coord[1]) == 'g' ||
			p.getcMap().charMap.get(Coordinate.plus(player, retning).coord[0]).get(Coordinate.plus(player, retning).coord[1]) == 'c'){
			return false;
		} else {
			return true;
		}
	}

	public static boolean isMarketNearby(Player p, char c) {
		Coordinate retning = new Coordinate(c);
		Coordinate player = new Coordinate(p.getPlayerPos());
		if (p.getcMap().charMap.get(Coordinate.plus(player, retning).coord[0]).get(Coordinate.plus(player, retning).coord[1]) == 'm'){
			return true;
		} else {
			return false;
		}
	}

	public static boolean isVillageNearby(Player p, char c) {
		Coordinate retning = new Coordinate(c);
		Coordinate player = new Coordinate(p.getPlayerPos());
		if (p.getcMap().charMap.get(Coordinate.plus(player, retning).coord[0]).get(Coordinate.plus(player, retning).coord[1]) == 'l'){
			return true;
		} else {
			return false;
		}
	}
}