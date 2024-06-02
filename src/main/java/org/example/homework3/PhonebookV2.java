package org.example.homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RedBlackTree tree = null;

        try {
            tree = FileUtils.readFile("C:/Users/Jasmina/IdeaProjects/data-structures/src/main/java/org/example/homework3/raw_phonebook_data.csv");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        int[] edgeCounts = tree.countRedAndBlackEdges();
        System.out.println("System is ready.");
        System.out.println("Total red edges in the tree: " + edgeCounts[1]);
        System.out.println("Total black edges in the tree: " + edgeCounts[0]);

        while (true) {
            System.out.println("Enter a name that you wish to search for, or -1 to exit: ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Thank you for using the phonebook..");
                break;
            }

            ArrayList<Entry> entries = tree.get(input);
            if (entries != null && !entries.isEmpty()) {
                System.out.println("Entries found: " + entries.size());
                for (Entry entry : entries) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("No entries found for: " + input);
            }
        }
        scanner.close();
    }
}
