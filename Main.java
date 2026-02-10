import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[1000];
        int index = 0;
		
		// Scanner object to read the file.
        try (Scanner fileScanner = new Scanner(new File("employeesWithoutRepeat.txt"))) {

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

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage()); // Prints an error message if the file is not found.
            return; // Exit the program if the file is not found.
        }

        System.out.println("Loaded " + index + " employees"); // Prints the number of employees loaded into the array.
        
		// call selection sort
        long sStart = System.currentTimeMillis();
        SelectionSort.selectionSort(employees);
        long sEnd = System.currentTimeMillis();

        System.out.println("SelectionSort time: " + (sEnd - sStart) + " ms");
        
        // call quicksort
        long qStart = System.currentTimeMillis();
        QuickSort.sort(employees);
        long qEnd = System.currentTimeMillis();

        System.out.println("QuickSort time: " + (qEnd - qStart) + " ms");

        // Print first few to verify
        for (int i = 0; i < Math.min(index, 10); i++) {
            System.out.println(employees[i]);
        }
    }
}
