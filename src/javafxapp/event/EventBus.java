/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.event;

/**
 *
 * @author Miernik
 */
public interface EventBus {
    public void addListener(EventType type, EventListener listener);
    public void removeListener(EventType type, EventListener listener);
    public void fireEvent(Event event);
}
