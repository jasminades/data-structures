package org.example.homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue pq = new ProcessQueue(processes.size());
        int currentTime = 0;

        processes.sort((p1, p2) -> Integer.compare(p1.arrivalTime, p2.arrivalTime));

        int index = 0;
        Process currentProcess = null;

        // To track finish times and burst times
        Map<String, Integer> finishTimes = new HashMap<>();
        Map<String, Integer> burstTimes = new HashMap<>();
        for (Process process : processes) {
            burstTimes.put(process.processName, process.burstTime);
        }

        while (index < processes.size() || currentProcess != null || pq.length > 0) {
            while (index < processes.size() && processes.get(index).arrivalTime <= currentTime) {
                pq.addProcess(processes.get(index));
                index++;
            }

            if (currentProcess == null && pq.length > 0) {
                currentProcess = pq.runNextProcess();
            }

            if (currentProcess != null) {
                System.out.println("t: " + currentTime + " | " + currentProcess.processName);
                currentProcess.burstTime--;

                if (currentProcess.burstTime == 0) {
                    finishTimes.put(currentProcess.processName, currentTime + 1);
                    currentProcess = null;
                }
            } else {
                System.out.println("t: " + currentTime + " | CPU is idle");
            }

            if (pq.length > 0 && (currentProcess == null || pq.peekNextProcess().priority < currentProcess.priority)) {
                if (currentProcess != null) {
                    pq.addProcess(currentProcess);
                }
                currentProcess = pq.runNextProcess();
            }

            currentTime++;
        }

        System.out.println("Total time: " + currentTime);

        // Calculate the average waiting time
        double totalWaitingTime = 0;
        for (Process process : processes) {
            int finishTime = finishTimes.get(process.processName);
            int waitingTime = finishTime - burstTimes.get(process.processName) - process.arrivalTime;
            totalWaitingTime += waitingTime;
        }
        double averageWaitingTime = totalWaitingTime / processes.size();
        System.out.println("Average waiting time: " + averageWaitingTime);
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 1, 5, 0));  // Process P1 with priority 1, burst time 5, arrival time 0
        processes.add(new Process("P2", 3, 3, 2));  // Process P2 with priority 3, burst time 3, arrival time 2
        processes.add(new Process("P3", 2, 1, 4));  // Process P3 with priority 2, burst time 1, arrival time 4
        processes.add(new Process("P4", 4, 7, 6));  // Process P4 with priority 4, burst time 7, arrival time 6
        processes.add(new Process("P5", 1, 2, 8));  // Process P5 with priority 1, burst time 2, arrival time 8

        scheduleAndRun(processes);
    }
}
