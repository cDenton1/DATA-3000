import java.util.Scanner;

public class FCFSAlgorithm {
    public static void main(String[] args) {
        // JOptionPane.showMessageDialog(null, "FCFS (First-Come-First-Serve) Scheduling Simulation! \nPress OK to start", "Welcome to", JOptionPane.INFORMATION_MESSAGE);
        
        /* The following code is just to get the main logic out of the way.
        It's assumed the other classes will handle the variables. */

        int numberOfProcesses;
        int arrivalTimes[];
        int burstTimes[];
        int turnaroundTime;
        int waitingTime;
        int averageTurnaroundTime;
        int averageWaitingTime;
        int completionTime;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        numberOfProcesses = input.nextInt();
 
        for (int i = 0; i <= numberOfProcesses; i++) {

            // Inputting the numbers
            System.out.print("\nEnter arrival time for process " + "P" + (i+1) + ": ");
            arrivalTimes[i] = input.nextInt();
            
            System.out.print("Enter burst time for process " + "P" + (i+1) + ": ");
            burstTimes[i] = input.nextInt();
        }

        // Actual calculations
        
        
        // Display message - don't worry about it for now
        /*
        for (int j = 1; j <= numberOfProcesses; j++ ) {
                JOptionPane.showMessageDialog(null, "Process P" + j);
            }
         */
        
        // Message displaying average waiting and turnaround times
        // JOptionPane.showMessageDialog(null, "Average Waiting Time > " + averageWaitingTime + "\nAverage Turnaround Time > " + averageTurnaroundTime);
    }
}
