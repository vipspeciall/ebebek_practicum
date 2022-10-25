import model.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Employee employee1 = null;
            String name = null;
            double salary = 0.0;
            int workHours = 0;
            int hireYear = 0;
            Scanner sc = new Scanner(System.in);
            while(employee1 == null) {

                if (name == null) {
                    System.out.println("Enter name:");
                    String tempName = sc.nextLine();
                    if (!tempName.matches("[a-zA-Z]+") == true) {
                        //throw new Exception("Invalid name format\n"); //Program kullanıcıya dogru tip icin sans tanimasi ve devam etmesi icin "sout" tercih edildi.
                        System.out.println("Invalid name format\n");
                        continue;
                    } else
                        name = tempName;
                }

                if (salary == 0.0) {

                    System.out.println("Salary:");
                    String inputTempSalary = sc.next();

                    if (inputTempSalary.matches("^[0-9]+\\.?[0-9]*$")) {
                        double tempSalary = Double.parseDouble(inputTempSalary);
                        if (tempSalary <= 0.0) {
                            //throw new Exception("Salary can't be 0 or less\n"); //Program kullanıcıya dogru tip icin sans tanimasi ve devam etmesi icin "sout" tercih edildi.
                            System.out.println("Salary can't be 0 or less\n");
                            continue;
                        } else
                            salary = tempSalary;
                    } else{
                        System.out.println("Wrong salary format!\n");
                        continue;
                    }
                }

                if (workHours == 0) {

                    System.out.println("Work Hours:");
                    String inputTempWorkHours = sc.next();

                    if(inputTempWorkHours.matches("^\\d+$"))
                    {
                        int tempWorkHours = Integer.parseInt(inputTempWorkHours);
                        if (tempWorkHours <= 0) {
                            // throw new Exception("Working hour can't be 0 or less\n"); // //Program kullanıcıya dogru tip icin sans tanimasi ve devam etmesi icin "sout" tercih edildi.
                            System.out.println("Working hour can't be 0 or less\n");
                            continue;
                        } else
                            workHours = tempWorkHours;
                    }else{
                        System.out.println("Wrong hour format!\n");
                        continue;
                    }

                }
                if (hireYear == 0) {

                    System.out.println("Hire Year:");
                    String inputTempHireYear = sc.next();

                    if(inputTempHireYear.matches("^\\d+$")) {
                        int tempHireYear = Integer.parseInt(inputTempHireYear);
                        if (tempHireYear < 1900 || tempHireYear > 2021) {
                            // throw new Exception("Hire year can not be older than year 1900 or can not be further than year 2021\n"); // //Program kullanıcıya dogru tip icin sans tanimasi ve devam etmesi icin "sout" tercih edildi.
                            System.out.println("Hire year can not be older than year 1900 or can not be further than year 2021\n");
                            continue;
                        } else
                            hireYear = tempHireYear;
                    }
                    else{
                        System.out.println("Wrong hire year format!\n");
                        continue;
                    }
                }
                employee1 = new Employee(name, salary, workHours, hireYear);
            }
            System.out.println(employee1.toString());
        } catch (Exception e) {
            System.out.println("\n" + e);
        } finally{
            System.out.println("\nProgram completed succesfully!");
        }
    }
}
