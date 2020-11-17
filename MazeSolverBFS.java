package Nguyen.cs146.project3;

import java.util.*;

public class MazeSolverBFS extends MazeHelper{
	private boolean[][] visited; //boolean array to check if the cell's been visited

	public String BFS(Graph graph, String maze, Cell startingCell) {
		graph.addEdge();
		LinkedList<Cell>[] adjacencyList = graph.getArrayOfLinked();
		int len = (int) Math.sqrt(adjacencyList.length);
		int counter = 0;// the number being printed in the maze 
		visited = new boolean[len][len];
		Queue<Cell> cellQueue = new LinkedList<Cell>();

		cellQueue.add(startingCell);
		visited[startingCell.getRow()][startingCell.getColumn()] = true;

		while (!cellQueue.isEmpty()) {
			Cell current = cellQueue.peek();	//gets the cell from the head of the queue
			cellQueue.remove();					// removes from queue
			int row = current.getRow(), col = current.getColumn();
			maze = mazeEditor(maze, row, col, counter++);
			//end of the maze means break
			if (row == len - 1 && col == len - 1) {
				break;
			}
			//edit the maze to show the current step
			if (counter == 10) counter = 0; // only use single digit numbers
			LinkedList<Cell> neighborList = graph.getList(row, col); //gets the neighbor list from the current cell
			for (Cell neighbor: neighborList) {		//iterate through to find unvisited cells
				if (!visited[neighbor.getRow()][neighbor.getColumn()])  {
					cellQueue.add(neighbor);		//add the cells onto the queue and mark them as visited
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
		MazeSolverBFS ms = new MazeSolverBFS();
		Cell startingCell = cellArray[0][0];
		System.out.println(ms.BFS(graph, maze, startingCell));
	}
}
