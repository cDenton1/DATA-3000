/**
 * Represents a process in execution
 */
public class Process implements Comparable<Process> {

    // Attributes
    private int processID;
    private int arrivalTime;
    private int burstTime;

    /**
     * @param processID The unique identifier for the process
     * @param arrivalTime The time at which the process arrives
     * @param burstTime The amount of CPU time the process needs to complete
     */

    // Constructor
    public Process(int processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    // Getters
    public int getProcessID() {
        return processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    // Setters
    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    // Summary of the process
    public String toString() {
        return "Process ID: " + processID + " | Arrival Time: " + arrivalTime + " | Burst Time: " + burstTime;
    }

    /**
     * Compares processes by arrival Time, if equal, it compares by process ID
     */

    // compareTo() to compare the arrival times
    public int compareTo(Process other) {
        int comparison = Integer.compare(this.arrivalTime, other.arrivalTime);

        // If the arrival times are different, return the comparison result
        if (comparison != 0) {
            return comparison;
        }
        else { 
            // If the arrival times match, compare the process ID instead
            return Integer.compare(this.processID, other.processID); 
        }
        
    }
}
