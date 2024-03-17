package org.example.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) {
        ArrayList<IPAddress> ipAddressList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                long startIp = Long.parseLong(parts[0]);
                long endIp = Long.parseLong(parts[1]);
                String countryCode = parts[2];
                String country = parts[3];
                String region = parts[4];
                String city = parts[5];
                IPAddress ipAddress = new IPAddress(startIp, endIp, countryCode, country, region, city);
                ipAddressList.add(ipAddress);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipAddressList.toArray(new IPAddress[0]);
    }
}

