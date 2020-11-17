package nguyen.cs146project3;


import java.util.HashMap;
/**
 * 
 * @author martinnguyen
 * each cell will contain a hashmap of walls which will be represented by Strings
 * the walls will serve as keys, which contain boolean values indicating whether or not the wall is broken
 * all cells will be initialized with intact walls on all 4 sides
 */
public class Cell extends HashMap<String,Boolean> {
	private int rowPosition;
	private int columnPosition;
	private boolean visited;
	
	public Cell(int rowPosition, int columnPosition) {
		this.rowPosition = rowPosition;
		this.columnPosition = columnPosition;
		// initialize all walls to be intact
		// true (value) = intact
		// false = destroyed
		this.put("North", true); // top wall
		this.put("West", true); // left wall
		this.put("South", true); // bottom wall
		this.put("East", true); // right wall
		if (allWallsIntact()) {
			visited = false;
		} else {
			visited = true;
		}
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
	
	public boolean deepEquals(Object x) {
		Cell that = (Cell) x;
		if (this.rowPosition == that.rowPosition && this.columnPosition == that.columnPosition) {
			if (this.get("North") == that.get("North") && this.get("South") == that.get("South")) {
				if (this.get("West") == that.get("West") && this.get("East") == that.get("East")) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean equals(Object x) {
		Cell that = (Cell) x;
		return this.rowPosition == that.rowPosition && this.columnPosition == that.columnPosition;
	}
	public int hashCode() {
		return this.hashCode();
	}
	// checks if all walls are intact
	public boolean allWallsIntact() {
		return this.get("North") && this.get("South") && this.get("West") && this.get("East");
	}
	
	// implements comparable
	public int compareTo(Cell compareCell) {
	        int compareage= compareCell.getRow();
	        return this.getRow()-compareage;
	 }
}
