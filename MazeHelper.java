package nguyen.cs146project3;

import java.util.ArrayList;

public class MazeHelper {
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
		String newMaze = maze.substring(0, cellIndex) + number + maze.substring(cellIndex + 1);
		
		return newMaze;
	}
}
