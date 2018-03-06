package week7;

import java.io.*;
import java.util.Scanner;

public class ReadText {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("marks.txt");
        Scanner s = new Scanner(fr);
        /*
         * Use line below instead of that above for input from keyboard. To end
         * input use CTRL-Z (Windows) or CTRL-D (Linux and Mac).
         */
        //Scanner s = new Scanner(System.in);
        FileWriter fw = new FileWriter("results.txt");
        PrintWriter pw = new PrintWriter(fw);

        pw.println(s.nextLine());

        while (s.hasNextLine()) {
            String line = s.nextLine();
            pw.print(line);
            int sum = 0;
            Scanner ls = new Scanner(line);
            while (ls.hasNext()) {
                if (ls.hasNextInt()) {
                    sum += ls.nextInt();
                } else {
                    ls.next();
                }
            }
            ls.close();
            pw.println("\t\tTotal mark: " + sum);

        }
        s.close();
        pw.close();
    }
}
