package vetadmincoreTest;

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
            Hospital hospital3;
            Hospital hospital4;
            Set<Species> set1 = new HashSet<>();
            Set<Species> set2 = new HashSet<>();
            Set testSet;
            SortedSet testSortedSet;
    
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
        hospital3 = new Hospital("York", new HashSet(), set2, 13);
        hospital4 = null;
        testSet = new HashSet();
        testSortedSet = new TreeSet<>();
        
    }
    
    @After
    public void tearDown() {
    }

    //*******Tests*******
    
    
    /**
     * Checks equals works with two equal objects.
     */
    @Test
    public void equalsEqualArgs()
    {
        assert(hospital2.equals(hospital3)) : "hospital2 should be equal to hospital 3.";
    }
    
    
    
    /**
     * Checks equals works with two unequal objects.
     */
    @Test
    public void equalUnequalArgs()
    {
        assertFalse("hospital2 should not be equal to hospital1.", hospital2.equals(hospital1));
    }
    
    
    
    /**
     * Checks equals functions correctly with a null argument.
     */
    @Test
    public void equalNullArg()
    {
        assertFalse("hospital1 should not be equal to null", hospital1.equals(hospital4));
    }
    
    
    
    /**
     * Testing hashcode with equal arguments.
     * 
     */
    @Test
    public void hashCodeEqualArgs()
    {
        testSet.add(hospital2);
        testSet.add(hospital3);
        assert(hospital2.hashCode() == hospital3.hashCode());
        assert(testSet.size() == 1);
    }
    
    
    
    /**
     * Testing hashcode with the similar objects.
     */
    @Test
    public void hashCodeSimilarArgs()
    {
        hospital3 = new Hospital("Yor", new HashSet(), set2, 13);
        assert(hospital2.hashCode() != hospital3.hashCode()) : 
                "hospital2 hashCode should not be equal to hospital3";
                    
    }
    
    
    
    /**
     * Checks compareTo and equals by comparing equal objects.
     */
    @Test
    public void compareToEquals()
    {
        assert(hospital2.compareTo(hospital3) == 0) : 
                "hospital2 should be equal to hospital3";
    }
    
    
    
    /**
     * Checks compareTo works with two unequal objects.
     */
    @Test
    public void compareToGreaterThan()
    {
        assert(hospital1.compareTo(hospital2) < 0) : 
                "hospital1 should comer before hospital2";
    }
    
    
    
    /**
     * Checks compareTo works with two similar objects.
     */
    @Test
    public void compareToSimilarArgs()
    {
        hospital3 = new Hospital("Yor", new HashSet(), set2, 13);
        assert(hospital3.compareTo(hospital2) < 0) : 
                "hospital3 should come before hospital 2.";
    }
    
    
    
    /**
      Checks that the correct exception is thrown by compareTo.
    */
    @Test(expected = NullPointerException.class)
    public void compareToNull()
    {
        hospital1.compareTo(hospital4);
    }
}
