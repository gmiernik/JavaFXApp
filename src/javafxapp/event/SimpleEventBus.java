/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.event;

import java.util.*;

/**
 *
 * @author Miernik
 */
public class SimpleEventBus implements EventBus {

    private Map<EventType, List<EventListener>> listenersMap;

    protected Map<EventType, List<javafxapp.event.EventListener>> getListenersMap() {
        return listenersMap;
    }
    
    public SimpleEventBus() {
        listenersMap = new HashMap<>();
    }

    @Override
    public void addListener(EventType type, EventListener listener) {
        if (!listenersMap.containsKey(type)) {
            listenersMap.put(type, new ArrayList<EventListener>());
        }
        List<EventListener> handlers = listenersMap.get(type);
        if (!handlers.contains(listener)) {
            handlers.add(listener);
        }
    }

    @Override
    public void fireEvent(Event event) {
        if (listenersMap.containsKey(event.getType())) {
            List<EventListener> listeners = listenersMap.get(event.getType());
            for (Iterator<EventListener> it = listeners.iterator(); it.hasNext();) {
                EventListener eventHandler = it.next();
                eventHandler.notify(event);
            }
        }
    }

    @Override
    public void removeListener(EventType type, javafxapp.event.EventListener listener) {
        if (listenersMap.containsKey(type)) {
            List<EventListener> listeners = listenersMap.get(type);
            if (listeners.contains(listener))
                listeners.remove(listener);
        }
    }
}
