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
public class OwnerTest {
    Set<Species> set1;
    Hospital hospital1;
    Person person1;
    Person person2;
    Person person3;
    Owner owner1;
    Owner owner2;
    Owner owner3;
    Owner owner4;
    
    
    public OwnerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        set1 = new HashSet<>();
        set1.add(Species.DOG);
        set1.add(Species.CAT);
        hospital1 = new Hospital("Burseldon", new HashSet(), 
                                set1, 5);
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person3 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        owner1 = new Owner(hospital1, person1, false);
        owner2 = new Owner(hospital1, person2, true);
        owner3 = new Owner(hospital1, person3, true);
        owner4 = null;
    }
    
    @After
    public void tearDown() {
    }

    
    //*****Tests*****
    
    
    /**
     * Checks that equals works with equal objects.
     */
    @Test
    public void equalsEqualArgs()
    {
        assert(person2.equals(person3)) : "person2 should be equal to person3";
    }
    
    
    
    
    /**
     * Checks that equals works with unequal objects.
     */
    @Test
    public void equalsUnequalArgs()
    {
        assertFalse("person 1 should not be equal to person2", 
                        person1.equals(person2));
    }
    
    
    
    
    /**
     * Checks that equals works with null argument.
     */
    @Test
    public void equalsNull()
    {
        assertFalse("owner1 should nopt be equal to null", owner1.equals(owner4));
    }
    
    
    
    
    /**
     * Checks that the same hashCode is produced for equal objects.
     */
    @Test
    public void hashCodeEqualArgs()
    {
        assert(owner2.hashCode() == owner3.hashCode()) : 
                "owner2's hashCode should be the same as owner3's.";
    }
    
    
    
    
    /**
     * Checks that a different hashCode is produced for similar objects.
     */
    @Test
    public void hashCodeSimilarArgs()
    {
         person3 = new Person("Miss", "Beyonc", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
         owner3 = new Owner(hospital1, person3, true);
        assert(owner2.hashCode() != owner3.hashCode()) : 
                "owner2 should have a different hashCode to owner3";
    }
    
    
    
    
     /**
     * Tests that compareTo works for equal arguments.
     */
    @Test
    public void compareToEqualsArgs()
    {
        assert(owner2.compareTo(owner3) == 0) : 
                "owner2 should be equal to owner3";
    }
    
   
    
    
    /**
     * Test that compareTo works for unequal arguments.
     */
    @Test
    public void compareToUnequalArgs()
    {
        assert(owner1.compareTo(owner2) < 0) : 
                "owner1 should come after owner2.";
    }
    
    
    
    
    /**
     * Test that compareTo works for similar arguments.
     */
    @Test
    public void compareToSimilarArgs()
    {
        person3 = new Person("Miss", "Beyonce", "Knowle", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        owner3 = new Owner(hospital1, person3, true);
        assert(owner2.compareTo(owner3) > 0) : 
                "owner2 should come after owner3.";
    }
    
    
    
    
    /**
     * Test that the correct exception is thrown when comparing against a null 
     * argument.
     */
    @Test(expected = NullPointerException.class)
    public void compareToNull()
    {
        owner1.compareTo(owner4);
    }
}
