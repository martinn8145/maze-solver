package nguyen.cs146project3;

import java.util.ArrayList;
import java.util.Stack;
/**
 * holds a multitude of helper functions for other classes to use
 */
public class MazeHelper {
	
	// converts arrayList of cells to a 2d array for convenience
	public Cell[][] listTo2DArray(ArrayList<Cell> cellList) {
		int dimension = (int) Math.sqrt(cellList.size());
		Cell[][] cellArray = new Cell[dimension][dimension];
		for (int i = 0; i < cellList.size(); i++) {
			Cell currentCell = cellList.get(i);
			int row = currentCell.getRow();
			int col = currentCell.getColumn();
			cellArray[row][col] = currentCell;
		}
		return cellArray;
	}
	
	//edits the maze path of the solver
	public String mazeEditor(String maze, int row, int column, int number) {
		// find the distance to the new line character and add 1 to get to the start of a row
		int line = maze.indexOf("\n") + 1;
		// to get to the specified row
		int rowIndex = line + (line * 2 * row);
		// to get to the specified column
		int colIndex =  1 + (column*2);
		// combine to get the index of the cell
		int cellIndex = rowIndex + colIndex;
		// keep the maze the same until the cell, add the number, then add the rest of the maze
		maze = maze.substring(0, cellIndex) + number + maze.substring(cellIndex + 1);
		
		return maze;
	}
	
	// similar to above method, edit the maze to add # on the path from start to finish
	public String pathEditor(String maze, Stack<Cell> shortestPath) {
		int line = maze.indexOf("\n") + 1;
		while (!shortestPath.isEmpty()) {
			Cell currentCell = shortestPath.pop();
			int rowIndex = line + (line * 2 * currentCell.getRow());
			int colIndex = 1 + (currentCell.getColumn() * 2);
			int cellIndex = rowIndex + colIndex;
			maze = maze.substring(0, cellIndex) + "#" + maze.substring(cellIndex+1);
		}
		return maze;
	}
	// converts an arrayList into a stack for convenience
	public Stack<Cell> listToStack(ArrayList<Cell> cellList) {
		Stack<Cell> returnStack = new Stack<Cell>();
		for (Cell cell: cellList) {
			returnStack.push(cell);
		}
		return returnStack;
	}
	// returns a string of the maze with shortest path and the path the algorithm took
	public String mazeShortestPath(String maze, Stack<Cell> path) {
		
		String shortestPath = pathToString(path);
		String shortestPathMaze = pathEditor(maze, path);
		return shortestPathMaze + "\n" + shortestPath  +  "\n";
		
	}
	
	// returns a string of the path as the following: Path: (x1, y2) (x2, y2)...
	public String pathToString(Stack<Cell> path) {
		String pathString = "Path: ";
		for (Cell cell: path) {
			pathString += "(" + cell.getRow() + ", " + cell.getColumn() + ") ";
		}
		return pathString;
	}

}
