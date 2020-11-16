package nguyen.cs146project3;

import java.util.ArrayList;

public class MazePrinter {
	public static Cell[][] listTo2DArray(ArrayList<Cell> cellList) {
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
	public static String printMaze(Cell[][] cellArray) {
		String maze = "";
		//first line
		for (int firstLine = 0; firstLine < cellArray.length; firstLine++) {
			if (firstLine !=0) {
				maze += "-+";
			} else {
				maze += "+ +";
			}
		}
		maze += "\n";
		for (int i = 0; i < cellArray.length; i++) {		
				maze += "|";
				for (int j = 0; j < cellArray.length; j++) {
					Cell currentCell = cellArray[i][j];
					maze += " ";
					if (currentCell.get("East")) {
						maze += "|";
					} else maze += " ";
				}
				maze += "\n";
				
				if (i != cellArray.length - 1) {
					maze += "+";
					for (int k = 0; k < cellArray.length; k++) {
						Cell currentCell = cellArray[i][k];
						if (currentCell.get("South")) {
							maze += "-";
						} else {
							maze += " ";
						}
						maze += "+";
					}
					maze += "\n";
				}			
		}
		for (int lastLine = 0; lastLine < cellArray.length; lastLine++) {
			if (lastLine != cellArray.length - 1) {
				maze += "+-";
			} else {
				maze += "+ +";
			}
		}
		return maze;
	}
	
	public static void main (String[] args) {
		Generator jeff = new Generator(45);
		jeff.cellGenerator();
		Cell[][] cellArray = listTo2DArray(jeff.getCellList());
		System.out.print(printMaze(cellArray));
	}
}
