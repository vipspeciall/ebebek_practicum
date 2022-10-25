package model;


public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name,double salary,int workHours,int hireYear) throws Exception {

        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;

    }
    private double tax(double salary){
        if(salary >= 1000){
            return (salary / 100.0 * 3.0);
        }
        else
            return 0;
    }

    private double bonus(double workHours){
        if(workHours > 40){
            return ((workHours - 40.0) * 30.0);
        }
        else
            return 0;
    }
    private double raiseSalary(double salary, int hireYear){
        int experiencedYear = 2021 - hireYear;
        double raiseSalary = 0.0;
        if(experiencedYear < 10 && experiencedYear >= 0){
            raiseSalary = (salary / 100.0 * 5.0);
        }
        else if(experiencedYear > 9 && experiencedYear < 20){
            raiseSalary = (salary / 100.0 * 10.0);
        }
        else if(experiencedYear > 19){
            raiseSalary = (salary / 100.0 * 15.0);
        }
        return raiseSalary;
    }

    @Override
    public String toString() {
        double tax = tax(this.salary);
        double bonus = bonus(this.workHours);
        double raiseSalary = raiseSalary(this.salary, this.hireYear);
        return(
                "\n"
                    +"\n\tAdi : " + this.name
                    +"\n\tMaasi : " + this.salary
                    +"\n\tCalisma Saati : " + this.workHours
                    +"\n\tBaslangic Yili : " + this.hireYear
                    +"\n\tVergi : " + tax
                    +"\n\tBonus : " + bonus
                    +"\n\tMaas Artisi : " + raiseSalary
                    +"\n\tVergi ve Bonuslar ile birlikte maas : " + (this.salary - tax + bonus)
                    +"\n\tToplam Maas : " + (this.salary + raiseSalary - tax + bonus)
                +"\n"
        );

    }
}
