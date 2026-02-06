/*
This code is basically just the employee class but me attempting to make an calcHourlySalary() method according to
the instructions we have. It will be merged with the main employee class when we're able to do that.
For now, this code will be pushed in order to keep tabs on progress.
*/

public class Employee {

    public double calcHourlySalary() {
        double educationAllowance;
        double grossPay = hoursWorked * hourlyRate;
        double deductionAmount = grossPay * (deductionProvince + deductionFederal);
        return grossPay - deductionAmount + educationAllowance;
    }

    public static void main(String[] args) {
        /* All the variables needed in order to calculate the salary of each employee.
        The variables are being declared just to show that it's working and will be modified
        in order for it to apply to all employees. The numbers come from the "John Smith" example.
        */
       /*
        double hoursWorked = 40;
        double hourlyRate = 15.50;
        double deductionProvince = 0.05;
        double deductionFederal = 0.1;
        double educationAllowance = 1000;


        System.out.printf("%.2f%n", netPay);
         */
       }

    }

