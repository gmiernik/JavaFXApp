/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.event;

/**
 *
 * @author Miernik
 */
public class NewPersonEvent extends Event {
    public static EventType<NewPersonEvent> NEW_PERSON;

    public NewPersonEvent() {
        super(NEW_PERSON);
    }
    
    
}
