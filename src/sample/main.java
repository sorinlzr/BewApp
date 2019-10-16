package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bewehrung");
        primaryStage.setScene(new Scene(root, 310, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
        Image appIcon = new Image("icon.png");
        primaryStage.getIcons().add(appIcon);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
