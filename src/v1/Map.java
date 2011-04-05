package v1;

import java.util.ArrayList;

public class Map implements grensesnitt.Kart{
public ArrayList<ArrayList<Character>> charMap = new ArrayList<ArrayList<Character>>();
private int dy; 
private int dx;
public ArrayList<Player> players = new ArrayList<Player>();

	public void updateMap(char c, Player p){
		if (c == 'w'){
			this.dy = -1;
			this.dx = 0;
		} else if (c == 'a'){
			this.dy = 0;
			this.dx = -1;
		} else if (c == 's'){
			this.dy = 1;
			this.dx = 0;
		} else if (c == 'd'){
			this.dy = 0;
			this.dx = 1;
		} else {
			this.dy = 0;
			this.dx = 0;
		}
		this.move(c,p);
		this.dy = 0;
		this.dx = 0;
	}

	public Map(int x, int y){
		for (int i = 0; i < y; i++){
			this.charMap.add(new ArrayList<Character>());
			for (int j = 0; j < x; j++){
				this.charMap.get(i).add('g');
			}
		}
		//generateMap();
		this.dy = 0;
		this.dx = 0;
	}

	private void move(char c, Player p){
		int xTemp = p.getPlayerPos()[1];
		int yTemp = p.getPlayerPos()[0];
		if ((c == 'a' || c == 'd') && 
			(this.charMap.get(yTemp + 1).get(xTemp) == 'v') &&
			(this.charMap.get(yTemp - 1).get(xTemp) == 'v')){
			this.charMap.get(yTemp).set(xTemp + dx, 'p');
			this.charMap.get(yTemp).set(xTemp, 'c');
		} else if ((c == 'w' || c == 's') && 
			(this.charMap.get(yTemp).get(xTemp + 1) == 'v') &&
			(this.charMap.get(yTemp).get(xTemp - 1) == 'v')){
			this.charMap.get(yTemp + dy).set(xTemp, 'p');
			this.charMap.get(yTemp).set(xTemp, 'c');
		} else {
			this.charMap.get(yTemp).set(xTemp, 'g');
			this.charMap.get(yTemp + dy).set(xTemp + dx, 'p');	
		}
	}
	
	private int[] randomCoordinates(){
		int[] a = new int[] { (int) (this.charMap.size()*Math.random()), (int) (this.charMap.get(0).size()*Math.random())};
		return a;
	}
	
	private boolean availableSpot(int[] rC){
		int[][] i = new int[4][];
		i[0] = new int[] {1,0};
		i[1] = new int[] {0,1};
		i[2] = new int[] {-1,0};
		i[3] = new int[] {0,-1};
		int count = 0;
		for (int j = 0; j < 4; j++){
			if (rC[0] + i[j][0] >= 0 &&
				rC[1] + i[j][1] >= 0 &&
				rC[0] + i[j][0] < this.charMap.size() &&
				rC[1] + i[j][1] < this.charMap.get(0).size()) {
				if (this.charMap.get(rC[0] + i[j][0]).get(rC[1] + i[j][1]) == 'g' &&
					this.charMap.get(rC[0]).get(rC[1]) == 'g' ){
					count++;
				}
			}
		}
		return (count == 4);
	}
	
	private boolean outsideOfMap(Coordinate rC){
		if (rC.coord[0] < 0 ||	rC.coord[1] < 0 ||
				rC.coord[0] > this.charMap.size() ||
				rC.coord[1] > this.charMap.get(0).size()) {
				return false;
			} else {
				return true;
			}
	}
	
	private boolean availableRiverSpot(Coordinate rC){
		 if ((rC.coord[0] > 0) && (rC.coord[1] > 0) &&
				 (this.charMap.size() > rC.coord[0]) &&
				 (this.charMap.get(rC.coord[1]).size() > rC.coord[1]) &&
				 (this.charMap.get(rC.coord[0]).get(rC.coord[1]) == 'g')) {
			return true;
		} else {
			return false;
		}
	}
	
	public void createRiver(){
		int[] riverStart = randomCoordinates(); //Startpunkt
		int[] riverEnd = randomCoordinates(); //Endepunkt
		if (riverStart[0] == riverEnd[0] &&
				riverStart[1] == riverEnd[1]){
			this.createRiver(); //Om startpunkt = endepunkt, prøv igjen.
		} else {
			this.charMap.get(riverStart[0]).set(riverStart[1], 'v'); //Tegn start og endepunkt som vann
			this.charMap.get(riverEnd[0]).set(riverEnd[1], 'v');
			Coordinate riverS = new Coordinate(riverStart); //Lag koordinat-objekter med start og slutt.
			Coordinate riverE = new Coordinate(riverEnd);
			stretchRiver(riverS, riverE);
		}
	}
	
