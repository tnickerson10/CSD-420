/*
Travis Nickerson
CSD 420
August 20th, 2021
Assignment 2
Goal: Create a program using a recursive method that returns the sum of the following type inputs.
m(i) = 1/2 + 2/3 + 3/4 + 4/5 + 5/6 … i/(i + 1)
‘m’ is to be replaced with the method name you use.
Use three different input finishing values, testing your code to ensure it functions correctly.
Examples: m(4), m(9), m(14).

 */

public class Recursion {
    public static void main(String[] args) {

        // Printing our 3 passed in arguments for our add Recursive method
        System.out.println(add(30));
        System.out.println(add(11));
        System.out.println(add(18));

    }
        public static double add(double i) {

            // Checking for a base case of 0 being passed in as an argument and returning 0 to prevent math errors
            // dividing by 0
            if (i == 0) {
                return 0;
            } else {
                // returning i divided by itself plus one then calling our recursive method and decrementing i
                // by 1
                return i / (i +1) + add(i -1);
            }

        }
}

