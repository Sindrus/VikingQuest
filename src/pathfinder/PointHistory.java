package pathfinder;

public class PointHistory extends Point {
	private PointHistory prevPoint;
	private int pth; //path to here
	private int pfh; //path from here

	public PointHistory(){}
	public PointHistory (Point xy, PointHistory prevPoint, Point finalPoint) {
		super(xy);
		this.prevPoint = prevPoint;
		this.pth = (prevPoint == null)? 0: prevPoint.getPth();
		this.pfh = Math.abs(xy.getX() - xy.getX()) + Math.abs(xy.getY() - finalPoint.getY());
	}
	
	public PointHistory getPrevPoint() {
		return prevPoint;
	}

	public void setPrevPoint(PointHistory prevPoint) {
		this.prevPoint = prevPoint;
	}

	public int getPth() {
		return pth;
	}
	
	public int getDist() {
		return pth + pfh;
	}
	
}