/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.event;

import javafxapp.model.Person;
import org.miernik.jfxlib.event.Event;
import org.miernik.jfxlib.event.EventType;

/**
 *
 * @author Miernik
 */
public class NewPersonEvent extends Event {
    public static EventType NEW_PERSON = new EventType();

    public NewPersonEvent(Person p) {
        super(NEW_PERSON);
    }
    
    
}
