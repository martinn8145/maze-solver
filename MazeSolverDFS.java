package nguyen.cs146project3;

import java.util.LinkedList;
import java.util.Stack;

// uses the DFS approach to solving the maze, finds the shortest path and the visited cells
public class MazeSolverDFS extends MazeHelper {
	private boolean[][] visited; // boolean array to check if cell at visited[row][column] has been visited
	private Stack<Cell> path; // keeps track of the path of the solver; will be returned as the shortest
								// possible path
	private int visitedCells; // keeps track of total amount of visited cells in the search

	// constructor to initialize instance variables
	public MazeSolverDFS() {
		visitedCells = 0;
		path = new Stack<Cell>();
	}

	/**
	 * using an adjacency list representation of a graph, edit the maze to show DFS
	 * approach to solving the maze
	 * 
	 * @param graph        graph of all of the cells
	 * @param maze         the unsolved maze as a string
	 * @param startingCell the cell we start from (0,0)
	 * @return the path DFS algorithm takes to solve the maze
	 */
	public String mazeDFS(Graph graph, String maze, Cell startingCell) {
		// add edges to graph and get the adjacencylist
		graph.addEdge();
		LinkedList<Cell>[] adjacencyList = graph.getArrayOfLinked();

		// len is the length of each row/column; adjacencylist is row^2 or col^2
		int len = (int) Math.sqrt(adjacencyList.length);
		int counter = 0;// the number being printed in the maze

		String solvedMaze = maze; // the maze string we will be editing as we solve
		visited = new boolean[len][len]; // each traversed cell will have a boolean value depending on if its been
											// visited before

		Stack<Cell> cellStack = new Stack<Cell>(); // use a stack to implement DFS
		Stack<Cell> forks = new Stack<Cell>(); // forks will keep track of every time the solver hits a fork in the road
												// the solver can go in one of two directions; if its the wrong way, we
												// need to know

		// start with the starting cell
		cellStack.push(startingCell);
		visited[startingCell.getRow()][startingCell.getColumn()] = true;

		while (!cellStack.isEmpty()) { // until every cell has been traversed; this while loop will usually never be
										// false before we finish
			Cell currentCell = cellStack.pop(); // get top of the stack
			int row = currentCell.getRow(), col = currentCell.getColumn();
			solvedMaze = mazeEditor(solvedMaze, row, col, counter++); // edit the maze to display where we're at in the
																		// maze

			path.push(currentCell);
			visitedCells++;

			// checks if we're at the end of the maze; break out of the loop
			if (row == len - 1 && col == len - 1) {
				break;
			}
			// edit the maze to show the current step
			if (counter == 10)
				counter = 0; // only use single digit numbers
			LinkedList<Cell> neighborList = graph.getList(row, col); // get the entire adjacency list for a cell

			if (neighborList.size() == 4) { // if size == 4, the solver hit a fork in the maze;
				forks.push(currentCell);
			}

			if (neighborList.size() == 2) { // if size == 2, the solver hit a dead end
				if (forks.size() != 0) {
					Cell lastFork = forks.pop();
					while (path.peek() != lastFork) {
						path.pop(); // pop until we've reached the fork before the dead end; path is the shortest
									// path
					}
				}
			}

			for (Cell neighbor : neighborList) { // iterate through to find unvisited cells
				if (!visited[neighbor.getRow()][neighbor.getColumn()]) {
					cellStack.push(neighbor); // push the cells onto the stack and mark them as visited
					visited[neighbor.getRow()][neighbor.getColumn()] = true;
				}
			}
		}

		return solvedMaze + "\n";
	}

	public Stack<Cell> getPath() {
		return this.path;
	}

	// returns the maze solved by BFS, the shortest path, the path it took, and the
	// number of visited cells
	public String mazeSolverDFS(Graph graph, String maze, Cell startingCell) {
		String solvedMaze = mazeDFS(graph, maze, startingCell); // the solved maze DFS approach
		String shortestPath = mazeShortestPath(maze, this.path); // the shortest path from start to finish
		String numCellsVisited = "Visited Cells: " + this.visitedCells;

		return solvedMaze + shortestPath + numCellsVisited;
	}

	public static void main(String[] args) {
		MazeGenerator jeff = new MazeGenerator(10);
		jeff.cellGenerator();
		MazePrinter mp = new MazePrinter();
		Cell[][] cellArray = mp.listTo2DArray(jeff.getCellList());
		Graph graph = new Graph(jeff.getCellList());
		String maze = mp.printMaze(cellArray);
		MazeSolverDFS ms = new MazeSolverDFS();
		Cell startingCell = cellArray[0][0];
		String solvedMaze = ms.mazeSolverDFS(graph, maze, startingCell);
		System.out.println(solvedMaze);

	}
}
