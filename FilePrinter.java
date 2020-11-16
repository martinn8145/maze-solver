package Nguyen.cs146.project3;
import java.io.*;


public class FilePrinter{
	private FileWriter fr;
	
	public void writeData(String maze, String fileName) {
		//write to file
		File f = new File("output/"+ fileName +".txt"); 
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			fr = new FileWriter(f,true);
				fr.write(maze);
			
				fr.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print("Problem writing in file.");
		}
	}
	public static void main (String[] args) {
		FilePrinter f = new FilePrinter();
		Generator g = new Generator(3);
		MazePrinter m = new MazePrinter();
		g.cellGenerator();
		String s = m.printMaze(m.listTo2DArray(g.getCellList()));
		System.out.print(s);
		f.writeData(s, "maze");
		
		
	}
}
