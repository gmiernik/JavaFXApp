/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Miernik
 */
public class PersonTest {
    
    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testFirstNameLister() {
        final Person p = new Person("Janek", "Kowalski");
        final BooleanProperty result = new SimpleBooleanProperty(false);
        final String oldValue = p.getFirstName();
        final String newValue = "test123";
        p.firstNameProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                result.set(true);
                assertEquals(oldValue, arg1);
                assertEquals(newValue, arg2);
            }
        });
        p.setFirstName(newValue);
        
        assertTrue(result.get());
    }
}
