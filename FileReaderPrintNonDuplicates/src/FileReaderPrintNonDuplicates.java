/*
Travis Nickerson
CSD 420
Sept 3rd, 2021
Assignment 5
Goal:Write a test program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.
The file is to be referenced in the program, not needing to be used as a command line reference.
The word file is to be titled collection_of_words.txt.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class FileReaderPrintNonDuplicates {
    public static void main(String[] args) throws IOException {

        // Creating a new File
        File file = new File("collection_of_words.txt");
        // Creating a FileWrite to write into our File
        FileWriter fw = new FileWriter(file);
        // Creating a PrintWriter and passing in our FileWriter
        PrintWriter pw = new PrintWriter(fw);

        // Stores the contents of our file that will be added
        String words = "We hold these truths to be self-evident, that all men are created equal, that they are\n " +
                "endowed by their Creator with certain unalienable Rights, that among these are Life, Liberty\n " +
                "and the pursuit of Happiness.That to secure these rights, Governments are instituted among\n " +
                "Men, deriving their just powers from the consent of the governed, That whenever any Form of\n " +
                "Government becomes destructive of these ends, it is the Right of the People to alter or to abolish it,\n " +
                "and to institute new Government, laying its foundation on such principles and organizing its powers in\n " +
                "such form, as to them shall seem most likely to effect their Safety and Happiness. Prudence, indeed,\n " +
                "will dictate that Governments long established should not be changed for light and transient causes;\n " +
                "and accordingly all experience hath shewn, that mankind are more disposed to suffer, while evils are\n " +
                "sufferable, than to right themselves by abolishing the forms to which they are accustomed. But when a\n " +
                "long train of abuses and usurpations, pursuing invariably the same Object evinces a design to reduce\n " +
                "them under absolute Despotism, it is their right, it is their duty, to throw off such Government, and\n " +
                "to provide new Guards for their future security. Such has been the patient sufferance of these\n " +
                "Colonies; and such is now the necessity which constrains them to alter their former Systems of\n " +
                "Government. The history of the present King of Great Britain is a history of repeated injuries and\n " +
                "usurpations, all having in direct object the establishment of an absolute Tyranny over these States.\n " +
                "To prove this, let Facts be submitted to a candid world.";

        // Using our PrintWriter to write to collection_of_words.txt
        pw.write(words);
        // Closing the file so that the document will properly write
        pw.close();

        // Creating a TreeSet to store our words from the file. We use a TreeSet because it orders ascending
        TreeSet<String> nonDuplicatedWordsAsc = new TreeSet<String>();

        // Creating a Scanner to read our file
        Scanner scanTxt = new Scanner(file);

        // While loop checks to see if there is another word in our file while scanning
        while(scanTxt.hasNext()) {
            // Storing each word in a string array. We use regrex to split the words including a space, comma,
            // semicolon and period
            String[] docWords = scanTxt.next().split("[ ,.;]");
            // For each loop that will iterate over our file and add each word
            for (String i: docWords) {
                // We have to use the lowercase method  to keep all words in ascending order otherwise our
                // capitalized words will appear first in our array and then the lowercase words will appear
                nonDuplicatedWordsAsc.add(i.toLowerCase());
            }
        }
        // Print statements
        System.out.println(nonDuplicatedWordsAsc);
        // Print descending order with TreeSet method descendingSet() that just reverses our original TreeSet
        System.out.println(nonDuplicatedWordsAsc.descendingSet());
    }
}
