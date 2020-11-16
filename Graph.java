package Nguyen.cs146.project3;
import java.util.*;

public class Graph {
	private LinkedList<Cell>[] adj;	//array of linked lists
	private ArrayList<Cell> list;
	public Graph(ArrayList<Cell> cellList) {
		list = cellList;
		adj = new LinkedList[list.size()];
		for (int i = 0; i < adj.length; i++){
			adj[i] = new LinkedList<>();
			adj[i].add(list.get(i));
		}

	}
	public void addEdge() {
		int size = (int) Math.sqrt(adj.length);
		for (int cellRow = 0; cellRow < size; cellRow++) {
			for (int cellCol = 0; cellCol < size; cellCol++) {
				Cell c = new Cell(cellRow,cellCol); //cell we are looking at
				int index = list.indexOf(c);	// find the index of it in the list
				c = list.get(index);	// transfer the data into c
				

				if (!c.get("North")) {	//if top wall is broken and not on top row
					if (cellRow!=0) {
						Cell vertex = new Cell(cellRow - 1, cellCol);	// get the cell above it
						int currIndex = list.indexOf(vertex);	// find its index in the list
						adj[index].add(list.get(currIndex));	// add the cell into the linked list
					}
				}

				if (!c.get("South")) { //if bottom wall is broken and not on bottom row
					if (cellRow != size - 1) {
						Cell vertex = new Cell(cellRow + 1, cellCol);	// get the cell below it
						int currIndex = list.indexOf(vertex);	// find its index in the list
						adj[index].add(list.get(currIndex));		// add the cell into the linked list
					}
				}

				if (!c.get("East")) {	//if right wall is broken and not on the last column
					if (cellCol != size - 1) {
						Cell vertex = new Cell(cellRow, cellCol + 1);	// get the cell to the right of it
						int currIndex = list.indexOf(vertex);	// find its index in the list
						adj[index].add(list.get(currIndex));	// add the cell into the linked list
					}
				}

				if (!c.get("West")) {		// if left wall is broken and not in the first column
					if (cellCol !=0) {
						Cell vertex = new Cell(cellRow, cellCol - 1);	// get the cell to the left of it
						int currIndex = list.indexOf(vertex);	// find its index in the list
						adj[index].add(list.get(currIndex));		// add the cell into the linked list
					}
				}
			}
		}
	}

	public void printAllLists() {
		for (int i = 0; i < adj.length; i++) { 
			System.out.println("Adjacency list of vertex " + list.get(i).getRow() + " " + list.get(i).getColumn() + ": "); 
			for (int j = 0; j < adj[i].size(); j++) { 
				System.out.print(adj[i].get(j).getRow() + " " + adj[i].get(j).getColumn() + "; "); 
			} 
			System.out.println(); 
		} 
	}
	public LinkedList<Cell> getList(int x, int y){
		Cell c = new Cell(x,y);
		int index = list.indexOf(c);
		return adj[index];
	}


	public static void main (String[] args) {
		Generator jeff = new Generator(3);
		jeff.cellGenerator();
		Graph g = new Graph(jeff.getCellList());
		g.addEdge();
		LinkedList<Cell> f = g.getList(0, 0);
		for (Cell C : f) {
		System.out.println(C.getRow() + "," + C.getColumn() + " ");
		}
		g.printAllLists();
		


	}
}
