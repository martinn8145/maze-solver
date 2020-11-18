package nguyen.cs146project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//uses BFS approach to solve the maze, finds the shortest path and the number of visited cells
public class MazeSolverBFS extends MazeHelper {
	private boolean[][] visited; // boolean array to check if cell at visited[row][column] has been visited
	private Stack<Cell> path; // keeps track of the path of the solver; will be returned as the shortest
								// possible path
	private int visitedCells; // keeps track of total amount of visited cells in the search

	// constructor to initialize instance variables
	public MazeSolverBFS() {
		visitedCells = 0;
		path = new Stack<Cell>();
	}

	/**
	 * using an adjacency list representation of a graph, edit the maze to show BFS
	 * approach to solving the maze
	 * 
	 * @param graph        graph of all of the cells
	 * @param maze         the unsolved maze as a string
	 * @param startingCell the cell we start from (0,0)
	 * @return the path BFS algorithm takes to solve the maze
	 */
	public String mazeBFS(Graph graph, String maze, Cell startingCell) {
		// add edges to graph and get the adjacencyList
		graph.addEdge();
		LinkedList<Cell>[] adjacencyList = graph.getArrayOfLinked();

		// len is the length of each row/column; adjacencyList is row^2 or col^2
		int len = (int) Math.sqrt(adjacencyList.length);
		int counter = 0;// the number being printed in the maze

		String solvedMaze = maze; // the maze string we will be editing as we solve
		visited = new boolean[len][len]; // each traversed cell will have a boolean value depending on if its been
											// visited before

		Queue<Cell> cellQueue = new LinkedList<Cell>(); // use a stack to implement DFS

		// start with the starting cell
		cellQueue.add(startingCell);
		visited[startingCell.getRow()][startingCell.getColumn()] = true;

		while (!cellQueue.isEmpty()) { // until every cell has been traversed; this while loop will usually never be
										// false before we finish
			Cell currentCell = cellQueue.poll(); // get head of queue
			int row = currentCell.getRow(), col = currentCell.getColumn();
			solvedMaze = mazeEditor(solvedMaze, row, col, counter++); // edit the maze to display where we're at in the
																		// maze

			visitedCells++;

			// checks if we're at the end of the maze; break out of the loop
			if (row == len - 1 && col == len - 1) {
				break;
			}
			// edit the maze to show the current step
			if (counter == 10)
				counter = 0; // only use single digit numbers
			LinkedList<Cell> childList = graph.getList(row, col); // get the entire adjacency list for a cell

			for (Cell child : childList) { // iterate through to find unvisited cells
				if (!visited[child.getRow()][child.getColumn()]) {
					cellQueue.add(child); // push the cells onto the stack and mark them as visited
					visited[child.getRow()][child.getColumn()] = true;
					child.parentCell = currentCell; // make each child point to a parent
				}

			}
		}

		return solvedMaze + "\n";
	}

	// make child point to parent; get backwards solution to maze
	public Stack<Cell> getShortestPath(Cell lastCell) {
		ArrayList<Cell> cellList = new ArrayList<Cell>();
		cellList.add(lastCell);
		// backtracking loop to find path from end to start
		while (lastCell.parentCell != null) {
			cellList.add(lastCell.parentCell);
			lastCell = lastCell.parentCell;
		}
		// the arrayList will start from the end of the maze and go to the start so
		// reverse
		Collections.reverse(cellList);
		this.path = super.listToStack(cellList);
		return path;
	}

	// returns the maze solved by BFS, the shortest path, the path it took, and the
	// number of visited cells
	public String mazeSolverBFS(Graph graph, String maze, Cell startingCell, Cell lastCell) {
		String solvedMaze = mazeBFS(graph, maze, startingCell);
		String shortestPath = mazeShortestPath(maze, getShortestPath(lastCell));
		String numCellsVisited = "Visited Cells: " + this.visitedCells;

		return solvedMaze + shortestPath + numCellsVisited;
	}

	public static void main(String[] args) {
		MazeGenerator jeff = new MazeGenerator(10);
		jeff.cellGenerator();
		MazePrinter mp = new MazePrinter();
		Cell[][] cellArray = mp.listTo2DArray(jeff.getCellList());
		String maze = mp.printMaze(cellArray);
		Graph graph = new Graph(jeff.getCellList());
		MazeSolverBFS ms = new MazeSolverBFS();
		Cell startingCell = cellArray[0][0];
		Cell lastCell = cellArray[cellArray.length - 1][cellArray.length - 1];
		System.out.println(ms.mazeSolverBFS(graph, maze, startingCell, lastCell));
	}
}
