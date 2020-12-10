import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**

 * Controller for the program.

 * Calls program essential functions and formats everything.

 * @author Nolan Birmingham

 */
public class Controller {

    /**

     * The produce tab.

     */
    @FXML
    private Tab ProduceTab;
    /**

     * Button used to record production.

     */
    @FXML
    private Button recordProduction;
    /**

     * Tab for the product line.

     */
    @FXML
    private Tab ProductLineTab;
    /**

     * Button to add product to the records.

     */
    @FXML
    private Button addProduct;
    /**

     * Tab for the production log.

     */
    @FXML
    private Tab ProductionLogTab;
    /**

     * Combobox quantity picker.

     */
    @FXML
    private ComboBox<String> cmbQuantity;
    /**

     * Label to output text.

     */
    @FXML
    private Label lblOutput;
    /**

     * Text field.

     */
    @FXML
    private TextField productName;
    /**

     * Text field.

     */
    @FXML
    private TextField manufacturerName;
    /**

     * Choice box for a type.

     */
    @FXML
    private ChoiceBox<String> cmbType;
    /**

     * Tableview for production record.

     */
    @FXML
    private TableView<Widget> tableview;
    /**

     * Table column that holds the item type.

     */
    @FXML
    private TableColumn itemType;
    /**

     * Table column that holds the manufacturer.

     */
    @FXML
    private TableColumn manufacturer;
    /**

     * Table column that holds the product name.

     */
    @FXML
    private TableColumn prodName;
    /**

     * Table column that holds the product id.

     */
    @FXML
    private TableColumn productID;
    /**

     * Listview to display the produced items.

     */
    @FXML
    private ListView produceList;
    /**

     * A list.

     */
    @FXML
    public List list;
    /**

     * Text area in the GUI.

     */
    @FXML
    private TextArea textArea;

    /**

     * Initializes the gui and sets essential elements to start.

     */
    public void initialize(){
        //Population of the combo box upon program startup
        cmbQuantity.setEditable(true);
        for(int i=1;i<=10;i++){
            cmbQuantity.getItems().add(String.valueOf(i));
        }
        cmbQuantity.getSelectionModel().selectFirst();
        cmbType.getSelectionModel().selectFirst();
        cmbType.getItems().add(String.valueOf("AUDIO"));
        cmbType.getItems().add(String.valueOf("VIDEO"));
        cmbType.getItems().add(String.valueOf("ELECTRICAL"));
        // Call to set up multimedia controls
        testMultimedia();
        // ObservableList Creation
        ObservableList<Widget> one = setupProductLine();
        productID.setCellValueFactory(new PropertyValueFactory("id"));
        prodName.setCellValueFactory(new PropertyValueFactory("Name"));
        manufacturer.setCellValueFactory(new PropertyValueFactory("Manufacturer"));
        itemType.setCellValueFactory(new PropertyValueFactory("type"));
        tableview.setItems(one);



        produceList.getItems().addAll("Name: iPhone" + "\n Manufacturer: Apple" + "\nType: " + ItemType.VISUAL, "Name: Pixel 3" + "\n Manufacturer: Google" + "\nType: " + ItemType.VISUAL);

    }

    /**

     * called upon recording of a product that will connect the program to the database.

     */
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

    /**

     * Multimedia Function non essential to program.

     */
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

    /**

     * Sets the product line in the program.

     */
    public static ObservableList<Widget> setupProductLine() {
        String recordProduction;
        return FXCollections.observableArrayList(
                new Widget("iPhone","Apple", ItemType.VISUAL),
                new Widget("AirPods","Apple",ItemType.AUDIO),
                new Widget("Solo", "Beats",ItemType.AUDIO),
                new Widget("DS", "Nintendo",ItemType.VISUAL_MOBILE),
                new Widget("test", "test",ItemType.AUDIO_MOBILE));
    }

    /**

     * Button handling method to record production upon use.

     */
    public void recordProductionDisplay(javafx.event.ActionEvent actionEvent) {

        String textAreaString = "";

        var listOfItems = produceList.getSelectionModel().getSelectedItems();

        for(Object item : listOfItems){
            textAreaString += String.format("%s%n", (String) item);
        }
        textArea.setText(textAreaString);
    }

    /**

     * Button handling method to add a product upon use.

     */
    public void addProduct(javafx.event.ActionEvent actionEvent) {

        connectToDb();
    }
}

