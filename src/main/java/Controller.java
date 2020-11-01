import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @FXML
    private TableView<Widget> tableview;

    @FXML
    private TableColumn itemtype;

    @FXML
    private TableColumn manufacturer;

    @FXML
    private TableColumn prodname;

    @FXML
    private TableColumn productid;

    @FXML
    private ListView producelist;

    @FXML
    public List list;

    @FXML
    private TextArea textArea;


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

        testMultimedia();

        ObservableList<Widget> one = setupProductLine();
        productid.setCellValueFactory(new PropertyValueFactory("id"));
        prodname.setCellValueFactory(new PropertyValueFactory("Name"));
        manufacturer.setCellValueFactory(new PropertyValueFactory("Manufacturer"));
        itemtype.setCellValueFactory(new PropertyValueFactory("type"));
        tableview.setItems(one);

        producelist.getItems().addAll("Name: iPhone" + "\n Manufacturer: Apple" + "\nType: " + ItemType.VISUAL, "Name: Pixel 3" + "\n Manufacturer: Google" + "\nType: " + ItemType.VISUAL);

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

    //ObservableList<Product> productLine = FXCollections.observableList(new Product(txtProductName.getText()),
    //txtManufacturer.getText(), chbItemType.getValue());

    public static void testMultimedia() {

        AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",

                "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");

        Screen newScreen = new Screen("720x480", 40, 22);

        MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,

                MonitorType.LCD);

        ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();

        productList.add(newAudioProduct);

        productList.add(newMovieProduct);


        for (MultimediaControl p : productList) {

            System.out.println(p);

            p.play();

            p.stop();

            p.next();

            p.previous();

        }

    }

    public static ObservableList<Widget> setupProductLine() {
        return FXCollections.observableArrayList(
                new Widget("iPhone","Apple", ItemType.VISUAL),
                new Widget("AirPods","Apple",ItemType.AUDIO),
                new Widget("Solo", "Beats",ItemType.AUDIO),
                new Widget("DS", "Nintendo",ItemType.VISUAL_MOBILE),
                new Widget("test", "test",ItemType.AUDIO_MOBILE));
    }

    public void recordproductiondisplay(javafx.event.ActionEvent actionEvent) {

        String textAreaString = "";

        ObservableList listOfItems = producelist.getSelectionModel().getSelectedItems();

        for(Object item : listOfItems){
            textAreaString += String.format("%s%n", (String) item);
        }
        textArea.setText(textAreaString);
    }

    public void addproduct(javafx.event.ActionEvent actionEvent) {

        connectToDb();
    }
}

