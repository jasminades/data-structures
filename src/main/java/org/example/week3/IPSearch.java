package org.example.week3;


public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddressStr) {
        long ipAddress = convertIpAddress(ipAddressStr);


        int low = 0;
        int high = ipAddresses.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ipAddress >= ipAddresses[mid].getStartIp() && ipAddress <= ipAddresses[mid].getEndIp()) {
                return ipAddresses[mid];
            } else if (ipAddress < ipAddresses[mid].getStartIp()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    private static long convertIpAddress(String ipAddressStr) {
        String[] octets = ipAddressStr.split("\\.");
        long ipNumber = 0;
        for (String octet : octets) {
            ipNumber = ipNumber << 8 | Long.parseLong(octet);
        }
        return ipNumber;
    }
}
