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
 * Unit tests for the Hospital class.
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
            Person person1;
            Person person2;
            Owner owner1;
            Owner owner2;
            Animal animal1;
            Animal animal2;
            Animal animal3;
            
    
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
        testSet = new HashSet();
        testSortedSet = new TreeSet<>();
        hospital1 = new Hospital("Burseldon", new TreeSet(), 
                                set1, 5);
        hospital2 = new Hospital("York", new TreeSet(), set2, 13);
        hospital3 = new Hospital("York", new TreeSet(), set2, 13);
        hospital4 = null;
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        owner1 = new Owner(hospital1, person1, false);
        owner2 = new Owner(hospital1, person2, true);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
        animal3 = new Animal("Gonzo", Species.CAT, owner2, hospital1);
        
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
        hospital3 = new Hospital("Yor", new TreeSet(), set2, 13);
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
        hospital3 = new Hospital("Yor", new TreeSet(), set2, 13);
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
    
    
    
    /**
     * Checks that getRegisteredAnimals returns all of the animals registered to
     * the hospital when all owners have animals.
     */
    @Test
    public void getRegisteredAnimalsAverageCase()
    {
        testSortedSet.add(animal1); //Create equivalent result set.
        testSortedSet.add(animal2);
        testSortedSet.add(animal3);
        owner1.addAnimal(animal1);  //Register animals with owners.
        owner2.addAnimal(animal2);
        owner2.addAnimal(animal3);
        hospital1.addOwner(owner1); //Register owners with hospital.
        hospital1.addOwner(owner2);
        
        SortedSet<Animal> results = hospital1.getRegisteredAnimals();
        assert(results.equals(testSortedSet));
    }
            
    
    
    /**
     * Checks getRegisteredAnimals works when all owners have no animals.
     */
    
    
    
    /**
     * Checks getRegisteredAnimals works when the receiver has no registered 
     * owners.
     */
}
