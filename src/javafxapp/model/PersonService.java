/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model;

import java.util.List;

/**
 *
 * @author Miernik
 */
public interface PersonService extends Service {
    Person add(String firstName, String lastName);
    List<Person> getAll();
    List<Person> getPersonList();
    boolean remove(Person person);
    void refresh();
}
