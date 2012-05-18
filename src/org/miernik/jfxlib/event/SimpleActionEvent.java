/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miernik.jfxlib.event;

/**
 *
 * @author Miernik
 */
public class SimpleActionEvent extends Event {

    public static EventType SIMPLE_ACTION = new EventType();
    private String actionName;

    public String getActionName() {
        return actionName;
    }

    public SimpleActionEvent(String actionName) {
        super(SIMPLE_ACTION);
        this.actionName = actionName;
    }
}
