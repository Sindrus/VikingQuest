package v1;

public class Move /*implements grensesnitt.Flytt*/{
	
	public static void executeMove(Player p, char c){
		Coordinate retning = new Coordinate (0,0);
		if (c == 'w'){
			retning.coord[0] = -1;
		} else if (c == 'a'){
			retning.coord[1] = -1;
		}else if (c == 's'){
			retning.coord[0] = 1;
		}else
			retning.coord[1] = 1;
		
		
		if (!isSomethingBlocking(p,c)){
			p.getcMap().updateMap(retning, p);
		}
	}

	public static boolean isSomethingBlocking(Player p, char c) {
		Coordinate retning = new Coordinate (0,0);
		if (c == 'w'){
			retning.coord[0] = -1;
		} else if (c == 'a'){
			retning.coord[1] = -1;
		}else if (c == 's'){
			retning.coord[0] = 1;
		}else {
			retning.coord[1] = 1;
		}
		if (p == null) System.out.println("p var null");
		if (p == null) System.out.println("p var null");
		if (!p.getcMap().outsideOfMap(retning) && (
				p.getcMap().charMap.get(retning.coord[0]).get(retning.coord[1]) == 'g' ||
				p.getcMap().charMap.get(retning.coord[0]).get(retning.coord[1]) == 'c')){
			return false;
		} else {
			return true;
		}
	}

	public static boolean isMarketNearby(Player p, char c) {
		Coordinate retning = new Coordinate (0,0);
		if (c == 'w'){
			retning.coord[0] = -1;
		} else if (c == 'a'){
			retning.coord[1] = -1;
		}else if (c == 's'){
			retning.coord[0] = 1;
		}else {
			retning.coord[1] = 1;
		}
		if (p.getcMap().charMap.get(retning.coord[0]).get(retning.coord[0]) == 'm'){
			return true;
		} else {
			return false;
		}
	}

	public static boolean isVillageNearby(Player p, char c) {
		Coordinate retning = new Coordinate (0,0);
		if (c == 'w'){
			retning.coord[0] = -1;
		} else if (c == 'a'){
			retning.coord[1] = -1;
		}else if (c == 's'){
			retning.coord[0] = 1;
		}else {
			retning.coord[1] = 1;
		}
		if (p.getcMap().charMap.get(retning.coord[0]).get(retning.coord[0]) == 'l'){
			return true;
		} else {
			return false;
		}
	}
	
}
