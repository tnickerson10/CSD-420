/*
Travis Nickerson
CSD 420
August 29th, 2021
Assignment 4
Goal: Write a test program that stores 50,000 integers in LinkedList and test the time to traverse the list using an
iterator vs. using the get(index) method.
Then, test your program storing 500,000 integers.
After completing this program and having tested both values, in your comments, explain the results and discuss the time
 taken using both values and their difference with the get(index) approach.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListIterationTime {
    public static void main(String[] args) {
        // create a linkedlist of 50,000 ints
        LinkedList<Integer> list50000 = new LinkedList<>();
        for (int i = 0; i < 50000; i++){
            list50000.add(i);
        }

        // create and start a timer in milliseconds for our iterator
        long timeStartIteration = System.currentTimeMillis();
        // create our listIterator object and traverse it
        ListIterator<Integer> iterateTime = list50000.listIterator();
        while (iterateTime.hasNext()) {
            iterateTime.next();
        }
        // end our timer once our iteration traverse is over
        long timeEndIteration = System.currentTimeMillis();

        // start a timer in milliseconds to use our get(i) method
        long timeStartGet = System.currentTimeMillis();
        for(int i = 0; i < 50000; i++) {
            list50000.get(i);
        }
        // end our timer for the get(i) method
        long timeEndGet = System.currentTimeMillis();
        // print statements for 50,000 ints
        System.out.println("50,000 Iteration Time: " + (timeEndIteration - timeStartIteration) + "ms");
        System.out.println("50,000 get(i) Time: " + (timeEndGet - timeStartGet) + "ms");

        // creating an arrayList and adding our 500,000 ints
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 500000; i++){
            arr.add(i);
        }
        // creating our LinkedList and passing in our arrayList
        LinkedList<Integer> list500000 = new LinkedList<>(arr);

        // starting our timer for our 500,000 int iterator
        long timeStartIteration2 = System.currentTimeMillis();
        // create our listIterator object and traverse it
        ListIterator<Integer> iterateTime2 = list500000.listIterator();
        while (iterateTime2.hasNext()) {
            iterateTime2.next();
        }

        // ending our iteration timer
        long timeEndIteration2 = System.currentTimeMillis();
        // starting the timer for our get(i) method on 500,000 ints
        long timeStartGet2 = System.currentTimeMillis();
        // adding 500,000 ints
        for(int i = 0; i < 500000; i++) {
            list500000.get(i);
        }
        // ending our get(i) timer
        long timeEndGet2 = System.currentTimeMillis();

        // print methods for our 500,000 ints
        System.out.println("500,000 Iteration Time: " + (timeEndIteration2 - timeStartIteration2) + "ms");
        System.out.println("500,000 get(i) Time: " + (timeEndGet2 - timeStartGet2) + "ms");
    }
}
// Overall the iterator object was faster than both of the get(i) methods. This makes sense due to efficiency in this case.
// The difference was very drastic in my case on my computer: avg iteration for 50,000 was 8ms and the average for
// get(i) was 3.2 seconds. For 500,000 ints this was surprising and may be due to my computer, but the avg for iterator
// was 15ms and for get(i) the avg was 3.9 minutes. I played around with adding the 500,000 ints with a straight linkedList
// vs creating an ArrayList and passing it into a LinkedList for speed and it appears that creating an ArrayList is about
// 3x faster. I didnt do that for the 50,000 ints as I wanted to compare it but I believe I using just a linkedList for
// only 50000 ints it is faster vice 500,000 as mentioned.