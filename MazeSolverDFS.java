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
		int visitedCells = 0;
		String solvedMaze = maze;
		
		visited = new boolean[len][len];
		Stack<Cell> cellStack = new Stack<Cell>();
		Stack<Cell> path = new Stack<Cell>();
		Stack<Cell> forks = new Stack<Cell>();
		
		cellStack.push(startingCell);
		visited[startingCell.getRow()][startingCell.getColumn()] = true;
		
		while (!cellStack.isEmpty()) {
			Cell currentCell = cellStack.pop();
			int row = currentCell.getRow(), col = currentCell.getColumn();
			solvedMaze = mazeEditor(solvedMaze, row, col, counter++);
			path.push(currentCell);
			visitedCells++;
			//end of the maze means break
			if (row == len - 1 && col == len - 1) {
				break;
			}
			//edit the maze to show the current step
			if (counter == 10) counter = 0; // only use single digit numbers
			LinkedList<Cell> neighborList = graph.getList(row, col); 	//get the entire adjacency list for a cell
						
			if (neighborList.size()  == 4) {
				forks.push(currentCell);
			} 
			
			if (neighborList.size() == 2) {
				if (forks.size() != 0) {
					Cell lastFork = forks.pop();
					while (path.peek() != lastFork) {
						path.pop();
					}
				}
			}
			
			for (Cell neighbor: neighborList) {		//iterate through to find unvisited cells
				if (!visited[neighbor.getRow()][neighbor.getColumn()])  {
					cellStack.push(neighbor);		//push the cells onto the stack and mark them as visited
					visited[neighbor.getRow()][neighbor.getColumn()] = true;
				} 
			}
		}
		String shortestPath = pathToString(path) + "\n";
		String shortestPathMaze = shortestPath(maze, path) + "\n";
		return solvedMaze + "\n" + shortestPathMaze + shortestPath + "Visited Cells: " + visitedCells;
	}
	public static void main (String[] args) {
		MazeGenerator jeff = new MazeGenerator(6);
		jeff.cellGenerator();
		MazePrinter mp = new MazePrinter();
		Cell[][] cellArray = mp.listTo2DArray(jeff.getCellList());
		Graph graph = new Graph(jeff.getCellList());
		String maze = mp.printMaze(cellArray);
		MazeSolverDFS ms = new MazeSolverDFS();
		Cell startingCell = cellArray[0][0];
		String solvedMaze = ms.mazeSolver(graph, maze, startingCell);
		System.out.println(maze);
		System.out.println(solvedMaze);
		
	}
}
