package pathfinder;

import java.util.Stack;


/**
 * 
 * @author Magne
 * Mulighet for å returnere spesifikke steg, eller bare om det går
 */



public class AStar {
	private static final char[] IsBlock = {'#', '$', '*'};
	private static final int IsBlockLen = 3;
	private static int lastDistance = 0;
	
	static boolean Reachable(char[][] grid, int gridWidth, int gridHeight, Point start, Point end) {
		return (null != Path(grid, gridWidth, gridHeight, start, end));
	}
	static Stack<Point> Path(char[][] grid, int gridWidth, int gridHeight, Point start, Point end) {
		
		int x, y;
		
		Stack<Point> returnStack = new Stack<Point>();
		
		boolean foundPath = false;
		
		PointHistory newPoint = new PointHistory();
		
		Stack<PointHistory> openList = new Stack<PointHistory>();
		Stack<PointHistory> closedList = new Stack<PointHistory>();
		
		//Same start and end
		if (start.getX() == end.getX() && start.getY() == end.getY()) {
			returnStack.push(new Point(start.getX(), start.getY()));
			return returnStack;
		}
		
		openList.push(new PointHistory(start, null, end));
		
		//Main loop
		while(openList.size() > 0) {
			lowestSortToTop(openList);
			closedList.push(openList.pop());
			
			for (x = closedList.peek().getX() - 1; x <= closedList.peek().getX() + 1; x++) {
				for (y = closedList.peek().getY() - 1; y <= closedList.peek().getY() + 1; y++) {
					if (Math.abs(x-closedList.peek().getX()) + Math.abs(y-closedList.peek().getY()) == 2) continue;
					if (x < 0 || y < 0 || x == gridWidth || y == gridHeight) continue;
					if (FoundInBlockList(x, y, grid)) continue;
					
					newPoint = new PointHistory(new Point(x,y), closedList.peek(), end);
					
					if (InListReplace(newPoint, closedList)) continue;
					
					openList.push(newPoint);
					
					//Målsjekk
					if (newPoint.getX() == end.getX() && newPoint.getY() == end.getY()) {
						foundPath = true;
						break;
					}
				}
				if (foundPath == true) break;
			}
			if (foundPath == true) break;
		}
		
		if (foundPath == false)return null;
		
		//Path found		
		/*returnStack.push(new Point(openList.peek().getX(), openList.peek().getY()));
		newPoint = openList.peek().getPrevPoint();
		
		while(newPoint.getPrevPoint() != null) {
			returnStack.push(new Point(newPoint.getX(), newPoint.getY()));
			newPoint = newPoint.getPrevPoint();
		}
		*/
		while(newPoint.getPrevPoint() != null) {
			returnStack.push(new Point(newPoint.getX(), newPoint.getY()));
			newPoint = newPoint.getPrevPoint();
		}
		
		lastDistance = returnStack.size();
		return returnStack;
	}
	
	/**
	 * Searches list for an entry with the same position as point, if it finds it
	 * it will check if it's a shorter distance, and if it is replace it.
	 * Returns true if it found something with the same position.
	 */
	static boolean InListReplace(PointHistory point, Stack<PointHistory> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getX() == point.getX() && 
				list.get(i).getY() == point.getY()) {
				
				if (list.get(i).getDist() > point.getDist())
					list.set(i, point);
				
				return true;
			}
		}
		return false;
	}
	
	static void lowestSortToTop(Stack<PointHistory> list) {
		int lowest = Integer.MAX_VALUE;
		int lowestID = 0;
		
		PointHistory temp1;
		PointHistory temp2;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDist() < lowest) {
				lowest = list.get(i).getDist();
				lowestID = i;
			}
		}
		
		temp1 = list.get(lowestID);
		temp2 = list.get(list.size()-1);
		list.set(list.size()-1, temp1);
		list.set(lowestID, temp2);
	}
	
	static boolean FoundInBlockList(int x, int y, char grid[][]) {
		for (int i = 0; i < IsBlockLen; i++)
			if (grid[x][y] == IsBlock[i])
				return true;
		
		return false;
	}
	
	static int getLastDistance() {
		return lastDistance;
	}
	
}