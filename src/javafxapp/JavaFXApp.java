/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

import javafx.stage.Stage;
import javafxapp.model.PersonService;
import javafxapp.model.SimplePersonService;
import javafxapp.presenter.MainPresenter;
import javafxapp.presenter.NewPersonPresenter;
import org.miernik.jfxlib.MVPApplication;
import org.miernik.jfxlib.Service;
import org.miernik.jfxlib.presenter.AbstractMainPresenter;

/**
 *
 * @author test
 */
public class JavaFXApp extends MVPApplication {

    private MainPresenter mainPresenter;
    private NewPersonPresenter newPersonPresenter;
    private PersonService service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFXApp");
        getMainPresenter().setMainView(primaryStage);
        primaryStage.show();
    }

    @Override
    public Service getService() {
        if (service == null) {
            service = new SimplePersonService();
            service.add("Jan", "Kowalski");
            service.add("Zygmunt", "Szczęśliwy");
            service.add("Ewa", "Witaj");
        }
        return service;
    }

    protected NewPersonPresenter getNewPersonPresenter() {
        if (newPersonPresenter==null) {
            newPersonPresenter = (NewPersonPresenter)load("NewPerson");
        }
        return newPersonPresenter;
    }

    @Override
    public AbstractMainPresenter getMainPresenter() {
        if (mainPresenter == null) {
            mainPresenter = (MainPresenter) load("Main");
        }
        return mainPresenter;
    }
    
    public void actionNewPerson() {
        getNewPersonPresenter().show();
    }
}
