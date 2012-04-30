/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.presenter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafxapp.event.EventListener;
import javafxapp.event.NewPersonEvent;
import javafxapp.model.Person;
import javafxapp.model.PersonService;

/**
 *
 * @author Miernik
 */
public class MainPresenter extends AbstractPresenter<PersonService> implements Initializable {

    @FXML
    private Label numberField;
    @FXML
    private Button btnNew;
    @FXML
    private TableView<Person> mainTable;
    @FXML private TableColumn<Person, String> lastNameColumn;
    private NewPersonPresenter newPersonPresenter;
    private ObservableList<Person> data;

    public NewPersonPresenter getNewPersonPresenter() {
        return newPersonPresenter;
    }

    public void setNewPersonPresenter(NewPersonPresenter newPersonPresenter) {
        this.newPersonPresenter = newPersonPresenter;
        getEventBus().addListener(NewPersonEvent.NEW_PERSON, new EventListener<NewPersonEvent>() {
            @Override
            public void notify(NewPersonEvent arg0) {
                showData();
            }
        });
    }
        
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnNew.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent arg0) {
                showNewPersonView();
            }
        });
    }
    
    public void showData() {
        List<Person> list = getService().getPersonList();
        numberField.setText(Integer.toString(list.size()));
        mainTable.setItems(FXCollections.observableList(list));
    }
    
    public void showNewPersonView() {
        newPersonPresenter.showModal();
    }

}
