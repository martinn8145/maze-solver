package nguyen.cs146project3;

public class MazePrinter extends MazeHelper {

	// returns a string of the empty maze created by the MazeGenerator class
	public String printMaze(Cell[][] cellArray) {
		String maze = "";
		// first line looks like + +-+-+-+...
		for (int firstLine = 0; firstLine < cellArray.length; firstLine++) {
			if (firstLine != 0) {
				maze += "-+";
			} else {
				maze += "+ +";
			}
		}
		maze += "\n";
		// move on to the body of the maze
		for (int i = 0; i < cellArray.length; i++) {
			maze += "|"; // left most wall always exists
			for (int j = 0; j < cellArray.length; j++) {
				Cell currentCell = cellArray[i][j]; // get the current cell and add a space
				maze += " ";
				if (currentCell.get("East")) { // if there's a wall to the right then add a wall
					maze += "|";
				} else
					maze += " "; // if there's not then add a space
			}
			maze += "\n";
			// add horizontal walls before last line
			if (i != cellArray.length - 1) {
				maze += "+"; // left side always start with +
				for (int k = 0; k < cellArray.length; k++) {
					Cell currentCell = cellArray[i][k];
					if (currentCell.get("South")) { // check if the bottom wall is intact
						maze += "-";
					} else {
						maze += " ";
					}
					maze += "+"; // right side always ends in +
				}
				maze += "\n";
			}
		}
		// last line looks like this ... +-+-+ +
		for (int lastLine = 0; lastLine < cellArray.length; lastLine++) {
			if (lastLine != cellArray.length - 1) {
				maze += "+-";
			} else {
				maze += "+ +";
			}
		}
		return maze;
	}
}
