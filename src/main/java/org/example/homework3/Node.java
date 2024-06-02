package org.example.homework3;

import java.util.ArrayList;

public class Node {
    public String key;
    public ArrayList<Entry> values;
    public Node left, right;
    public boolean color;

    public Node(String key, Entry value, boolean color) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
        this.left = null;
        this.right = null;
        this.color = color;
    }
}
