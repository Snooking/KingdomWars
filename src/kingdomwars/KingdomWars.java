/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomwars;

import GameManagement.Kingdom;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Snooking
 */
public class KingdomWars extends Application {
    
    private static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showFirstKingdomWindow();
    }

    private static void showFirstKingdomWindow() throws IOException {
        FXMLLoader loaderStats = new FXMLLoader();
        loaderStats.setLocation(KingdomWars.class.getResource("StatsWindow.fxml"));
        Parent rootStats = loaderStats.load();
        primaryStage.setTitle("First kingdom stats");
        primaryStage.setScene(new Scene(rootStats, 200, 800));
        primaryStage.show();
    }
    
    public static void showMainWindow(Kingdom kingdom) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(KingdomWars.class.getResource("MainWindow.fxml"));
        Parent root = loader.load();

        MainWindowController controller = loader.getController();
        controller.setKingdom(kingdom);
        controller.startSimulation();
        
        primaryStage.setTitle("Kingdom Wars");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
