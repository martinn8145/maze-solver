package Nguyen.cs146.project3;
import java.io.File;
import java.io.FileWriter;


public class FilePrinter{
	private FileWriter fr;

	public void writeData(String mazeName, String maze, String fileName) {
		//write to file
		File f = new File("output/"+ fileName +".txt"); //the file will be found in the output folder
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			fr = new FileWriter(f,true);
			fr.write(mazeName); //title of maze: The Maze, DFS maze, or BFS maze
			fr.write("\n");
			fr.write(maze);	// this is where the maze will be printed
			fr.write("\n");

			fr.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print("Problem writing in file.");
		}
	}
}