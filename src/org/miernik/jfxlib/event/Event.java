/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miernik.jfxlib.event;

/**
 *
 * @author Miernik
 */
public class Event  {
    public static EventType ANY = new EventType();
    private EventType type;

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }    
    
}
