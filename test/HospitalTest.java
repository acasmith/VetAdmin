/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vetadmincore.*;
import java.util.*;

/**
 * Units tests for the Hospital class.
 * @author Adam
 */
public class HospitalTest {
            Hospital hospital1;
            Hospital hospital2;
            Set<Species> set1 = new HashSet<>();
            Set<Species> set2 = new HashSet<>();
    
    public HospitalTest() {
        set1.add(Species.DOG);
        set1.add(Species.CAT);
        set2.add(Species.HORSE);
    }
    
    @BeforeClass
    public static void setUpClass() {

        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hospital1 = new Hospital("Burseldon", new HashSet(), 
                                set1, 5);
        hospital2 = new Hospital("York", new HashSet(), set2, 13);
        
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
     * Checks compare to works with two unequal objects.
     */
    @Test
    public void compareToGreaterThan()
    {
        SortedSet testSet = new TreeSet<>();
        testSet.add(hospital1);
        testSet.add(hospital2);
        assert(testSet.first() == hospital1);
    }
}
