/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.presenter;

import javafx.beans.property.SimpleObjectProperty;
import javafxapp.model.Person;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Miernik
 */
public class MainPresenterTest {
    
    public MainPresenterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    class PersonProperty extends SimpleObjectProperty<Person> {
        
    }
    
    @Test
    public void testSomeMethod() {
        
    }
}
