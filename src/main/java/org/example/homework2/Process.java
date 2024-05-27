package org.example.homework2;

public class Process implements Comparable<Process> {
    String processName;
    int priority;
    int burstTime;
    int arrivalTime;
    int remainingTime;  // Added to keep track of the remaining burst time

    public Process(String processName, int priority, int burstTime, int arrivalTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.remainingTime = burstTime;  // Initialize remaining time to burst time
    }

    @Override
    public int compareTo(Process other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        } else {
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
    }
}
