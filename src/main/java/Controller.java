import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private ComboBox<String> cmbQuantity;

    @FXML
    private Label lblOutput;

    @FXML
    private TextField productName;

    @FXML
    private TextField manufacturerName;

    @FXML
    private ChoiceBox<String> cmbType;

    public void sayHello() {
        lblOutput.setText("Hello FXML!");


    }

    public void initialize(){
        //connectToDb();
        cmbQuantity.setEditable(true);
        for(int i=1;i<=10;i++){
            cmbQuantity.getItems().add(String.valueOf(i));
        }
        cmbQuantity.getSelectionModel().selectFirst();
        cmbType.getSelectionModel().selectFirst();
        cmbType.getItems().add(String.valueOf("AUDIO"));
        cmbType.getItems().add(String.valueOf("VIDEO"));
        cmbType.getItems().add(String.valueOf("ELECTRICAL"));
    }

    public void connectToDb(){
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
            String productNameData = productName.getText();
            String manufacturerNameData = manufacturerName.getText();
            String productType = cmbType.getValue();
            String insertSql = "INSERT INTO PRODUCT (NAME, TYPE, MANUFACTURER)" +
            "VALUES ('" + productNameData + "','" + productType + "','" + manufacturerNameData + "')";
            stmt.executeUpdate(insertSql);


            String sql = "SELECT * FROM PRODUCT";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getString(1));
                System.out.println("Product Name: " + rs.getString(2));
                System.out.println("Product Type: " + rs.getString(3));
                System.out.println("Product Manufacturer: " + rs.getString(4));


            }

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

        connectToDb();
    }
}

