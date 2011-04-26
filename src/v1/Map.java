package v1;

import java.util.ArrayList;

public class Map implements grensesnitt.Kart{
public double riverChance = 0.1;
public double marketChance = 0.15;
public double villageChance = 0.25;
public double percentageOccupied = 0.2;
public ArrayList<ArrayList<Character>> charMap = new ArrayList<ArrayList<Character>>();
public ArrayList<Player> players = new ArrayList<Player>();

	public void updateMap(Coordinate c, Player p){
		Coordinate player = new Coordinate(p.getPlayerPos());
		if (isBridge(this, Coordinate.plus(c, player))){
			if (wasBridge(this, player)){
				setBridge(this, player);
			} else {
				setGrass(this, player);
			}
			setPlayerOnBridge(this, Coordinate.plus(c, player));
		} else {
			if (wasBridge(this, player)){
				setBridge(this, player);
			} else {
				setGrass(this, player);	
			}
			setPlayer(this, Coordinate.plus(c, player));
		}
		System.out.println(this);
	}
	
	public void increaseRows(Player p){
		int Rows = this.charMap.size();
		if (p.getPlayerPos().coord[0] < 20){
			this.increaseRows2(-1);
		} else if (p.getPlayerPos().coord[0] > (Rows - 25)){
			this.increaseRows2(1);
		}
	}

	public void increaseColoumns(Player p){
		int Coloumns = this.charMap.get(0).size();
		if (p.getPlayerPos().coord[1] < 20){
			this.increaseColoumns2(-1);
		} else if (p.getPlayerPos().coord[1] > (Coloumns - 25)){
			this.increaseColoumns2(1);
		}
	}
		
	private void increaseRows2(int y){
		if (y < 0){
			for (int i = 0; i < 25; i++){
			this.charMap.add(0, new ArrayList<Character>());//Legger til 25 nye rader
			}
			for (int i = 0; i < 25; i++){
			for (int j = 0; j < this.charMap.get(25).size(); j++){//Legger til like mange kolonner som rad 25 har.
			this.charMap.get(i).add(j, 'g'); //Legger til gress p� dette koordinatet.
			}
			}
//			this.generateChunk(0, this.charMap.get(0).size());
			} else if (y > 0){
			for (int i = 0; i < 25; i++){
			this.charMap.add(new ArrayList<Character>());//Legge til 25 nye rader
			}
			for (int i = (this.charMap.size() - 25); i < this.charMap.size(); i++){
			for (int j = 0; j < this.charMap.get(0).size(); j++){
			this.charMap.get(i).add(j, 'g');//Legger til gress p� dette koordinatet
			}
			}
//			this.generateChunk(this.charMap.size() - 25, this.charMap.get(0).size());
			}
	}
	
	private void increaseColoumns2(int x){
		if (x < 0){
			for (int i = 0; i < 25; i ++){
				for (int j = 0; j < this.charMap.size(); j++){
					this.charMap.get(j).add(0, 'g');
				}
				i++;
			}
//			this.generateChunk(0, 25);
			} else if (x > 0){
			for (int i = 0; i < 25; i++){
				for (int j = 0; j < this.charMap.size(); j++){
					this.charMap.get(j).add('g');
				}
				i++;
			}
//			this.generateChunk(0, (this.charMap.get(0).size() - 25));
		}
	}
	
	private void generateChunk(char c){
		if (c == 'w'){
			ArrayList<Coordinate> path = new ArrayList<Coordinate>();
			for (int i = 0; i < this.charMap.get(0).size(); i++){
				path.add(new Coordinate(0,i));
			}
			int spaceToBeOccupied = (int) (path.size()*this.percentageOccupied);
			int totalSpace = path.size();
			while(this.spaceAvailable(path) > (totalSpace - spaceToBeOccupied)){
				this.randomObject(path);
			}
		} else if (c == 'a'){
			ArrayList<Coordinate> path = new ArrayList<Coordinate>();
			for (int i = 0; i < this.charMap.size(); i++){
				path.add(new Coordinate(i,0));
			}
			int spaceToBeOccupied = (int) (path.size()*this.percentageOccupied);
			int totalSpace = path.size();
			while(this.spaceAvailable(path) > (totalSpace - spaceToBeOccupied)){
				this.randomObject(path);
			}
		} else if (c == 's'){
			ArrayList<Coordinate> path = new ArrayList<Coordinate>();
			for (int i = 0; i < this.charMap.get(0).size(); i++){
				path.add(new Coordinate(this.charMap.size() - 1,i));
			}
			int spaceToBeOccupied = (int) (path.size()*this.percentageOccupied);
			int totalSpace = path.size();
			while(this.spaceAvailable(path) > (totalSpace - spaceToBeOccupied)){
				this.randomObject(path);
			}
		} else if (c == 'd'){
			ArrayList<Coordinate> path = new ArrayList<Coordinate>();
			for (int i = 0; i < this.charMap.size(); i++){
				path.add(new Coordinate(i,this.charMap.get(0).size() - 1));
			}
			int spaceToBeOccupied = (int) (path.size()*this.percentageOccupied);
			int totalSpace = path.size();
			while(this.spaceAvailable(path) > (totalSpace - spaceToBeOccupied)){
				this.randomObject(path);
			}
		}
	}
		
