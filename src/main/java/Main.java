import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root, 650, 500);
        String css = this.getClass().getResource("Tabpane.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Nolan Birmingham Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
