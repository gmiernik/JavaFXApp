/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafxapp.event.EventBus;
import javafxapp.event.SimpleEventBus;
import javafxapp.model.PersonService;
import javafxapp.model.SimplePersonService;
import javafxapp.presenter.MainPresenter;
import javafxapp.presenter.NewPersonPresenter;
import javafxapp.presenter.Presenter;

/**
 *
 * @author Miernik
 */
public class JavaFXAppFactory {

    private static JavaFXAppFactory instance;
    private MainPresenter mainPresenter;
    private PersonService personService;
    private NewPersonPresenter newPersonPresenter;
    private EventBus eventBus;

    public EventBus getEventBus() {
        if (eventBus==null)
            eventBus = new SimpleEventBus();
        return eventBus;
    }

    public static JavaFXAppFactory getInstance() {
        if (instance == null) {
            instance = new JavaFXAppFactory();
        }
        return instance;
    }

    protected <T extends Presenter> T load(String fxmlFile) {
        T presenter = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.load(MainPresenter.class.getResourceAsStream("../view/" + fxmlFile));
            presenter = (T) loader.getController();
            presenter.setView((Parent) loader.getRoot());
            presenter.setService(getPersonService());
            presenter.setEventBus(getEventBus());
        } catch (Exception ex) {
            throw new RuntimeException("Unable to load " + fxmlFile, ex);
        }
        return presenter;
    }

    public MainPresenter getMainPresenter() {
        if (mainPresenter==null) {
            mainPresenter = (MainPresenter)load("Main.fxml");
            mainPresenter.setNewPersonPresenter(getNewPersonPresenter());
        }
        return mainPresenter;
    }

    public PersonService getPersonService() {
        if (personService == null) {
            personService = new SimplePersonService();
            personService.add("Jan", "Kowalski");
            personService.add("Zygmunt", "Szczęśliwy");
            personService.add("Ewa", "Witaj");
        }
        return personService;
    }

    public NewPersonPresenter getNewPersonPresenter() {
        if (newPersonPresenter == null) {
            newPersonPresenter = (NewPersonPresenter)load("NewPerson.fxml");
        }
        return newPersonPresenter;
    }
}
