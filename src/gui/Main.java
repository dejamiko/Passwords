package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * The main class of the password generator project.
 *
 * @author mikolajdeja
 * @version 2021.05.17
 */
public class Main extends Application {

    /**
     * Start the gui of the application.
     *
     * @param primaryStage The primary stage of the application.
     * @throws Exception Exceptions thrown by the FXMLLoader.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("passwords.fxml")));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    /**
     * Launch the gui of the application.
     *
     * @param args The arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
