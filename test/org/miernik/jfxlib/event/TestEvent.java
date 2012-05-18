/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miernik.jfxlib.event;

/**
 *
 * @author Miernik
 */
public class TestEvent extends Event {

    public static EventType TEST1 = new EventType();
    public static EventType TEST2 = new EventType();
    public static EventType TEST3 = new EventType();
    
    public TestEvent() {
        super(TEST1);
    }

    public TestEvent(EventType type) {
        super(type);
    }
        
}
