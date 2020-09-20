import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

import java.sql.*;

public class Controller {

    @FXML
    private Tab ProduceTab;

    @FXML
    private Button recordproduction;

    @FXML
    private Tab ProductLineTab;

    @FXML
    private Button addproduct;

    @FXML
    private Tab ProductionLogTab;

    @FXML
    private Label lblOutput;

    public void sayHello() {
        lblOutput.setText("Hello FXML!");

    }

    public void initialize(){
        connectToDb();
    }

    public static void connectToDb(){
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/HR";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();


            //String sql = "SELECT * FROM PRODUCTS";

            //ResultSet rs = stmt.executeQuery(sql);
            //while (rs.next()) {
                //System.out.println(rs.getString(1));


            //}

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void recordproductiondisplay(javafx.event.ActionEvent actionEvent) {

        System.out.println("Hello");
    }

    public void addproduct(javafx.event.ActionEvent actionEvent) {
        System.out.println("Hello");
    }
}

