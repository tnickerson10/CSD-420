/*
Travis Nickerson
CSD 420
August 28th, 2021
Assignment 3
Goal:Write a test program that contains a static method that returns a new ArrayList.
The new ArrayList returned will contain all original values with no duplicates from the original ArrayList.
Fill the Original ArrrayList with 50 random values from 1 to 20.
public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
 */

import java.util.*;

public class NoDuplicates {
    public static void main(String[] args) {

        // Creating an Integer ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // for loop to add 50 random ints (0-20) range
        for (int i = 0; i < 50; i++) {
            // create random num object
            Random rand = new Random();
            // set max value of range (21 because its non inclusive)
            int num = rand.nextInt(21);
            // adding each random num to our ArrayList
            list.add(num);
        }
        System.out.println("The original array was:");
        // printing the original Array
        System.out.println(list);
        // printing the updated array with removed duplicates
        System.out.println(removeDuplicates(list));
    }

    // Generic ArrayList that will remove our duplicated ints in our list arrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        // sets the end bound of list Array
        int end = list.size();

        // Creating a new HashSet Object so we can iterate it with only unique ints (HashSets dont allow
        // duplicated values)
        Set<Integer> set = new HashSet<Integer>();

        System.out.println("The new array with no duplicates is:");

        // adding our Arraylist to our HashSet without duplicates
        for(int i = 0; i < end; i++){
            set.add((Integer) list.get(i));
        }

        // Creating a new ArrayList to convert our HashSet back to an ArrayList so we can return it
        ArrayList<E> arr2 = new ArrayList<E>((Collection<? extends E>) set);

        return arr2;
    }
}
