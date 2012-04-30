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
public interface Presenter<T extends Service> {
    Parent getView();
    void setView(Parent root);
    EventBus getEventBus();
    void setEventBus(EventBus eventBus);
    T getService();
    void setService(T service);
}
