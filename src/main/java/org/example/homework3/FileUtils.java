package org.example.homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static RedBlackTree readFile(String filePath) throws IOException {
        RedBlackTree tree = new RedBlackTree();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 7) {
                    String surname = fields[0];
                    String name = fields[1];
                    String streetAddress = fields[2];
                    String city = fields[3];
                    String postcode = fields[4];
                    String country = fields[5];
                    String phoneNumber = fields[6];

                    Entry entry = new Entry(surname, name, streetAddress, city, postcode, country, phoneNumber);
                    String searchableName = surname + ", " + name;
                    tree.put(searchableName, entry);
                }
            }
        }
        return tree;
    }
}
