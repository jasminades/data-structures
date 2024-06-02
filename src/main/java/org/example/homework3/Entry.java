package org.example.homework3;

public class Entry implements Comparable<Entry> {
    private String surname;
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String surname, String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Entry other) {
        int surnameCompare = this.surname.compareTo(other.surname);
        if (surnameCompare != 0) {
            return surnameCompare;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Name: " + surname + ", " + name + "\n" +
                "Street address: " + streetAddress + "\n" +
                "City: " + city + "\n" +
                "Postal code: " + postcode + "\n" +
                "Country: " + country + "\n" +
                "Phone number: " + phoneNumber + "\n";
    }
}
