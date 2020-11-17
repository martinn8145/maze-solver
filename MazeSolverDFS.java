package nguyen.cs146project3;

import java.util.LinkedList;
import java.util.Stack;

public class MazeSolverDFS extends MazeHelper {
	private boolean[][] visited; //boolean array to check if the cell's been visited
	/**
	 * using an adjacency list representation of a graph, edit the maze to show 
	 * DFS approach to solving the maze
	 * @param graph graph of all of the cells
	 * @param maze the unsolved maze as a string
	 * @param startingCell the cell we start from (0,0)
	 * @return the path DFS algorithm takes to solve the maze
	 */
	public String mazeSolver(Graph graph, String maze, Cell startingCell) {
		
		graph.addEdge();
		LinkedList<Cell>[] adjacencyList = graph.getArrayOfLinked();
		int len = (int) Math.sqrt(adjacencyList.length);
		int counter = 0;// the number being printed in the maze 
		
		visited = new boolean[len][len];
		Stack<Cell> cellStack = new Stack<Cell>();
		
		cellStack.push(startingCell);
		visited[startingCell.getRow()][startingCell.getColumn()] = true;
		
		while (!cellStack.isEmpty()) {
			Cell currentCell = cellStack.pop();
			int row = currentCell.getRow(), col = currentCell.getColumn();
			maze = mazeEditor(maze, row, col, counter++);
			//end of the maze means break
			if (row == len - 1 && col == len - 1) {
				break;
			}
			//edit the maze to show the current step
			if (counter ==10) counter = 0; // only use single digit numbers
			LinkedList<Cell> neighborList = graph.getList(row, col); 	//get the entire adjacency list for a cell
			
			for (Cell neighbor: neighborList) {		//iterate through to find unvisited cells
				if (!visited[neighbor.getRow()][neighbor.getColumn()])  {
					cellStack.push(neighbor);		//push the cells onto the stack and mark them as visited
					visited[neighbor.getRow()][neighbor.getColumn()] = true;
				}
			}
		}
		return maze;
	}

	public static void main (String[] args) {
		MazeGenerator jeff = new MazeGenerator(4);
		jeff.cellGenerator();
		MazePrinter mp = new MazePrinter();
		Cell[][] cellArray = mp.listTo2DArray(jeff.getCellList());
		String maze = mp.printMaze(cellArray);
		Graph graph = new Graph(jeff.getCellList());
		//System.out.println(maze);
		MazeSolverDFS ms = new MazeSolverDFS();
		Cell startingCell = cellArray[0][0];
		System.out.print(ms.mazeSolver(graph, maze, startingCell));
		//maze = ms.mazeEditor(maze, 0, 0, 0);
		//System.out.println(maze);
		//System.out.println(ms.mazeEditor(maze, 5, 5, 1));
		
	}
}
