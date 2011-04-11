package v1;

public class Coordinate {
Integer[] coord = new Integer[3];
	
	public Coordinate(int[] a){
		this((Integer) a[0],(Integer) a[1]);
		this.coord[2] = 0;
	}
	
	public static Coordinate plus(Coordinate a, Coordinate b){
		Coordinate c = new Coordinate(0,0);
		c.coord[0] = b.coord[0] + a.coord[0];
		c.coord[1] = b.coord[1] + a.coord[1];
		return c;
	}
	
	public Coordinate(char c){
		this(0,0);
		if (c == 'w'){
			this.coord[0] = - 1;
		} else if (c == 'a'){
			this.coord[1] = - 1;
		} else if (c == 's'){
			this.coord[0] = 1;
		} else if (c == 'd') {
			this.coord[1] = 1;
		}
	}
	
	public Coordinate(Coordinate a){
		this.coord[0] = a.coord[0];
		this.coord[1] = a.coord[1];
		this.coord[2] = a.coord[2];
	}
	
	public Coordinate(int y, int x){
		this.coord[0] = (Integer) y;
		this.coord[1] = (Integer) x;
		this.coord[2] = 0;
	}
	
	public Coordinate(int y, int x, int z){
		this((Integer) y,(Integer) x);
		this.coord[2] = (Integer) z;
	}
	
	public double distance(Coordinate a){
		return Math.sqrt((Math.pow((a.coord[0] - this.coord[0]), 2)) + (Math.pow((a.coord[1] - this.coord[1]), 2)));
	}
	
	public boolean compare2(Coordinate a){
		if (this.coord[2] == a.coord[2]){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean compareYX(Coordinate a){
		if (this.coord[0].equals(a.coord[0]) &&
			this.coord[1].equals(a.coord[1])){
			return true;
		} else {
			return false;
		}
	}
	
}
