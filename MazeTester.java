package Nguyen.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazeTester {
	MazeGenerator g;
	Cell c;
	FilePrinter fp;
	MazePrinter mp;
	MazeSolverBFS bfs;
	MazeSolverDFS dfs;
	MazeHelper h;
	String s;
	Graph graph;
	
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
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase1 MazeGenerator Time: " + time + "ns");
		Cell[][] cellArray = h.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);
		fp.writeData("The Maze", s, "testCase1");	//prints out the maze
		c = cellArray[0][0];
		graph = new Graph(g.getCellList());
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		s = bfs.BFS(graph, s, c);
		long BFStime = System.nanoTime();
		System.out.println("TestCase1 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", s, "testCase1");	//prints out the BFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase1");	//prints out the fastest path
		time = System.nanoTime();
		s = dfs.DFS(graph, s, c);
		long DFStime = System.nanoTime();
		System.out.println("TestCase1 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", s, "testCase1");	//prints out the DFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase1");	//prints out the fastest path
		//assertTrue(shortpath1, shortpath2);		//compares the two short paths
	}
	@Test
	// tests the 5x5 maze
	void testCase2() {
		g = new MazeGenerator(5);
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase2 MazeGenerator Time: " + time + "ns");
		Cell[][] cellArray = h.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);
		fp.writeData("The Maze", s, "testCase2");	//prints out the maze
		c = cellArray[0][0];
		graph = new Graph(g.getCellList());
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		s = bfs.BFS(graph, s, c);
		long BFStime = System.nanoTime();
		System.out.println("TestCase2 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", s, "testCase2");	//prints out the BFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase2");	//prints out the fastest path
		time = System.nanoTime();
		s = dfs.DFS(graph, s, c);
		long DFStime = System.nanoTime();
		System.out.println("TestCase2 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", s, "testCase2");	//prints out the DFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase2");	//prints out the fastest path
		//assertTrue(shortpath1, shortpath2);		//compares the two short paths
	}
	@Test
	// tests the 6x6 maze
	void testCase3() {
		g = new MazeGenerator(6);
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase3 MazeGenerator Time: " + time + "ns");
		Cell[][] cellArray = h.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);
		fp.writeData("The Maze", s, "testCase3");	//prints out the maze
		c = cellArray[0][0];
		graph = new Graph(g.getCellList());
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		s = bfs.BFS(graph, s, c);
		long BFStime = System.nanoTime();
		System.out.println("TestCase3 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", s, "testCase3");	//prints out the BFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase3");	//prints out the fastest path
		time = System.nanoTime();
		s = dfs.DFS(graph, s, c);
		long DFStime = System.nanoTime();
		System.out.println("TestCase3 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", s, "testCase3");	//prints out the DFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase3");	//prints out the fastest path
		//assertTrue(shortpath1, shortpath2);		//compares the two short paths
	}
	@Test
	// tests the 7x7 maze
	void testCase4() {
		g = new MazeGenerator(7);
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase4 MazeGenerator Time: " + time + "ns");
		Cell[][] cellArray = h.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);
		fp.writeData("The Maze", s, "testCase4");	//prints out the maze
		c = cellArray[0][0];
		graph = new Graph(g.getCellList());
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		s = bfs.BFS(graph, s, c);
		long BFStime = System.nanoTime();
		System.out.println("TestCase4 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", s, "testCase4");	//prints out the BFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase4");	//prints out the fastest path
		time = System.nanoTime();
		s = dfs.DFS(graph, s, c);
		long DFStime = System.nanoTime();
		System.out.println("TestCase4 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", s, "testCase4");	//prints out the DFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase4");	//prints out the fastest path
		//assertTrue(shortpath1, shortpath2);		//compares the two short paths
	}
	@Test
	// tests the 8x8 maze
	void testCase5() {
		g = new MazeGenerator(8);
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase5 MazeGenerator Time: " + time + "ns");
		Cell[][] cellArray = h.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);
		fp.writeData("The Maze", s, "testCase5");	//prints out the maze
		c = cellArray[0][0];
		graph = new Graph(g.getCellList());
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		s = bfs.BFS(graph, s, c);
		long BFStime = System.nanoTime();
		System.out.println("TestCase5 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", s, "testCase5");	//prints out the BFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase5");	//prints out the fastest path
		time = System.nanoTime();
		s = dfs.DFS(graph, s, c);
		long DFStime = System.nanoTime();
		System.out.println("TestCase5 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", s, "testCase5");	//prints out the DFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase5");	//prints out the fastest path
		//assertTrue(shortpath1, shortpath2);		//compares the two short paths
	}
	@Test
	// tests the 10x10 maze
	void testCase6() {
		g = new MazeGenerator(10);
		g.cellGenerator();
		long time = System.nanoTime();
		System.out.println("TestCase6 MazeGenerator Time: " + time + "ns");
		Cell[][] cellArray = h.listTo2DArray(g.getCellList());
		s = mp.printMaze(cellArray);
		fp.writeData("The Maze", s, "testCase6");	//prints out the maze
		c = cellArray[0][0];
		graph = new Graph(g.getCellList());
		time = System.nanoTime(); //gets the current time so we can find out how long it actually takes BFS
		s = bfs.BFS(graph, s, c);
		long BFStime = System.nanoTime();
		System.out.println("TestCase6 BFS Time: " + (BFStime-time) + "ns");
		fp.writeData("BFS Maze", s, "testCase6");	//prints out the BFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase6");	//prints out the fastest path
		time = System.nanoTime();
		s = dfs.DFS(graph, s, c);
		long DFStime = System.nanoTime();
		System.out.println("TestCase6 DFS Time: " + (DFStime-time) + "ns");
		fp.writeData("DFS Maze", s, "testCase6");	//prints out the DFS maze
		
		//fp.writeData("BFS Shortest Path Maze", s, "testCase6");	//prints out the fastest path
		//assertTrue(shortpath1, shortpath2);		//compares the two short paths
	}

}
