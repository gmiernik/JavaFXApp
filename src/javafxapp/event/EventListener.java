/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.event;

/**
 *
 * @author Miernik
 */
public interface EventListener<T extends Event> extends java.util.EventListener {
    void notify(T e);
}
