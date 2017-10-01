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

/**
 *
 * @author Adam
 */
public class PersonTest {
    
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person3 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person4 = null;
    }
    
    @After
    public void tearDown() {
    }

  
    //*****Tests*****
    
    
    /**
     * Tests equals with two unequal arguments.
     */
    @Test
    public void equalsUnequalArgs()
    {
        assertFalse("person1 should not be equals to person 2", 
                        person1.equals(person2));
    }
    
    
    
    
    /**
     * Tests equals with equal arguments.
     */
    @Test
    public void equalsEqualArgs()
    {
        assert(person2.equals(person3)) : "person2 should not be equal to person3";
    }
    
    
    
    
    @Test
    public void equalsDifferentClass()
    {
        assertFalse("person1 should not be equal to a StringBuilder object.", 
                        person1.equals(new StringBuilder()));
    }
    
    
    
    
    /**
     * Tests equals with null argument.
     */
    @Test
    public void equalsNullArg()
    {
        assertFalse("person1 should not be equal with null", person1.equals(person2));
    }
    
    
    
    
    /**
     * Test that hashCode is the same for equal objects.
     */
    @Test
    public void hashCodeEqualArgs()
    {
        assert(person2.equals(person3)) : "person2 should be equal to person 3";
        assert(person2.hashCode() == person3.hashCode());
    }
    
    
    
    
    /**
     * Test that hashCode is not the same for similar arguments.
     */
    @Test
    public void hashCodeSimilarArgs()
    {
        person3 = new Person("Miss", "Beyonc", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        assert(person2.hashCode() != person3.hashCode()) : 
                "person2 hashCode should not be equal to person3 hashCode.";
    }
    
    
    
    
    /**
     * Tests that compareTo works for equal arguments.
     */
    @Test
    public void compareToEqualsArgs()
    {
        assert(person2.compareTo(person3) == 0) : 
                "person2 should be equal to person3";
    }
    
   
    
    
    /**
     * Test that compareTo works for unequal arguments.
     */
    @Test
    public void compareToUnequalArgs()
    {
        assert(person1.compareTo(person2) < 0) : 
                "person1 should come after person 2.";
    }
    
    
    
    
    /**
     * Test that compareTo works for similar arguments.
     */
    @Test
    public void compareToSimilarArgs()
    {
        person3 = new Person("Miss", "Beyonce", "Knowle", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        assert(person2.compareTo(person3) > 0) : 
                "person2 should come after person 3.";
    }
    
    
    
    
    /**
     * Test that the correct exception is thrown when comparing against a null 
     * argument.
     */
    @Test(expected = NullPointerException.class)
    public void compareToNull()
    {
        person1.compareTo(person4);
    }
    
    
    
}
