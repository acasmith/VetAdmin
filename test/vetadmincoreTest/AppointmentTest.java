/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincoreTest;

import java.time.LocalDate;
import java.time.LocalTime;
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
public class AppointmentTest {
    Hospital hospital1;
    Person person1;
    Person person2;
    Person person3;
    Owner owner1;
    Animal animal1;
    Animal animal2;
    Vet vet1;
    Appointment appointment1;
    Appointment appointment2;
    Appointment appointment3;
    
    
    public AppointmentTest() {
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
                                new HashSet(), 5);
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person3 = new Person("Mrs", "Dana", "Lockley", "94 Essington Road",
                                "dana@hooya.com", "84302345802");
        owner1 = new Owner(hospital1, person1, false);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner1, hospital1);
        vet1 = new Vet(person2, hospital1, "MSc");
        appointment1 = new Appointment(LocalDate.of(2020, 12, 12), LocalTime.of(9, 00), animal1, vet1);
        appointment2 = new Appointment(LocalDate.of(2020, 12, 12), LocalTime.of(10, 00), animal2, vet1);
        appointment3 = new Appointment(LocalDate.of(2020, 12, 12), LocalTime.of(10, 00), animal2, vet1);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    /****Tests********
    
    
        /**
     * Tests equals with equal arguments.
     */
    @Test
    public void equalsEqualArgs()
    {
        assert(appointment2.equals(appointment3)) : "appointment2 should be equal to appointment3";
    }
    
    
    
    /**
     * Tests equals with unequal arguments.
     */
    @Test
    public void equalsUnequalArgs()
    {
        assertFalse("appointment1 should not be equal to appointment2", appointment1.equals(appointment2));
    }
    
    
    
    /**
     * Tests equals with a null argument.
     */
    @Test
    public void equalsNullArg()
    {
        assertFalse("appointment1 should not be equal to null", appointment1.equals(null));
    }
    
    
    
    /**
     * Tests hashCode with equal terms.
     */
    public void hashCodeEqual()
    {
        assert(appointment2.hashCode() == appointment3.hashCode()) : 
                "appointment2 should produce the same hash as appointment3";
    }
    
    
    
    /**
     * Tests hashCode with similar terms.
     */
    public void hashCodeSimilar()
    {
        assert(appointment2.hashCode() != appointment1.hashCode());
    }
}
