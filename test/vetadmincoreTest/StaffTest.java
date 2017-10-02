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
public class StaffTest {
    Hospital hospital1;
    Person person1;
    Person person2;
    Staff staff1;
    Staff staff2;
    Staff staff3;
    Staff staff4;
    
    public StaffTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hospital1 = new Hospital("Burseldon", new TreeSet(), 
                                new HashSet<>(), 5);
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        staff1 = new Staff(person1, hospital1);
        staff2 = new Staff(person2, hospital1);
        staff3 = new Staff(person2, hospital1);
        staff4 = null;
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
     * Tests equals with equal arguments.
     */
    @Test
    public void equalsEqualArgs()
    {
        assert(staff2.equals(staff3)) : "staff2 should be equal to staff3";
    }
    
    
    
    /**
     * Tests equals with unequal arguments.
     */
    @Test
    public void equalsUnequalArgs()
    {
        assertFalse("staff1 should not be equal to staff2", staff1.equals(staff2));
    }
    
    
    
    /**
     * Tests equals with a null argument.
     */
    @Test
    public void equalsNullArg()
    {
        assertFalse("staff1 should not be equal to null", staff1.equals(staff4));
    }
    
    
    
    /**
     * Tests hashCode with equal terms.
     */
    public void hashCodeEqual()
    {
        assert(staff2.hashCode() == staff3.hashCode()) : 
                "staff2 should produce the same hash as staff3";
    }
    
    
    
    /**
     * Tests hashCode with similar terms.
     */
    public void hashCodeSimilar()
    {
        person2 = person2 = new Person("Miss", "Beyonc", "Knowles", 
                                "58 Boogie Down", "beyonce@shakeyabooty.com", 
                                "94534665421");
        staff3 = new Staff(person2, hospital1);
        assert(staff2.hashCode() != staff3.hashCode());
    }
    
    
    
    /**
     * Tests compareTo with equal arguments.
     */
    @Test
    public void compareToEqualsArgs()
    {
        assert(staff2.compareTo(staff3) == 0) : "staff2 should be equal to staff3";
    }
    
    
    
    /**
     * Tests compareTo with similar arguments.
     */
    @Test
    public void compareToSimilarArgs()
    {
        person2 = person2 = new Person("Miss", "Beyonc", "Knowles", 
                                "58 Boogie Down", "beyonce@shakeyabooty.com", 
                                "94534665421");
        staff3 = new Staff(person2, hospital1);
        assert(staff2.compareTo(staff3) > 0) : "staff2 should come after staff3";
    }
    
    
    
    
    /**
     * Tests compareTo throws the correct exception with a null argument.
     */
    @Test(expected = NullPointerException.class)
    public void compareToNullArg()
    {
        staff1.compareTo(staff4);
    }
}
