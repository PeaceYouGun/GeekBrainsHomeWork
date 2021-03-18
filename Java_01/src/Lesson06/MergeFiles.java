package Lesson06;

import java.io.*;

public class MergeFiles {
    public static void main(String[] args) throws IOException {

        try {
            FileInputStream fis1 = new FileInputStream("src/Lesson06/text1.txt");
            String outputString = "";
            int output;
            while ((output = fis1.read()) != -1) {
                outputString += (char) output;
            }

            fis1.close();

            FileOutputStream fos1 = new FileOutputStream("src/Lesson06/text3.txt");
            PrintStream print1 = new PrintStream(fos1);
            print1.println(outputString);

            fos1.close();
            print1.close();

            FileInputStream fis2 = new FileInputStream("src/Lesson06/text2.txt");
            outputString = "";
            int output1;
            while ((output1 = fis2.read()) != -1)
                outputString += (char) output1;

            fis2.close();

            FileOutputStream fos2 = new FileOutputStream("src/Lesson06/text3.txt", true);
            PrintStream print2 = new PrintStream(fos2);
            print2.println(outputString);

            fos2.close();
            print2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
