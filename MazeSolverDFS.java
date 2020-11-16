package nguyen.cs146project3;

import java.util.LinkedList;
import java.util.Stack;

public class MazeSolverDFS {
	
	public String mazeSolver(LinkedList<Cell>[] adjacencyList, String maze, Cell startingCell) {
		int counter = 0;
		Stack<Cell> cellStack = new Stack<Cell>();
		int arrayIndex = 0, listIndex = 0;
		
		return maze;
	}
	
	//edits the maze to show the path of the DFS solver 
	public String mazeEditor(String maze, int row, int column, int number) {
		// find the distance to the new line character and add 1 to get to the start of a row
		int line = maze.indexOf("\n") + 1;
		// to get to the specified row
		int rowIndex = line + (line * 2 * row);
		// to get to the specified column
		int colIndex =  1 + (column*2);
		// combine to get the index of the cell
		int cellIndex = rowIndex + colIndex;
		// keep the maze the same until the cell
		String newMaze = maze.substring(0, cellIndex);
		// add the number
		newMaze += number;
		// add the rest of the maze 
		newMaze += maze.substring(cellIndex + 1);
		return newMaze;
	}
}
