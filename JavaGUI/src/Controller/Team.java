package Controller;

import DBAL.TeamDBAL;
import Model.Employee;
import Model.QualityControl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Team {

    private ArrayList<Employee> team;
    private TeamDBAL teamDBAL = new TeamDBAL(); //instance of TeamDBAL

    public Team() throws SQLException {
        this.team = teamDBAL.getEmployees(); //call the method to get all employees from TeamDBAL
    }

    public ArrayList<Employee> getTeams() {
        return team;
    }

    public void addEmployee(Employee e){
        team.add(e);
    }

    public void printTableHeader(){
        System.out.println("____________________________________________");
        System.out.println("|    EMPLOYEE   | CAKES COVERED |   WAGES  |");
        System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾|");
    }

    public void printTable(){
        for (Employee e : team){
            if (e instanceof QualityControl){
                e.display();
            } else {
                e.display();
            }
        }
    }

    public void printTableFooter(){
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }

    public double getTotalWages(){
        double total = 0;
        for (Employee e : team){
            total += e.calculateWage();
        }
        return total;
    }

    public int getTotalCakesCovered(){
        int total = 0;
        for (Employee e : team){
            total += e.getCakesCovered();
        }
        return total;
    }

    public void sortTeam(){
        Collections.sort(team);
    }
}