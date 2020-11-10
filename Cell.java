package nguyen.cs146project3;

import java.util.HashMap;
/**
 * 
 * @author martinnguyen
 * each cell will contain a hashmap of walls which will be represented by integers
 * the walls will serve as keys, which contain boolean values indicating whether or not the wall is broken
 * all cells will be initialized with intact walls on all 4 sides
 *  0 = top wall, 1  = left wall, 2 = bottom wall, 3 = right wall
 */
public class Cell extends HashMap<Integer,Boolean> {
	private int rowPosition;
	private int columnPosition;
	private boolean visited;
	
	public Cell(int rowPosition, int columnPosition) {
		this.rowPosition = rowPosition;
		this.columnPosition = columnPosition;
		visited = false;
		// initialize all walls to be intact
		// true (value) = intact
		// false = destroyed
		this.put(0, true); // top wall
		this.put(1, true); // left wall
		this.put(2, true); // bottom wall
		this.put(3, true); // right wall
	}
	
	public int getRow() {
		return this.rowPosition;
	}
	public int getColumn() {
		return this.columnPosition;
	}
	
	public boolean isVisited() {
		return this.visited;
	}

}
