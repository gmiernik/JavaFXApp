/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.presenter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafxapp.event.NewPersonEvent;
import javafxapp.model.Person;
import javafxapp.model.PersonService;
import org.miernik.jfxlib.event.EventListener;
import org.miernik.jfxlib.presenter.AbstractMainPresenter;

/**
 *
 * @author Miernik
 */
public class MainPresenter extends AbstractMainPresenter<PersonService> implements Initializable {

    @FXML
    private Label numberField;
    @FXML
    private Button btnNew;
    @FXML
    private TableView<Person> mainTable;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnNew.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                fireAction("NewPerson");
            }
        });
    }

    @Override
    protected void refresh() {
        final List<Person> list = getService().getPersonList();
        numberField.setText(Integer.toString(list.size()));
    }

    @Override
    public void show() {
        final List<Person> list = getService().getPersonList();
        numberField.setText(Integer.toString(list.size()));
        mainTable.setItems(FXCollections.observableList(list));
        getEventBus().addListener(NewPersonEvent.NEW_PERSON, new EventListener() {

            @Override
            public void notify(org.miernik.jfxlib.event.Event e) {
                refresh();
            }
        });
    }
}
