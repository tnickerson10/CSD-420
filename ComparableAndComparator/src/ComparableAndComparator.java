/*
Travis Nickerson
CSD 420
Sept 10th, 2021
Assignment 6
Goal: Write a program with the two following generic methods using a bubble sort. The first method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
public static <E extends Comparable<E>>
 void bubbleSort(E[] list)
public static <E> void bubbleSort(E[] list,
 Comparator<? super E> comparator)
 */

import java.util.Comparator;

public class ComparableAndComparator {

    // Creating generic bubble sort method utilizing Comparable interface
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        // Outer loop controls the pass after each comparison of indexes is finished
        for (int i = 1; i < list.length; i++) {
            // Inner loop controls the iteration and comparison of indexes
            for (int j = 0; j < list.length - i; j++) {
                // Swapping value of index if left index > right index using compareTo method
                if ( list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }

            }
        }
    }

    // Creating generic bubble sort method utilizing Comparator interface
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {

        // Outer loop controls the pass after each comparison of indexes is finished
        for (int i = 1; i < list.length; i++) {
            // Inner loop controls the iteration and comparison of indexes
            for (int j = 0; j < list.length - i; j++) {
                // Swapping value of index if left index > right index using comparator.compare method
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {

        // Creating an array of Integers
        Integer [] arr = {4,5,3,16,81,57,7,466,25};

        // Passing in our array to our bubbleSort method that uses comparable interface
        bubbleSort(arr);

        // Using a for loop to display our sorted array
        System.out.println("Sorted array with Comparable:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("Sorted array with Comparator:");

        // Creating a second array of Integers
        Integer [] arr2 = {1, 100, 55, 41, 77, 2, 251};

        // Passing in our second array to our bubbleSort method using comparator and lambda expression
        bubbleSort(arr2, (e1, e2) -> e1.compareTo(e2));

        // Using a for loop to display our sorted array
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
