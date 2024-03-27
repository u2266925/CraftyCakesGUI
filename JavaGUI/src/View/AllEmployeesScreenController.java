package View;


import Assets.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Model.Employee;
import Controller.Team;

import java.io.IOException;
import java.sql.SQLException;

public class AllEmployeesScreenController {

    // Holds this controller's Stage
    private final Stage thisStage;
    private Team team;
    @FXML
    private TableView<Employee> tblEmployees;

    private Utils utils = new Utils();

    // Define the nodes from the AllEmployeesScreen.fxml file. This allows them to be referenced within the controller


    public AllEmployeesScreenController() throws SQLException {

        // Create the new stage
        thisStage = new Stage();
        this.team = new Team();

        // Load the FXML file into the loader
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AllEmployeesScreen.fxml"));

            // Set this instance as the controller for the loader which contains the screen
            loader.setController(this);

            // set the scene
            thisStage.setScene(new Scene(loader.load()));

            // Setup the window/stage
            thisStage.setTitle("All Employees");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.show();
    }

    /**
     * The initialize() method allows you set setup your scene, adding actions, configuring nodes, etc.
     */
    @FXML
    private void initialize() {

        TableColumn<Employee, String> colName = new TableColumn<>("Name");
        colName.setMinWidth(200);
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, Double> colCakes = new TableColumn<>("Cakes Covered");
        colCakes.setMinWidth(200);
        colCakes.setCellValueFactory(new PropertyValueFactory<>("cakesCovered"));



        this.tblEmployees.setItems(team.getTeamAsOAL());
        this.tblEmployees.getColumns().addAll(colName, colCakes);

    }
}
