/*
Travis Nickerson
CSD 420
August 13th, 2021
Assignment 1
Goal: Write a program that stores:
An array of five random integers
A Data objective instance using the current date
An array of five random double values
Append the data in a file titled <yourname> datafile.dat.
Write a second program that will read the file and display the data.
Test the code to ensure the code functions correctly.
 */

// Import statements
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class BinaryIO {
    public static void main(String[] args) throws IOException {

        // Creating an ArrayList for our Random integers
        ArrayList<Integer> randInts = new ArrayList<Integer>();
        // Creating 4 random separate integers
        int rand1 = (int) (Math.random() * 10 + 1);
        int rand2 = (int) (Math.random() * 10 + 1);
        int rand3 = (int) (Math.random() * 10 + 1);
        int rand4 = (int) (Math.random() * 10 + 1);

        // Creating an ArrayList for our random doubles
        ArrayList<Double> randDouble = new ArrayList<Double>();
        // Creating 4 random separate doubles
        double randDouble1 = (double) (Math.random() * 10 + 1);
        double randDouble2 = (double) (Math.random() * 10 + 1);
        double randDouble3 = (double) (Math.random() * 10 + 1);
        double randDouble4 = (double) (Math.random() * 10 + 1);

        // Adding our random integers to our Arraylist
        randInts.add(rand1);
        randInts.add(rand2);
        randInts.add(rand3);
        randInts.add(rand4);

        // Adding our random doubles to our Arraylist
        randDouble.add(randDouble1);
        randDouble.add(randDouble2);
        randDouble.add(randDouble3);
        randDouble.add(randDouble4);

        // Creating a local Date object
        Date local = new Date();

        // Using the PrintWriter object we are creating a new FileOutputStream for our .dat file and setting append to false
        try (PrintWriter write = new PrintWriter(new FileOutputStream("Nickerson-datafile.dat", false))) {
            // writing our random integer array/ double array and local date object to our file
            write.println(randInts);
            write.println(local);
            write.println(randDouble);
        } catch (FileNotFoundException e) {
            System.out.println("File Doesn't Exist");
        }

        // Program that Creates a RandomAccessFile to Read the contents of our file and display them to the console
        try (RandomAccessFile readFile = new RandomAccessFile("Nickerson-datafile.dat", "r")){
            String line;
            // using a while loop to read each line as long as the line value isn't null
            while ( (line = readFile.readLine()) != null ) {
                System.out.println(line);
            }

            // printing each line of our file
            System.out.println();

            // catching our file not found and IO exceptions if necessary
        } catch (FileNotFoundException e) {
            System.out.println("File Doesn't Exist");
        } catch (IOException ioe) {
            System.err.println(ioe);
        }

    }
}
