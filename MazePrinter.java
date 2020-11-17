package nguyen.cs146project3;

import java.util.ArrayList;

public class MazePrinter {
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
