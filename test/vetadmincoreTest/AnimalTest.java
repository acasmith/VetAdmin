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
public class AnimalTest {
    Set set1 = new HashSet();
    Hospital hospital1;
    Hospital hospital2;
    Person person1;
    Person person2;
    Person person3;
    Owner owner1;
    Owner owner2;
    Animal animal1;
    Animal animal2;
    Animal animal3;
    Animal animal4;
    
    public AnimalTest() {
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
                                set1, 5);
        hospital2 = new Hospital("York", new TreeSet(), set1, 13);
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person3 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        owner1 = new Owner(hospital1, person1, false);
        owner2 = new Owner(hospital1, person2, true);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
        animal3 = new Animal("Maia", Species.DOG, owner2, hospital2);
        animal4 = null;
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    //****Tests*****
    
    /**
     * Checks that equals works with equal objects.
     */
    @Test
    public void equalsEqualArgs()
    {
        assert(animal2.equals(animal3)) : "animal2 should be equal to animal3";
    }
    
    
    
    
    /**
     * Checks that equals works with unequal objects.
     */
    @Test
    public void equalsUnequalArgs()
    {
        assertFalse("animal1 should not be equal to animal2", 
                        animal1.equals(animal2));
    }
    
    
    
    
    /**
     * Checks that equals works with null argument.
     */
    @Test
    public void equalsNull()
    {
        assertFalse("animal1 should not be equal to null", animal1.equals(animal4));
    }
    
    
    
    /**
     * Checks that the same hashCode is produced for equal objects.
     */
    @Test
    public void hashCodeEqualArgs()
    {
        assert(animal2.hashCode() == animal3.hashCode()) : 
                "animal2's hashCode should be the same as animal3's.";
    }
    
    
    
    
    /**
     * Checks that a different hashCode is produced for similar objects.
     */
    @Test
    public void hashCodeSimilarArgs()
    {
         person3 = new Person("Miss", "Beyonc", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
         owner2 = new Owner(hospital1, person3, true);
         animal3 = new Animal("Maia", Species.DOG, owner2, hospital1);
        assert(animal2.hashCode() != animal3.hashCode()) : 
                "animal2 should have a different hashCode to animal3";
    }
    
    
    
    /**
     * Checks compareTo against equal arguments.
     */
    @Test
    public void compareToEqualArgs()
    {
        assert(animal2.compareTo(animal3) == 0) : 
                "animal2 should be equal to animal3";
    }
    
    
    
    /**
     * Checks compareTo against similar arguments
     */
    public void compareToSimilarArgs()
    {
        animal3 = new Animal("Mai", Species.DOG, owner2, hospital1 );
        assert(animal2.compareTo(animal3) > 0) : 
                "animal2 should come after animal3";
    }
    
    
    
    /**
     * Checks compareTo throws the correct exception.
     */
    @Test(expected = NullPointerException.class)
    public void compareToNull()
    {
        animal1.compareTo(animal4);
    }
}
