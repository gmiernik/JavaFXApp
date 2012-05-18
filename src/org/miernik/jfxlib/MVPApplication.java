/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miernik.jfxlib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.miernik.jfxlib.event.Event;
import org.miernik.jfxlib.event.EventBus;
import org.miernik.jfxlib.event.EventListener;
import org.miernik.jfxlib.event.SimpleActionEvent;
import org.miernik.jfxlib.event.SimpleEventBus;
import org.miernik.jfxlib.presenter.AbstractMainPresenter;
import org.miernik.jfxlib.presenter.AbstractPresenter;

/**
 *
 * @author Miernik
 */
public abstract class MVPApplication extends Application implements EventListener<SimpleActionEvent> {

    private EventBus eventBus;

    public EventBus getEventBus() {
        return eventBus;
    }

    public abstract Service getService();

    public abstract AbstractMainPresenter getMainPresenter();

    public MVPApplication() {
        super();
        this.eventBus = new SimpleEventBus();
        eventBus.addListener(SimpleActionEvent.SIMPLE_ACTION, this);
    }

    @Override
    public void notify(SimpleActionEvent e) {
        try {
            Method result = this.getClass().getMethod("action" + e.getActionName(), new Class[]{});
            if (result != null) {
                result.invoke(this, new Object[]{});
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new IllegalArgumentException("cannot find proper method to deal with action: " + e.getActionName(), ex);
        }
    }

    public void actionCloseApp() {
        System.out.println("actionCloseApp");
    }

    protected <T extends AbstractPresenter> T load(String fxmlName) {
        return load(fxmlName, false);
    }

    protected <T extends AbstractPresenter> T load(String fxmlName, boolean bundle) {
        if (bundle) {
            return load(fxmlName, ResourceBundle.getBundle(this.getClass().getPackage().getName()
                    + ".view." + fxmlName));
        } else {
            return load(fxmlName, null);
        }
    }

    /**
     *
     * @param <T> type of Presenter
     * @param fxmlFile name of FXML file
     * @param bundle resource bundle including texts
     * @return
     */
    protected <T extends AbstractPresenter> T load(String fxmlName, ResourceBundle bundle) {
        T presenter = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            if (bundle != null) {
                loader.setResources(bundle);
            }
            loader.load(this.getClass().getResourceAsStream("./view/" + fxmlName + ".fxml"));
            presenter = (T) loader.getController();
            presenter.setView((Parent) loader.getRoot());
            presenter.setService(getService());
            presenter.setEventBus(getEventBus());
        } catch (Exception ex) {
            throw new RuntimeException("Unable to load FXML: " + fxmlName, ex);
        }
        return presenter;
    }
}
