package week7;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteText {
	
   	public static void main (String [] args) 
   			throws IOException {
   		FileWriter fw = new FileWriter("marks.txt", true);
		PrintWriter pw = new PrintWriter(fw);
   		pw.println("CSSE2002 assignment marks");
   		pw.println("Albert \t 10 7 8");
   		pw.println("Jane \t 2 10 8");
   		pw.println("Jack \t 3 - -");
   		pw.close();
   	}
}
