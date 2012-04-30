/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.event;

/**
 *
 * @author Miernik
 */
public class TestEvent extends Event {

    public static EventType<TestEvent> TEST1 = new EventType<>();
    public static EventType<TestEvent> TEST2;
    
    public TestEvent() {
        super(TEST1);
    }

    public TestEvent(EventType type) {
        super(type);
    }
        
}