	private int spaceAvailable(ArrayList<Coordinate> a){
		int b = 0;
		for (int i = 0; i < a.size(); i++){
			if (isGrass(this, a.get(i))){
				b += 1;
			}
		}
		return b;
	}
	
	public boolean outsideOfChunk(Coordinate rC, int y, int x){
		if ((rC.coord[0] < 0) || (rC.coord[1] < 0) ||
				(rC.coord[0] >= this.charMap.size()) ||
				(rC.coord[1] >= this.charMap.get(rC.coord[0]).size())) {
				return true;
			} else {
				return false;
			}
	}
	
	public Map(int x, int y){
		for (int i = 0; i < y; i++){
			this.charMap.add(new ArrayList<Character>());
			for (int j = 0; j < x; j++){
				this.charMap.get(i).add('g');
			}
		}
		generateMap();
	}
	
	private boolean availableSpot(Coordinate rC){
		Coordinate[] i = new Coordinate[] {
				new Coordinate(rC.coord[0] - 1, rC.coord[1]),//Øvre nabo
				new Coordinate(rC.coord[0] + 1, rC.coord[1]),//Nedre nabo
				new Coordinate(rC.coord[0], rC.coord[1] - 1),//Venstre nabo
				new Coordinate(rC.coord[0], rC.coord[1] + 1),//Høyre nabo
				new Coordinate(rC.coord[0] + 1, rC.coord[1] + 1),
				new Coordinate(rC.coord[0] + 1, rC.coord[1] - 1),
				new Coordinate(rC.coord[0] - 1, rC.coord[1] + 1),
				new Coordinate(rC.coord[0] - 1, rC.coord[1] - 1)};
		int count = 0;
		for (int j = 0; j < i.length; j++){
			if (isGrass(this, rC)){
				if (isGrass(this, i[j])){
					count++;
				}
			}
		}
		return (count >= 7);
	}
	
