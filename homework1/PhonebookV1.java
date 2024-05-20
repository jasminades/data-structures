import java.util.Scanner;

public class PhonebookV1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath = "raw_phonebook_data.csv";
        String outputFilePath = "raw_phonebook_data.csv";

        System.out.println("Loading");
        Entry[] entries = fileutils.readFile(inputFilePath);

        System.out.println("Sorting");
        mergesort.sort(entries);

        System.out.println("Saving");
        fileutils.writeToFile(entries, outputFilePath);

        System.out.println("Done");
        while (true) {
            System.out.print("Enter the name to search for, or enter -1 to exit");
            String name = scanner.nextLine();
            if (name.equals("-1")) {
                break;
            }

            int[] result = binarysearch.search(entries, name);
            if (result[0] == -1) {
                System.out.println("No entries with that name.");
            } else {
                System.out.println("Entries found: " + (result[1] - result[0] + 1));
                for (int i = result[0]; i <= result[1]; i++) {
                    System.out.println(entries[i]);
                }
            }
        }

        scanner.close();
        System.out.println("Thank you. Bye! :)");
    }
}
