package nguyen.cs146project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Generator {
	private Stack<Cell> cellStack;
	private int size;

	public Generator(int size) {
		this.size = size;
		cellStack = new Stack<Cell>();
	}

	public void cellGenerator() {
		int totalCells = size * size;
		int x = 0, y = 0;
		Cell currentCell = new Cell(x, y);
		int visitedCells = 1;

		while (visitedCells < totalCells) {
			
			ArrayList<Integer> neighbors = findNeighbors(currentCell);
			
			if (neighbors.size() >= 1) {
				
				int key = getRandomFromList(neighbors);	//pick a random wall to break out of breakable neighboring walls
				currentCell.put(key, false);			// break the wall
				cellStack.push(currentCell);			// push the current cell onto the stack
				
				if (key == 0) {							// breaking through top wall
					currentCell = new Cell(--x,y);		// new cell will have decremented row
					currentCell.put(2, false);			// new cell will have a broken wall to the bottom
				}	
				else if (key == 1) {					// breaking through left wall
					currentCell = new Cell(x,--y);		// new cell will have decremented column
					currentCell.put(3, false);			// new cell will have a broken wall to its right 
				}	
				else if (key == 2) {					// breaking through bottom wall
					currentCell = new Cell(++x,y);		// new cell will have an incremented row
					currentCell.put(0, false);			// new cell will have a broken wall to the top
				}
				else if (key == 3) { 					// breaking through right wall
					currentCell = new Cell(x,++y);		// new cell will have incremented column
					currentCell.put(1, false);			// new cell will have a broken wall to the left 
				}
				
				visitedCells++;
				
			} else {
				currentCell = cellStack.pop();
			}
		}
	}

	/**
	 * @param cell the cell in which we find neighbors for
	 * @return a list of neighboring walls that can be destroyed
	 */
	private ArrayList<Integer> findNeighbors(Cell cell) {
		ArrayList<Integer> walls = new ArrayList<Integer>();
		// 0 = top, 1 = left, 2 = bottom, 3 = right
		if (cell.get(0)) { // top wall is intact
			if (cell.getRow() != 0) { // not on the top row
				walls.add(0); // top wall can be destroyed
			}
		}
		if (cell.get(1)) { // left wall is intact
			if (cell.getColumn() != 0) {// not in the leftmost column
				walls.add(1); // left wall can be destroyed
			}
		}
		if (cell.get(2)) { // bottom wall is intact
			if (cell.getRow() != size - 1) { // not in the bottom row
				walls.add(2); // bottom wall can be destroyed
			}
		}
		if (cell.get(3)) { // right wall is intact
			if (cell.getColumn() != size - 1) { // not at the rightmost column
				walls.add(3); // right wall can be destroyed
			}
		}
		return walls;
	}
	
	public int getRandomFromList(ArrayList<Integer> list) { 
        Random gen = new Random(); 
        return list.get(gen.nextInt(list.size())); 
    } 
}
