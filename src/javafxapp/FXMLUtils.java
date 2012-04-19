/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Miernik
 */
public class FXMLUtils {
    
    /**
     * Loading FXML file and creating new window
     * @param ctrlClass Controller class
     * @return Stage object which has loaded Parent from FXML file
     */
    public static Stage loadStage(Class<? extends Initializable> ctrlClass) {
        Stage stage = null;
        try {
            Parent root = FXMLLoader.load(ctrlClass.getResource(ctrlClass.getSimpleName() + ".fxml"));
            stage = new Stage();
            stage.setScene(new Scene(root));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return stage;
    }
}
