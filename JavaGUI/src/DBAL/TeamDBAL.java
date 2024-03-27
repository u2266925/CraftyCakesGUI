package DBAL;

import Assets.DBUtils;
import Model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class TeamDBAL {
    private DBUtils dbu = new DBUtils();
    private ArrayList<Employee> employees =  new ArrayList<>();


    public TeamDBAL() throws SQLException {
        readAllEmployees();
    }

    public void readAllEmployees() throws SQLException {
        Connection conn = getConnection("your-connection-string", "your-user-name", "your-password");
        //get employees from db and add to arraylist
        String query = "SELECT * FROM employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            this.employees.add(new Employee(rs.getString("name"), rs.getInt("cakes_covered")));
        }
        stmt.close();
        conn.close();
    }

    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }
}