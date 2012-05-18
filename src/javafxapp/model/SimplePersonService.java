/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miernik
 */
public class SimplePersonService implements PersonService {

    private List<Person> list = new ArrayList<>();

    @Override
    public Person add(String firstName, String lastName) {
        Person p = new Person(firstName, lastName);
        list.add(p);
        return p;
    }

    @Override
    public List<Person> getPersonList() {
        return list;
    }

    @Override
    public boolean remove(Person person) {
        return list.remove(person);
    }

    @Override
    public void refresh() {
        list.clear();
        List<Person> newList = new ArrayList<>();
        newList.add(new Person("Jan", "Kowalski"));
        newList.add(new Person("Zygmunt", "Szczęśliwy"));
        newList.add(new Person("Nowy", "Person"));
        newList.add(new Person("Ewa", "Witaj"));
        list.addAll(newList);
    }
}
