/*
Travis Nickerson
CSD 420
Sept 16th, 2021
Assignment 8
Goal: Create a class titled <your first name here> ThreeThreads.
In this class, you are to use three threads to output three types of characters to a text area for display.
In the first thread, you are to output random letter characters such as a, b, c, d …
In the second thread, you are to output random number digits such as 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
In the third thread, you are to output random characters such as !, @, #, $, %, &, *
Display a minimum of 10,000 of each of the three sets.
 */

// extending our class to Thread
public class NickersonThreeThreads extends Thread{
    public static void main(String[] args) {

        // Creating a new Thread
        Thread randInts = new Thread() {
            // Overrides the run method in Thread
            @Override
            public void run() {

                // Crating a for loop to print 10000 random ints
                for(int i = 1; i <= 10000; i++) {
                    // Variables to create a range of random integers to print
                    int min = 1;
                    int max = 100;
                    int range = max - min + 1;

                    // Printing our random ints
                    System.out.print(i + ": " + (int) ((Math.random() * range) + min) + ", ");
                }
            }
        };

        // Creating a new Thread
        Thread randLetters = new Thread() {
            // Overrides run method in Thread
            @Override
            public void run() {

                // Creating an array to hold letters of the alphabet
                String [] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
                        "q","r","s","t","u","v","w","x","y","z"};

                // for loop iterates over our letters array
                for(int i = 1; i <= 10000; i++) {
                    // Setting a variable to hold a random index value of letters array
                    int randIdx = (int) (Math.random() * letters.length);

                    // Printing a random index of our array
                    System.out.print(i + ": " + letters[randIdx] + ", ");
                }
            }
        };

        // Crating a new Thread
        Thread randChars = new Thread() {
            // Overrides run method in Thread
            @Override
            public void run() {

                // Creating an array to hold random characters
                char [] chars = {'<','?','/','[','<','>','!','~','@',':','+','|'};

                // for loop iterates over our chars array
                for(int i = 1; i <= 10000; i++) {
                    // Setting a variable to hold a random index value of letters array
                    int randIdx = (int) (Math.random() * chars.length);

                    // Printing a random index of our array
                    System.out.print(i + ": " + chars[randIdx] + ", ");
                }
            }
        };

        randInts.start();
        randLetters.start();
        randChars.start();
    }
}
