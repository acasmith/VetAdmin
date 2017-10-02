/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincoreTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
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
public class ResidentTest {
    Hospital hospital1;
    Person person1;
    Person person2;
    Person person3;
    Owner owner1;
    Owner owner2;
    Animal animal1;
    Animal animal2;
    Resident resident1;
    Resident resident2;
    Resident resident3;
    Resident resident4;
    
    public ResidentTest() {
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
        person3 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        owner1 = new Owner(hospital1, person1, false);
        owner2 = new Owner(hospital1, person2, true);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
        resident1 = new Resident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        resident2 = new Resident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        resident3 = new Resident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        resident4 = null;
    }
    
    @After
    public void tearDown() {
    }


    //***Tests*****
    
    
    
    /**
     * Checks that equals works with equal objects.
     */
    @Test
    public void equalsEqualArgs()
    {
        assert(resident2.equals(resident3)) : "resident2 should be equal to resident3";
    }
    
    
    
    
    /**
     * Checks that equals works with unequal objects.
     */
    @Test
    public void equalsUnequalArgs()
    {
        assertFalse("resident1 should not be equal to resident2", 
                        resident1.equals(resident2));
    }
    
    
    
    
    /**
     * Checks that equals works with null argument.
     */
    @Test
    public void equalsNull()
    {
        assertFalse("resident1 should not be equal to null", resident1.equals(resident4));
    }
    
    
    
    /**
     * Checks that the same hashCode is produced for equal objects.
     */
    @Test
    public void hashCodeEqualArgs()
    {
        assert(resident2.hashCode() == resident3.hashCode()) : 
                "resident2's hashCode should be the same as resdient3's.";
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
         animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
         resident3 = new Resident(animal2, hospital1, LocalDate.of(2020, 12, 11), 
                                    "Too cute", false);
        assert(resident2.hashCode() != resident3.hashCode()) : 
                "resident2 should have a different hashCode to resident3";
    }
    
    
    
    /**
     * Checks compareTo against equal arguments.
     */
    @Test
    public void compareToEqualArgs()
    {
        assert(resident2.compareTo(resident3) == 0) : 
                "resident2 should be equal to resident3";
    }
    
    
    
    /**
     * Checks compareTo against similar arguments
     */
    public void compareToSimilarArgs()
    {
        animal2 = new Animal("Mai", Species.DOG, owner2, hospital1 );
        resident3 = new Resident(animal2, hospital1, LocalDate.of(2020, 12, 11), 
                                    "Too cute", false);
        assert(resident2.compareTo(resident3) > 0) : 
                "resident2 should come after resident3";
    }
    
    
    
    /**
     * Checks compareTo throws the correct exception.
     */
    @Test(expected = NullPointerException.class)
    public void compareToNull()
    {
        resident1.compareTo(resident4);
    }
    
}
