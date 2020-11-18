package nguyen.cs146project3;

import java.util.HashMap;

/**
 * 
 * @author martinnguyen each cell will contain a hashmap of walls which will be
 *         represented by Strings the walls will serve as keys, which contain
 *         boolean values indicating whether or not the wall is broken all cells
 *         will be initialized with intact walls on all 4 sides
 */
public class Cell extends HashMap<String, Boolean> implements Comparable<Cell> {

	private int rowPosition;
	private int columnPosition;

	Cell parentCell; // for BFS, have each cell have a parentCell unless its the first cell; useful
						// for backtracking

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
	}

	public int getRow() {
		return this.rowPosition;
	}

	public int getColumn() {
		return this.columnPosition;
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

	// use compareTo to order arraylist in graph class
	public int compareTo(Cell compareCell) {
		int compareRow = compareCell.getRow();
		int compareCol = compareCell.getColumn();
		int thisRow = this.getRow();
		int thisCol = this.getColumn();
		int rowDiff = Integer.compare(thisRow, compareRow);
		if (rowDiff == 0) {
			return Integer.compare(thisCol, compareCol);
		}
		return rowDiff;
	}
}
