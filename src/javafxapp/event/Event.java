/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.event;

/**
 *
 * @author Miernik
 */
public class Event  {
    public static EventType<Event> ANY = new EventType();
    private EventType type;

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }    
    
}