	private void stretchRiver(Coordinate a, Coordinate b){
		ArrayList<Coordinate> Path = new ArrayList<Coordinate>();
		Path.add(b);
		boolean incomplete = true;
		while (incomplete){
			for (int i = 0; i < Path.size(); i++){ //Bredde-først søk algoritme
				System.out.printf("\nStart: \t%d,%d\nEnd: \t%d,%d", a.coord[0],a.coord[1],b.coord[0],b.coord[1]);
				System.out.printf("\ni: %d, size: %d", i, Path.size());
				boolean[] sjekk = new boolean[4];
				for (int j = 0; j < sjekk.length; j++){
					sjekk[j] = true;
				}
				Coordinate m = new Coordinate(Path.get(i).coord[0] - 1, Path.get(i).coord[1], Path.get(i).coord[2] + 1); //Lager koordinater 
				Coordinate n = new Coordinate(Path.get(i).coord[0] + 1, Path.get(i).coord[1], Path.get(i).coord[2] + 1); // for de fire 
				Coordinate o = new Coordinate(Path.get(i).coord[0], Path.get(i).coord[1] - 1, Path.get(i).coord[2] + 1); //nærmeste naboene.
				Coordinate p = new Coordinate(Path.get(i).coord[0], Path.get(i).coord[1] + 1, Path.get(i).coord[2] + 1);
				Coordinate[] naboer = new Coordinate[] {m,n,o,p}; 
				for (int j = 0; j < sjekk.length; j++){
					for (int x = 0; x < Path.size(); x++){
						if (this.outsideOfMap(naboer[j]) || //Her sjekker vi om punktet eksister på kartet.
							Path.get(x).compareYX(naboer[j])){ //Her sjekker vi om punktet eksisterer i Path allerede.
							sjekk[j] = false; //Setter en boolean-verdi til false som vi sjekker senere for å se om koordinatet skal legges i Path.
							break; 
						} 
					}
				}
				for (int x = 0; x < naboer.length; x++){
					if (sjekk[x] && this.availableRiverSpot(naboer[x])){ //Her sjekker vi om vi kan legge koordinatet i Path, og gjør det om det blir godkjent.
						Path.add(naboer[x]);
					}
				}
			} 
			for (int x = 0; x < Path.size(); x++){
				if (Path.get(x).compareYX(a)){ //Sjekker om vi har truffet mål.
					System.out.println("ferdig!!");
					incomplete = false;
					break;
				}
			}
		} //Når While-løkka er ferdig skal Path inneholde koordinatene som lager en sti, blant mange andre koordinater.
		ArrayList<Coordinate> finalPath = new ArrayList<Coordinate>(); //Ny ArrayList som skal kun inneholde riktig sti.
		int numberOfSteps = Path.get(Path.size() - 1).coord[2];
		finalPath.add(new Coordinate(a.coord[0], a.coord[1], numberOfSteps)); //Den ene enden av elven.
		System.out.println("Path.size(): " + Path.size() + "\nAntall steg: " + numberOfSteps);
		for (int i = numberOfSteps; i >= 0; i--){
			for (int j = 1; j < Path.size() + 1; j++){
				if (Path.get(j).coord[2] == i && 
					Path.get(j).distance(finalPath.get(numberOfSteps - i)) == 1){
					finalPath.add(Path.get(j)); //Hvis koordinatet som vurderes er riktig nummer i rekka (antall skritt - nåværende skritt som vurderes),
				}// og avstanden mellom forrige sikre skritt og skrittet som vurderes er lik 1, så godkjennes den og blir det nye sikre skrittet.
			}
		}
		for (int i = 0; i < finalPath.size(); i++){
			this.charMap.get(finalPath.get(i).coord[0]).set(finalPath.get(i).coord[1], 'v');
		} //Printer elven
		int bridgeCoord = (int) ((int) finalPath.size()*Math.random());
		this.charMap.get(finalPath.get(bridgeCoord).coord[0]).set(finalPath.get(bridgeCoord).coord[1], 'v');
	}//Lager en bro på måfå så ikke elven lukker av deler av kartet. Broen kan i verste fall være blokkert av noe annet.
	
	private void randomObject(){
		double random = Math.random();
		if(random < 0.08){
			this.createRiver();		
		} else if (random < 0.3){
			createMarket();
		} else if (random < 0.6){
			createVillage();
		} else {
			createObstruction();
		}
	}
	
	public void createVillage(){
		int[] randomCoordinate = randomCoordinates();
		if (this.availableSpot(randomCoordinate)){
			this.charMap.get(randomCoordinate[0]).set(randomCoordinate[1], 'l');
		} else {
			this.createMarket();
		}
	}
	
	public void createObstruction(){
		int[] randomCoordinate = randomCoordinates();
		double random = Math.random();
		if (this.availableSpot(randomCoordinate)){
			if (random < 0.5){
				this.charMap.get(randomCoordinate[0]).set(randomCoordinate[1], 's');
			} else {
				this.charMap.get(randomCoordinate[0]).set(randomCoordinate[1], 't');
			}
		} else {
			this.createObstruction();
		}
	}
	
	public void createMarket(){
		int[] randomCoordinate = randomCoordinates();
		if (this.availableSpot(randomCoordinate)){
			this.charMap.get(randomCoordinate[0]).set(randomCoordinate[1], 'm');
		} else {
			this.createMarket();
		}
	}
	
	private int spaceAvailable(){
		int a = 0;
		for (int i = 0; i < this.charMap.size(); i++){
			for (int j = 0; j < this.charMap.get(0).size(); j++){
				if (this.charMap.get(i).get(j) == 'g'){
					a += 1;
				}
			}
		}
		return a;
	}
	
	public void generateMap(){
		int spaceToBeOccupied = (int) (this.charMap.size()*this.charMap.get(0).size()*0.4 - 1);
		int totalSpace = (int) this.charMap.size()*this.charMap.get(0).size();
		while(this.spaceAvailable() > (totalSpace - spaceToBeOccupied)){
			System.out.println(this.spaceAvailable());
			this.randomObject();
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