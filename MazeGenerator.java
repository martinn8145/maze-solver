package nguyen.cs146project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {

	private int size;
	private ArrayList<Cell> cellList; // use cellList to keep track of every cell and its hashmap
	private Random gen;	//used with seed (set in constructor) to pick random neighbor

	// constructor to create a maze of cells with size x size dimensions
	public MazeGenerator(int size) {
		this.size = size;
		cellList = new ArrayList<Cell>();
		gen = new Random();
		gen.setSeed(100);
	}

	public int getSize() {
		return size;
	}

	public ArrayList<Cell> getCellList() {
		return cellList;
	}

	public void cellGenerator() {
		Stack<Cell> cellStack = new Stack<Cell>(); // use cell stack to backtrack

		int totalCells = size * size; // total cells will be size^2
		int row = 0, col = 0;
		Cell currentCell = new Cell(row, col); // start from 0,0 cell

		cellList.add(currentCell);
		int visitedCells = 1;
		while (visitedCells < totalCells) {
			ArrayList<String> neighbors = findNeighbors(currentCell);

			if (neighbors.size() >= 1) {

				String key = getRandomFromList(neighbors); // pick a random wall to break out of breakable neighboring
															// walls
				currentCell.put(key, false); // break the wall
				cellStack.push(currentCell); // push the current cell onto the stack

				if (key.equals("North")) { // breaking through top wall\
					row--;
					currentCell = new Cell(row, col); // new cell will have decremented row
					currentCell.put("South", false); // new cell will have a broken wall to the bottom

				} else if (key.equals("West")) { // breaking through left wall
					col--;
					currentCell = new Cell(row, col); // new cell will have decremented column
					currentCell.put("East", false); // new cell will have a broken wall to its right

				} else if (key.equals("South")) { // breaking through bottom wall
					row++;
					currentCell = new Cell(row, col); // new cell will have an incremented row
					currentCell.put("North", false); // new cell will have a broken wall to the top

				} else if (key.equals("East")) { // breaking through right wall
					col++;
					currentCell = new Cell(row, col); // new cell will have incremented column
					currentCell.put("West", false); // new cell will have a broken wall to the left

				}
				cellList.add(currentCell); // add the cell to cellList after processing
				visitedCells++;

			} else { // the cell has no unvisited neighbors

				Cell previousCell = cellStack.pop();
				// since previous cell will still be = new Cell(row,col)
				// revert the changes to row and column when backtracking
				int colDiff = currentCell.getColumn() - previousCell.getColumn();
				int rowDiff = currentCell.getRow() - previousCell.getRow();

				if (rowDiff > 0) {
					row--;
				} else if (rowDiff < 0) {
					row++;
				}
				if (colDiff > 0) {
					col--;
				} else if (colDiff < 0) {
					col++;
				}
				// go back to the previous cell
				currentCell = previousCell;

			}
		}
	}

	/**
	 * @param cell the cell in which we find neighbors for
	 * @return a list of neighboring walls that can be destroyed
	 */
	private ArrayList<String> findNeighbors(Cell cell) {

		int cellRow = cell.getRow();
		int cellCol = cell.getColumn();

		// find all the neighboring cells
		ArrayList<String> walls = new ArrayList<String>();
		Cell northNeighbor = new Cell(cellRow - 1, cellCol);
		Cell westNeighbor = new Cell(cellRow, cellCol - 1);
		Cell southNeighbor = new Cell(cellRow + 1, cellCol);
		Cell eastNeighbor = new Cell(cellRow, cellCol + 1);

		// check if the neighboring cells exist in cellList (which contains all explored
		// cells so far)
		for (int i = 0; i < cellList.size(); i++) {
			if (cellList.get(i).equals(northNeighbor)) {
				northNeighbor = cellList.get(i);
			} else if (cellList.get(i).equals(westNeighbor)) {
				westNeighbor = cellList.get(i);
			} else if (cellList.get(i).equals(southNeighbor)) {
				southNeighbor = cellList.get(i);
			} else if (cellList.get(i).equals(eastNeighbor)) {
				eastNeighbor = cellList.get(i);
			}
		}

		if (cell.get("North")) { // top wall is intact
			if (cellRow != 0) { // not on the top row
				if (northNeighbor.allWallsIntact()) {
					walls.add("North"); // top wall can be destroyed
				}

			}
		}
		if (cell.get("West")) { // left wall is intact
			if (cellCol != 0) { // not in the leftmost column
				if (westNeighbor.allWallsIntact()) {
					walls.add("West"); // left wall can be destroyed
				}
			}
		}
		if (cell.get("South")) { // bottom wall is intact
			if (cellRow != size - 1) { // not in the bottom row
				if (southNeighbor.allWallsIntact()) {
					walls.add("South"); // bottom wall can be destroyed
				}
			}
		}
		if (cell.get("East")) { // right wall is intact
			if (cellCol != size - 1) { // not at the rightmost column
				if (eastNeighbor.allWallsIntact()) {
					walls.add("East"); // right wall can be destroyed
				}
			}
		}
		return walls;
	}

	private String getRandomFromList(ArrayList<String> list) {
		return list.get(gen.nextInt(list.size()));
	}
}
