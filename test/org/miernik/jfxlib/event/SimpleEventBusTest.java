/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miernik.jfxlib.event;

import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Miernik
 */
public class SimpleEventBusTest {

    public SimpleEventBusTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testConstructor() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        assertNotNull(eventBus);
        assertNotNull(eventBus.getListenersMap());
    }

    @Test
    public void testAddListener() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final EventType type = TestEvent.ANY;
        final EventListener<TestEvent> listener = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        eventBus.addListener(TestEvent.ANY, listener);

        // check
        Map<EventType, List<EventListener>> listeners = eventBus.getListenersMap();
        assertNotNull(listeners);
        assertTrue(listeners.containsKey(type));
        assertNotNull(listeners.get(type));
        assertTrue(listeners.get(type).contains(listener));
    }

    @Test
    public void testAddListener2() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final EventType type1 = TestEvent.ANY;
        final EventType type2 = TestEvent.TEST1;
        final EventListener<TestEvent> listener = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        eventBus.addListener(type1, listener);
        eventBus.addListener(type2, listener);

        // check
        Map<EventType, List<EventListener>> listeners = eventBus.getListenersMap();
        assertNotNull(listeners);
        assertEquals(2, listeners.keySet().size());
        assertTrue(listeners.containsKey(type1));
        assertTrue(listeners.containsKey(type2));
        assertNotNull(listeners.get(type1));
        assertTrue(listeners.get(type1).contains(listener));
        assertNotNull(listeners.get(type2));
        assertTrue(listeners.get(type2).contains(listener));
    }

    @Test
    public void testAddListener3() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final EventType type = TestEvent.ANY;
        final EventListener<TestEvent> listener1 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        final EventListener<TestEvent> listener2 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        eventBus.addListener(type, listener1);
        eventBus.addListener(type, listener2);

        // check
        Map<EventType, List<EventListener>> listeners = eventBus.getListenersMap();
        assertNotNull(listeners);
        assertTrue(listeners.containsKey(type));
        assertNotNull(listeners.get(type));
        assertEquals(2, listeners.get(type).size());
        assertTrue(listeners.get(type).contains(listener1));
        assertTrue(listeners.get(type).contains(listener2));
    }

    @Test
    public void testAddListenerNullType() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final EventType type = null;
        final EventListener<TestEvent> listener1 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
            }
        };

        try {
            eventBus.addListener(type, listener1);
            fail("it allows to add null type or listener");
        } catch (IllegalArgumentException ex) {
        };

        // check
        Map<EventType, List<EventListener>> listeners = eventBus.getListenersMap();
        assertNotNull(listeners);
        assertFalse(listeners.containsKey(type));
    }

    protected class ResultListener {

        public boolean executed = false;
    }

    @Test
    public void testFireEvent() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final TestEvent event = new TestEvent();
        final EventType type = event.getType();
        final ResultListener result1 = new ResultListener();
        final ResultListener result2 = new ResultListener();
        final EventListener<TestEvent> listener1 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent arg0) {
                result1.executed = true;
            }
        };
        final EventListener<TestEvent> listener2 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent arg0) {
                result2.executed = true;
            }
        };

        eventBus.addListener(type, listener1);
        eventBus.addListener(type, listener2);

        eventBus.fireEvent(new TestEvent());

        // check
        assertTrue(result1.executed);
        assertTrue(result2.executed);
    }

    @Test
    public void testFireEvent2() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final TestEvent event1 = new TestEvent(TestEvent.TEST2);
        final EventType type1 = event1.getType();
        final TestEvent event2 = new TestEvent(TestEvent.TEST3);
        final EventType type2 = event2.getType();
        final ResultListener result1 = new ResultListener();
        final ResultListener result2 = new ResultListener();
        final EventListener<TestEvent> listener1 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent arg0) {
                result1.executed = true;
            }
        };
        final EventListener<TestEvent> listener2 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent arg0) {
                result2.executed = true;
            }
        };

        eventBus.addListener(type1, listener1);
        eventBus.addListener(type2, listener2);

        eventBus.fireEvent(event1);

        // check
        assertTrue(result1.executed);
        assertFalse(result2.executed);
    }

    @Test
    public void testRemoveListener() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final EventType type = TestEvent.TEST1;
        final EventListener<TestEvent> listener = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        eventBus.addListener(type, listener);

        eventBus.removeListener(type, listener);

        // check
        Map<EventType, List<EventListener>> listeners = eventBus.getListenersMap();
        assertNotNull(listeners);
        assertTrue(listeners.containsKey(type));
        assertNotNull(listeners.get(type));
        assertFalse(listeners.get(type).contains(listener));
    }

    @Test
    public void testRemoveListener2() {
        final SimpleEventBus eventBus = new SimpleEventBus();
        final EventType type = TestEvent.TEST1;
        final EventListener<TestEvent> listener1 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        final EventListener<TestEvent> listener2 = new EventListener<TestEvent>() {

            @Override
            public void notify(TestEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        eventBus.addListener(type, listener1);
        eventBus.addListener(type, listener2);

        eventBus.removeListener(type, listener1);

        // check
        Map<EventType, List<EventListener>> listeners = eventBus.getListenersMap();
        assertNotNull(listeners);
        assertTrue(listeners.containsKey(type));
        assertNotNull(listeners.get(type));
        assertFalse(listeners.get(type).contains(listener1));
        assertTrue(listeners.get(type).contains(listener2));
    }
}
