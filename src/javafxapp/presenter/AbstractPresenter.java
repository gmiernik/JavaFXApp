/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.presenter;

import javafx.scene.Parent;
import javafxapp.event.EventBus;
import javafxapp.model.Service;

/**
 *
 * @author Miernik
 */
public abstract class AbstractPresenter<T extends Service> implements Presenter<T> {

    private Parent view;
    private T service;
    private EventBus eventBus;
    
    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
    
    @Override
    public T getService() {
        return service;
    }

    @Override
    public void setService(T service) {
        this.service = service;
    }

    @Override
    public void setView(Parent view) {
        this.view = view;
    }

    @Override
    public Parent getView() {
        return this.view;
    }
}
