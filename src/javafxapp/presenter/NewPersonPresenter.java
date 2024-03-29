/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.presenter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxapp.event.NewPersonEvent;
import javafxapp.model.Person;
import javafxapp.model.PersonService;
import org.miernik.jfxlib.presenter.AbstractPresenter;

/**
 *
 * @author Miernik
 */
public class NewPersonPresenter extends AbstractPresenter<PersonService> implements Initializable {

    private Stage window;
    @FXML private Button btnSave;
    @FXML private Button btnCancel;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;

    @Override
    public void show() {
        if (window == null) {
            window = new Stage();
            window.setTitle("New person");
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(new Scene(getView()));
        }
        firstNameField.setText(null);
        lastNameField.setText(null);
        window.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnSave.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                save();
            }
            
        });
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                cancel();
            }
        });
    }
    
    protected void save() {
        Person p = getService().add(firstNameField.getText(), lastNameField.getText());
        getEventBus().fireEvent(new NewPersonEvent(p));
        window.close();
    }
    
    protected void cancel() {
        getService().refresh();
        window.close();
    }

}
