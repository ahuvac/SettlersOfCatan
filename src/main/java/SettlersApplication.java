import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SettlersApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/settlers_application.fxml"));
        Scene scene = new Scene(root, 1000, 1000);
        stage.setTitle("Settlers of Catan");
        stage.setScene(scene);
        stage.show();
    }
        public static void main(String[] args) {
            launch(args);
        }
    }