	public boolean outsideOfMap(Coordinate rC){
		if ((rC.coord[0] < 0) || (rC.coord[1] < 0) ||
			(rC.coord[0] >= this.charMap.size()) ||
			(rC.coord[1] >= this.charMap.get(rC.coord[0]).size())) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isGrass(Map m, Coordinate rC){
		if (!m.outsideOfMap(rC) &&
			m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 'g'){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean wasBridge(Map m, Coordinate rC){
		if (m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 'k'){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isWater(Map m, Coordinate rC){
		if (m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 'v'){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isMarket(Map m, Coordinate rC){
		if (!m.outsideOfMap(rC) &&
			m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 'm'){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isVillage(Map m, Coordinate rC){
		if (!m.outsideOfMap(rC) &&
			m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 'l'){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isObstruction(Map m, Coordinate rC){
		if (!m.outsideOfMap(rC) && 
			(m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 't' ||
			m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 's')){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBridge(Map m, Coordinate rC){
		if (!m.outsideOfMap(rC) && 
			m.charMap.get(rC.coord[0]).get(rC.coord[1]) == 'c'){
			return true;
		} else {
			return false;
		}
	}
	
	private static void setBridge(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 'c');
	}
	
	private static void setWater(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 'v');
	}
	
	private static void setVillage(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 'l');
	}
	
	private static void setMarket(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 'm');
	}
	
	private static void setGrass(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 'g');
	}
	
	private static void setPlayer(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 'p');
	}
	
	private static void setPlayerOnBridge(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 'k');
	}
	
	private static void setStone(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 's');
	}
	
	private static void setTree(Map m, Coordinate rC){
		m.charMap.get(rC.coord[0]).set(rC.coord[1], 't');
	}
	
	public void setVillageDestroyed(Coordinate rC){
		this.charMap.get(rC.coord[0]).set(rC.coord[1], '0');
	}
	
	private boolean availableRiverSpot(Coordinate rC){
		Coordinate[] i = new Coordinate[] {
				new Coordinate(rC.coord[0] - 1, rC.coord[1]),//Øvre nabo
				new Coordinate(rC.coord[0] + 1, rC.coord[1]),//Nedre nabo
				new Coordinate(rC.coord[0], rC.coord[1] - 1),//Venstre nabo
				new Coordinate(rC.coord[0], rC.coord[1] + 1),//Høyre nabo
				new Coordinate(rC.coord[0] + 1, rC.coord[1] + 1),
				new Coordinate(rC.coord[0] + 1, rC.coord[1] - 1),
				new Coordinate(rC.coord[0] - 1, rC.coord[1] + 1),
				new Coordinate(rC.coord[0] - 1, rC.coord[1] - 1)};
		Boolean sjekk = true;
		for (int x = 0; x < 4; x++){
			if (!this.outsideOfMap(i[x])){
				if(!isGrass(this, i[x])){
					sjekk = false;
					break;
				}
					
			}
		}
		if (isGrass(this, rC)){
			if (sjekk){ 
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private void createRiver(ArrayList<Coordinate> coorMap){
		Coordinate riverStart = coorMap.get((int)(coorMap.size() * Math.random())); //Startpunkt
		Coordinate riverEnd = coorMap.get((int)(coorMap.size() * Math.random()));  //Endepunkt
		if (riverStart.compareYX(riverEnd)){
			this.createRiver(coorMap); //Om startpunkt = endepunkt, prøv igjen.
		} else {
			stretchRiver(riverStart, riverEnd);
		}
	}
	
	private void stretchRiver(Coordinate a, Coordinate b){
		ArrayList<Coordinate> Path = new ArrayList<Coordinate>();
		Path.add(b);
		boolean incomplete = true;
		int numberOfSteps = 0;
		Loop:
		for (int i = 0; i < Path.size() && incomplete; i++){ //Bredde-først søk algoritme
			boolean[] sjekk = new boolean[4];
			for (int j = 0; j < sjekk.length; j++){
				sjekk[j] = true;
			}
			Coordinate[] naboer = new Coordinate[] {
					new Coordinate(Path.get(i).coord[0] - 1, Path.get(i).coord[1], Path.get(i).coord[2] + 1),//Upper Neighbour
					new Coordinate(Path.get(i).coord[0] + 1, Path.get(i).coord[1], Path.get(i).coord[2] + 1),//Lower Neighbour
					new Coordinate(Path.get(i).coord[0], Path.get(i).coord[1] - 1, Path.get(i).coord[2] + 1),//Left Neighbour
					new Coordinate(Path.get(i).coord[0], Path.get(i).coord[1] + 1, Path.get(i).coord[2] + 1)};//Right Neighbour
			for (int j = 0; j < sjekk.length; j++){
				for (int x = 0; x < Path.size(); x++){
					if (this.outsideOfMap(naboer[j]) || //Her sjekker vi om punktet er utenfor kartet.	
						Path.get(x).compareYX(naboer[j])){ //Her sjekker vi om punktet eksisterer i Path allerede.
						sjekk[j] = false; //Setter en boolean-verdi til false som vi sjekker senere for å se om koordinatet skal legges i Path.
						break; 
					}
				}
			}
			for (int x = 0; x < naboer.length; x++){ 
				if (sjekk[x] && this.availableRiverSpot(naboer[x])){ //Her sjekker vi om vi kan legge koordinatet i Path, og gjør det om det blir godkjent.
					Path.add(naboer[x]);
					if (naboer[x].compareYX(a)){
						numberOfSteps = naboer[x].coord[2];
						incomplete = false;
						break Loop;
					}
				}
			}
		} //Når While-løkka er ferdig skal Path inneholde koordinatene som lager en sti, blant mange andre koordinater.
		ArrayList<Coordinate> finalPath = new ArrayList<Coordinate>(); //Ny ArrayList som skal kun inneholde riktig sti.
		finalPath.add(new Coordinate(a.coord[0], a.coord[1], numberOfSteps)); //Den ene enden av elven.
		for (int i = numberOfSteps; i >= 0; i--){
			for (int j = 0; j < Path.size(); j++){
				if (Path.get(j).coord[2] == (i - 1) && 
					finalPath.get(numberOfSteps - i).distance(Path.get(j)) == 1.0){
					finalPath.add(Path.get(j)); //Hvis koordinatet som vurderes er riktig nummer i rekka (antall skritt - nåværende skritt som vurderes),
					break;
				}// og avstanden mellom forrige sikre skritt og skrittet som vurderes er lik 1, så godkjennes den og blir det nye sikre skrittet.
			}
		}
		finalPath.add(new Coordinate(b.coord[0], b.coord[1]));
		for (int i = 0; i < finalPath.size(); i++){
			setWater(this, finalPath.get(i));
		} //Printer elven
		this.createBridge(finalPath, 0);
	}//Lager en bro på måfå så ikke elven lukker av deler av kartet. Broen kan i verste fall være blokkert av noe annet.
	
	private void createBridge(ArrayList<Coordinate> river, int i){
		boolean needBridge = true;
		Bro:
		while (needBridge && i < 20){
			Coordinate bridge = new Coordinate(river.get((int) (river.size()*Math.random())));
			Coordinate naboer[] = new Coordinate[] {
				new Coordinate(bridge.coord[0] - 1, bridge.coord[1]),//Øvre nabo
				new Coordinate(bridge.coord[0] + 1, bridge.coord[1]),//Nedre nabo
				new Coordinate(bridge.coord[0], bridge.coord[1] - 1),//Venstre nabo
				new Coordinate(bridge.coord[0], bridge.coord[1] + 1)};//Høyre nabo
			for (int j = 0; j < naboer.length; j++){
				if (this.outsideOfMap(naboer[j])){
					i++;
					break Bro;
				}
			}
			if ((isWater(this, naboer[0]) &&
				isWater(this, naboer[1]) &&
				isGrass(this, naboer[2]) &&
				isGrass(this, naboer[3])) ||
				(isWater(this, naboer[2]) &&
				isWater(this, naboer[3]) &&
				isGrass(this, naboer[0]) &&
				isGrass(this, naboer[1]))){
				setBridge(this, bridge);
			} 
			for (int x = 0; x < river.size(); x++){
				if (isBridge(this, river.get(x))){
					needBridge = false;
				}
			}
			if (needBridge){
				i++;
				this.createBridge(river, i);
			}
		}
	}
		
	private void randomObject(ArrayList<Coordinate> coorMap){
		double random = Math.random();
		if(random < this.riverChance){
			this.createRiver(coorMap);		
		} else if (random < this.marketChance){
			createMarket(0, coorMap);
		} else if (random < this.villageChance){
			createVillage(0, coorMap);
		} else {
			createObstruction(0, coorMap);
		}
	}
	
	private void createVillage(int i, ArrayList<Coordinate> coorMap){
		while (i < 10){
			Coordinate randomCoordinate = coorMap.get((int)(coorMap.size() * Math.random()));
			if (this.availableSpot(randomCoordinate)){
				setVillage(this, randomCoordinate);
				break;
			} else {
				i++;
				this.createVillage(i, coorMap);
			}
		}
	}
	
	private void createObstruction(int i, ArrayList<Coordinate> coorMap){
		while (i < 10){
			Coordinate randomCoordinate = coorMap.get((int)(coorMap.size() * Math.random()));
			double random = Math.random();
			if (this.availableSpot(randomCoordinate)){
				if (random < 0.5){
					setStone(this, randomCoordinate);
				} else {
					setTree(this, randomCoordinate);
				}
				break;
			} else {
				i++;
				this.createObstruction(i, coorMap);
			}
		}
	}
	
	private void createMarket(int i, ArrayList<Coordinate> coorMap){
		while (i < 10){
			Coordinate randomCoordinate = coorMap.get((int)(coorMap.size() * Math.random()));
			if (this.availableSpot(randomCoordinate)){
				setMarket(this, randomCoordinate);
				break;
			} else {
				i++;
				this.createMarket(i, coorMap);
			}
		}
	}
	
	private int spaceAvailable(){
		int a = 0;
		for (int i = 0; i < this.charMap.size(); i++){
			for (int j = 0; j < this.charMap.get(0).size(); j++){
				if (isGrass(this, new Coordinate(i, j))){
					a += 1;
				}
			}
		}
		return a;
	}
	
	private void generateMap(){
		int spaceToBeOccupied = (int) (this.charMap.size()*this.charMap.get(0).size()*this.percentageOccupied - 1);
		int totalSpace = (int) this.charMap.size()*this.charMap.get(0).size();
		ArrayList<Coordinate> coorList = new ArrayList<Coordinate>();
		for (int y = 0; y < charMap.size(); y++){
			for (int x = 0; x < charMap.get(0).size(); x++){
				coorList.add(new Coordinate(y,x));
			}
		}
		while(this.spaceAvailable() > (totalSpace - spaceToBeOccupied)){
			this.randomObject(coorList);
		}
	}
	
	public String toString(){
		String b = "";
		for (int i = 0; i < this.charMap.size(); i++){
			for (int j = 0; j < this.charMap.get(i).size(); j++){
				b += this.charMap.get(i).get(j);
			}
		b += "\n";	
		}
		return b;
	}
}