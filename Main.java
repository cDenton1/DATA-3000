// Latest version of Main.java
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        // JOptionPane.showMessageDialog(null, "Employee Data Searching and Searching Program! \n Press OK to start");

        Employee[] employees = new Employee[1000];
        int index = 0;

        String filePath = JOptionPane.showInputDialog("Enter the full path of employee data file");
		
		// Scanner object to read the file.
        try (Scanner fileScanner = new Scanner(new File(filePath))) {

            System.out.println("Reading employee data from " + filePath);

            while (fileScanner.hasNextLine() && index < employees.length) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                int ID = Integer.parseInt(data[0]);
                String name = data[1];
                double hoursWorked = Double.parseDouble(data[2]);
                double hourlyRate = Double.parseDouble(data[3]);
                double deductionProvince = Double.parseDouble(data[4]);
                double deductionFederal = Double.parseDouble(data[5]);
                double educationAllowance = Double.parseDouble(data[6]);

                employees[index++] = new Employee(
                        ID, name, hoursWorked, hourlyRate,
                        deductionProvince, deductionFederal, educationAllowance
                );
            }

        } catch (Exception e) {
            System.out.println("File not found, please try again"); // Prints an error message if the file is not found.
            return; // Exit the program if the file is not found.
        }

        System.out.println("Loaded " + index + " employees"); // Prints the number of employees loaded into the array.

        /*
        for (int i = 0; i < index; i++) {
            System.out.println("Employee: " + employees[i].name); // Prints the name of the employee.
            employees[i].calcHourlySalary(); // Calls the method to calculate and print the gross pay, deductions, and net pay for each employee.
            System.out.println(); // Adds a blank line for better readability between employees.
        }
        */
        
        
		// call selection sort
        long sStart = System.currentTimeMillis();
        SelectionSort.selectionSort(employees);
        long sEnd = System.currentTimeMillis();

        System.out.println(" ");

        System.out.println("The performance of our sorting algorithms");
        
        System.out.println("###########################################");
        System.out.println("SelectionSort time: " + (sEnd - sStart) + " ms");

        String sortedemployeeBySalary = "sortedemployeeBySalary.csv";

        try (java.io.PrintWriter writer = new java.io.PrintWriter(new File(sortedemployeeBySalary))) {
            for (int i = 0; i < index; i++) {
    	        writer.println(employees[i].toString());
    	    }
    	    System.out.println("Data successfully saved to " + sortedemployeeBySalary);
    	} 
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        // call quicksort
        long qStart = System.currentTimeMillis();
		QuickSort.sort(employees);
        long qEnd = System.currentTimeMillis();

        System.out.println("------------------------------------------------------");
        System.out.println("QuickSort time: " + (qEnd - qStart) + " ms");

        /*
        // Print first few to verify
        //for (int i = 0; i < Math.min(index, 10); i++) {
            //System.out.println(employees[i]);
        }
         */
    
        String sortedemployeeByName = "sortedemployeeByName.csv";

        try (java.io.PrintWriter writer = new java.io.PrintWriter(new File(sortedemployeeByName))) {
            for (int i = 0; i < index; i++) {
            writer.println(employees[i].toString());
        }
        System.out.println("Data successfully saved to " + sortedemployeeByName);
    } 
        catch (Exception e) {
            System.out.println("An error has occurred. " + e.getMessage());
        }

        System.out.println("###########################################");

        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the employee to search");
        String searchName = input.nextLine();
        int pos = BinarySearch.search(employees, searchName, 0, index - 1);

        if (pos == -1) {
            System.out.println("Employee name not found.");
        } else {
            System.out.println("Employee found at index " + pos);
        }
            }
    }
    
        


