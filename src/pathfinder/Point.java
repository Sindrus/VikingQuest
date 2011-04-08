package pathfinder;

public class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point(Point xy) {
		this.x = xy.getX();
		this.y = xy.getY();
	}
	
	public Point() {
		this(0,0);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public static int MDistance(Point first, Point second) {
		return (
				Math.abs(first.getX() - second.getX()) + 
				Math.abs(first.getY() - second.getY()));
	}
	
	public static Point Sum(Point first, Point second) {
		return new Point(first.getX()+second.getX(), first.getY() + second.getY());
	}

	public boolean WithinBox(int left, int top, int right, int bottom) {
		return (this.getX() >= left && 
				this.getY() >= top &&
				this.getX() <= right &&
				this.getY() <= bottom);
	}
	
	public void Modify(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}
	
	public static boolean equals(Point p1, Point p2) {
		return (p1.getX() == p2.getX() && p1.getY() == p2.getY());
	}
}
