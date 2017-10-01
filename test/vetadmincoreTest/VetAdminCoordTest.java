/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincoreTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vetadmincore.*;
import java.util.*;

/**
 *
 * @author Adam
 */
public class VetAdminCoordTest {
    
    VetAdminCoord admin1;
    
    
    
    public VetAdminCoordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    
    /**
     * Checks that only one VetAdminCoord is ever in existence.
     */
    @Test
    public void getVetAdminCoordTest()
    {
        VetAdminCoord vetAdmin = VetAdminCoord.getVetAdminCoord();
        assert(vetAdmin == VetAdminCoord.getVetAdminCoord()) : 
                "vetAdmin should share identity with the returned object.";
        
    }
    
    
    
    

}
