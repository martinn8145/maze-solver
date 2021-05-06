package Nguyen.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class MazeTester {
	MazeGenerator g;
	Cell startingCell;
	Cell lastCell;
	FilePrinter fp;
	MazePrinter mp;
	MazeSolverBFS bfs;
	MazeSolverDFS dfs;
	MazeHelper h;
	String s;
	String bfsMaze;
	String dfsMaze;
	Graph graph;
	String shortestPathDFS;
	String shortestPathBFS;
	
	@BeforeEach
	void setUp() {
		fp = new FilePrinter();
		mp = new MazePrinter();
		bfs = new MazeSolverBFS();
		dfs = new MazeSolverDFS();
		h = new MazeHelper();
	}
	@Test
	// tests the 4x4 maze
	void testCase1() {
		g = new MazeGenerator(4);
		long start = System.nanoTime();
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase1 MazeGenerator Time: " + (time-start) + "ns");
		
		graph = new Graph(g.getCellList());
		Cell[][] cellArray = mp.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);				// the maze
		fp.writeData("The Maze", s, "testCase1");	//prints out the maze
		
		startingCell = cellArray[0][0];
		lastCell = cellArray[cellArray.length - 1][cellArray.length - 1];
		
		time = System.nanoTime();
		dfsMaze = dfs.mazeSolverDFS(graph, s, startingCell);
		long DFStime = System.nanoTime();
		System.out.println("TestCase1 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", dfsMaze, "testCase1");	//prints out the DFS maze
		
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		bfsMaze = bfs.mazeSolverBFS(graph, s, startingCell, lastCell);
		long BFStime = System.nanoTime();
		System.out.println("TestCase1 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", bfsMaze, "testCase1");	//prints out the BFS maze

		shortestPathBFS = h.mazeShortestPath(s,bfs.getShortestPath(lastCell));
		dfs.mazeDFS(graph, s, startingCell);
		shortestPathDFS = dfs.getShortestPath();
		assertEquals(shortestPathBFS, shortestPathDFS);		//compares the two short paths
	}
	@Test
	// tests the 5x5 maze
	void testCase2() {
		g = new MazeGenerator(5);
		long start = System.nanoTime();
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase2 MazeGenerator Time: " + (time-start) + "ns");
		
		graph = new Graph(g.getCellList());
		Cell[][] cellArray = mp.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);				// the maze
		fp.writeData("The Maze", s, "testCase2");	//prints out the maze
		
		startingCell = cellArray[0][0];
		lastCell = cellArray[cellArray.length - 1][cellArray.length - 1];
		
		time = System.nanoTime();
		dfsMaze = dfs.mazeSolverDFS(graph, s, startingCell);
		long DFStime = System.nanoTime();
		System.out.println("TestCase2 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", dfsMaze, "testCase2");	//prints out the DFS maze
		
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		bfsMaze = bfs.mazeSolverBFS(graph, s, startingCell, lastCell);
		long BFStime = System.nanoTime();
		System.out.println("TestCase2 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", bfsMaze, "testCase2");	//prints out the BFS maze
		

		shortestPathBFS = h.mazeShortestPath(s,bfs.getShortestPath(lastCell));
		dfs.mazeDFS(graph, s, startingCell);
		shortestPathDFS = dfs.getShortestPath();
		assertEquals(shortestPathBFS, shortestPathDFS);		//compares the two short paths
	}
	
	@Test
	// tests the 6x6 maze
	void testCase3() {
		g = new MazeGenerator(6);
		long start = System.nanoTime();
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase3 MazeGenerator Time: " + (time-start) + "ns");
		
		graph = new Graph(g.getCellList());
		Cell[][] cellArray = mp.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);				// the maze
		fp.writeData("The Maze", s, "testCase3");	//prints out the maze
		
		startingCell = cellArray[0][0];
		lastCell = cellArray[cellArray.length - 1][cellArray.length - 1];
		
		time = System.nanoTime();
		dfsMaze = dfs.mazeSolverDFS(graph, s, startingCell);
		long DFStime = System.nanoTime();
		System.out.println("TestCase3 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", dfsMaze, "testCase3");	//prints out the DFS maze
		
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		bfsMaze = bfs.mazeSolverBFS(graph, s, startingCell, lastCell);
		long BFStime = System.nanoTime();
		System.out.println("TestCase3 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", bfsMaze, "testCase3");	//prints out the BFS maze

		shortestPathBFS = h.mazeShortestPath(s,bfs.getShortestPath(lastCell));
		dfs.mazeDFS(graph, s, startingCell);
		shortestPathDFS = dfs.getShortestPath();
		assertEquals(shortestPathBFS, shortestPathDFS);		//compares the two short paths
	}
	
	@Test
	// tests the 7x7 maze
	void testCase4() {
		g = new MazeGenerator(7);
		long start = System.nanoTime();
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase4 MazeGenerator Time: " + (time-start) + "ns");
		
		graph = new Graph(g.getCellList());
		Cell[][] cellArray = mp.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);				// the maze
		fp.writeData("The Maze", s, "testCase4");	//prints out the maze
		
		startingCell = cellArray[0][0];
		lastCell = cellArray[cellArray.length - 1][cellArray.length - 1];
		
		time = System.nanoTime();
		dfsMaze = dfs.mazeSolverDFS(graph, s, startingCell);
		long DFStime = System.nanoTime();
		System.out.println("TestCase4 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", dfsMaze, "testCase4");	//prints out the DFS maze
		
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		bfsMaze = bfs.mazeSolverBFS(graph, s, startingCell, lastCell);
		long BFStime = System.nanoTime();
		System.out.println("TestCase4 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", bfsMaze, "testCase4");	//prints out the BFS maze

		shortestPathBFS = h.mazeShortestPath(s,bfs.getShortestPath(lastCell));
		dfs.mazeDFS(graph, s, startingCell);
		shortestPathDFS = dfs.getShortestPath();
		assertEquals(shortestPathBFS, shortestPathDFS);		//compares the two short paths
	}
	
	@Test
	// tests the 8x8 maze
	void testCase5() {
		g = new MazeGenerator(8);
		long start = System.nanoTime();
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase5 MazeGenerator Time: " + (time-start) + "ns");
		
		graph = new Graph(g.getCellList());
		Cell[][] cellArray = mp.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);				// the maze
		fp.writeData("The Maze", s, "testCase5");	//prints out the maze
		
		startingCell = cellArray[0][0];
		lastCell = cellArray[cellArray.length - 1][cellArray.length - 1];
		
		time = System.nanoTime();
		dfsMaze = dfs.mazeSolverDFS(graph, s, startingCell);
		long DFStime = System.nanoTime();
		System.out.println("TestCase5 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", dfsMaze, "testCase5");	//prints out the DFS maze
		
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		bfsMaze = bfs.mazeSolverBFS(graph, s, startingCell, lastCell);
		long BFStime = System.nanoTime();
		System.out.println("TestCase5 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", bfsMaze, "testCase5");	//prints out the BFS maze
		

		shortestPathBFS = h.mazeShortestPath(s,bfs.getShortestPath(lastCell));
		dfs.mazeDFS(graph, s, startingCell);
		shortestPathDFS = dfs.getShortestPath();
		assertEquals(shortestPathBFS, shortestPathDFS);		//compares the two short paths
	}
	
	@Test
	// tests the 10x10 maze
	void testCase6() {
		g = new MazeGenerator(10);
		long start = System.nanoTime();
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase6 MazeGenerator Time: " + (time-start) + "ns");
		
		graph = new Graph(g.getCellList());
		Cell[][] cellArray = mp.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);				// the maze
		fp.writeData("The Maze", s, "testCase6");	//prints out the maze
		
		startingCell = cellArray[0][0];
		lastCell = cellArray[cellArray.length - 1][cellArray.length - 1];
		
		time = System.nanoTime();
		dfsMaze = dfs.mazeSolverDFS(graph, s, startingCell);
		long DFStime = System.nanoTime();
		System.out.println("TestCase6 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", dfsMaze, "testCase6");	//prints out the DFS maze
		
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		bfsMaze = bfs.mazeSolverBFS(graph, s, startingCell, lastCell);
		long BFStime = System.nanoTime();
		System.out.println("TestCase6 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", bfsMaze, "testCase6");	//prints out the BFS maze
		

		shortestPathBFS = h.mazeShortestPath(s,bfs.getShortestPath(lastCell));
		dfs.mazeDFS(graph, s, startingCell);
		shortestPathDFS = dfs.getShortestPath();
		assertEquals(shortestPathBFS, shortestPathDFS);		//compares the two short paths
	}
}
