/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxapp.presenter.MainPresenter;

/**
 *
 * @author test
 */
public class JavaFXApp extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFXApp");
        MainPresenter main = JavaFXAppFactory.getInstance().getMainPresenter();
        main.showData();
        primaryStage.setScene(new Scene(main.getView()));
        primaryStage.show();
    }
}
