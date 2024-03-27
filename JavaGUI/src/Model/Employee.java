package Model;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee implements Comparable<Employee> {

    NumberFormat money = NumberFormat.getCurrencyInstance(Locale.UK);

    private String employeeName;
    private int cakesCovered;
    private double wages = 0.10;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getCakesCovered() {
        return cakesCovered;
    }

    public void setCakesCovered(int cakesCovered) {
        this.cakesCovered = cakesCovered;
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    public Employee(String employeeName, int cakesCovered) {
        this.employeeName = employeeName;
        this.cakesCovered = cakesCovered;
    }

    public double calculateWage(){
        if (cakesCovered <= 50){
            return cakesCovered * wages;
        }
        else {
            return ((50 * wages) + ((cakesCovered - 50) * (0.15)));
        }
    }

    public void increaseCakes(int addCakes){
        if (addCakes > 0){
            cakesCovered += addCakes;
        }
        else {
            System.out.println("Invalid number of suitable cakes to add: " + addCakes);
        }
    }

    public void decreaseCakes(int removeCakes){
        if (removeCakes > 0){
            cakesCovered -= removeCakes * 2;
        }
        else {
            System.out.println("Invalid number of suitable cakes to remove: " + removeCakes);
        }
    }

    @Override
    public int compareTo(Employee e){
        if (e.cakesCovered - this.cakesCovered == 0){
            return this.employeeName.compareTo(e.getEmployeeName());
        }
        else {
            return e.cakesCovered - this.cakesCovered;
        }
    }

    public void display(){
        System.out.println(String.format("|   %-7s     |      %-8s |  %6s  |", this.getEmployeeName(),
                this.getCakesCovered(), money.format(this.calculateWage())));
    }
}