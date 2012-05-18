/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miernik.jfxlib;

import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.miernik.jfxlib.event.SimpleActionEvent;
import org.miernik.jfxlib.presenter.AbstractMainPresenter;

/**
 *
 * @author Miernik
 */
public class MVPApplicationTest {
    
    public MVPApplicationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    public class TestApp extends MVPApplication {

        @Override
        public Service getService() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public AbstractMainPresenter getMainPresenter() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void start(Stage arg0) throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        public void actionTest123() {
            
        }
    }
    
    @Test
    public void testSimpleAction() {
        final TestApp app = new TestApp();
        final String actionName = "Test123";
        final SimpleActionEvent sae = new SimpleActionEvent(actionName);
        
        app.getEventBus().fireEvent(sae);
    }
}
