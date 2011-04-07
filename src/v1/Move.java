package v1;

public class Move implements grensesnitt.Flytt{
	
	public void executeMove(Map m, Player p, char c){
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
		if (!isSomethingBlocking(m,p,c)){
			m.updateMap(retning, p);
		}
	}

	public boolean isSomethingBlocking(Map m, Player p, char c) {
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
		if (!m.outsideOfMap(retning) && (
				m.charMap.get(retning.coord[0]).get(retning.coord[1]) == 'g' ||
				m.charMap.get(retning.coord[0]).get(retning.coord[1]) == 'c')){
			return false;
		} else {
			return true;
		}
	}


	public boolean isMarktNearby(Map m, Player p, char c) {
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
		if (m.charMap.get(retning.coord[0]).get(retning.coord[0]) == 'm'){
			return true;
		} else {
			return false;
		}
	}

	public boolean isVillageNearby(Map m, Player p, char c) {
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
		if (m.charMap.get(retning.coord[0]).get(retning.coord[0]) == 'l'){
			return true;
		} else {
			return false;
		}
	}
	

}
