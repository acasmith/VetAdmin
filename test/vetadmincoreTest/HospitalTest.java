package vetadmincoreTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
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
            Person person1;
            Person person2;
            Person person3;
            Owner owner1;
            Owner owner2;
            Animal animal1;
            Animal animal2;
            Animal animal3;
            Animal animal4;
            Animal animal5;
            Animal animal6;
            Resident resident1;
            Resident resident2;
            Resident resident3;
            Resident resident4;
            Resident resident5;
            Resident resident6;
            Staff staff1;
            Vet vet1;
            Nurse nurse1;
            
    
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
        testSet = new HashSet<>();
        hospital1 = new Hospital("Burseldon", new HashSet(), 
                                set1, 5);
        hospital2 = new Hospital("York", new HashSet(), set2, 13);
        hospital3 = new Hospital("York", new HashSet(), set2, 13);
        hospital4 = null;
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person3 = new Person("Mrs", "Dana", "Lockley", "94 Essington Road",
                                "dana@hooya.com", "84302345802");
        owner1 = new Owner(hospital1, person1, false);
        owner2 = new Owner(hospital1, person2, true);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
        animal3 = new Animal("Gonzo", Species.CAT, owner2, hospital1);
        animal4 = new Animal("Tiki", Species.BIRD, owner2, hospital1);
        animal5 = new Animal("Dusty", Species.CAT, owner1, hospital1);
        animal6 = new Animal("Maisy", Species.HORSE, owner1, hospital1);
        resident1 = new Resident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        resident2 = new Resident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        resident3 = new Resident(animal3, hospital1, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        resident4 = new Resident(animal4, hospital1, LocalDate.of(2020, 7, 30), "Cuddle addict", false);
        resident5 = new Resident(animal5, hospital1, LocalDate.of(2020, 4, 17), "Ate too much", true);
        resident6 = new Resident(animal6, hospital1, LocalDate.of(2020, 2, 23), "Very sleepy", true);
        staff1 = new Staff(person1, hospital1);
        vet1 = new Vet(person2, hospital1, "MSc");
        nurse1 = new Nurse(person3, hospital1, "PhD", vet1);
        
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
                "hospital1 should come before hospital2";
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
    
    
    
    /**
     * Checks that getRegisteredAnimals returns all of the animals registered to
     * the hospital when all owners have animals.
     */
    @Test
    public void getRegisteredAnimalsAverageCase()
    {
        testSet.add(animal1); //Create equivalent result set.
        testSet.add(animal2);
        testSet.add(animal3);
        owner1.addAnimal(animal1);  //Register animals with owners.
        owner2.addAnimal(animal2);
        owner2.addAnimal(animal3);
        hospital1.addOwner(owner1); //Register owners with hospital.
        hospital1.addOwner(owner2);
        
        Set<Animal> results = hospital1.getRegisteredAnimals();
        assert(results.equals(testSet));
    }
            
    
    
    /**
     * Checks getRegisteredAnimals works when all owners have no animals.
     */
    @Test
    public void getRegisteredAnimalsNoAnimals()
    {
        hospital1.addOwner(owner1);
        hospital1.addOwner(owner2);
        assert(testSet.equals(hospital1.getRegisteredAnimals())) : 
                "An empty set should be returned";
    }
    
    
    
    /**
     * Checks getRegisteredAnimals works when the receiver has no registered 
     * owners.
     */
    @Test
    public void getRegisteredAnimalsNoOwners()
    {
        assert(testSet.equals(hospital1.getRegisteredAnimals())) :
                "An empty set should be returned";
    }
    
    
    
    /**
     * Checks that getTreated returns only residents with a true treated attribute
     * when there are objects to return.
     */
    @Test
    public void getTreatedResidentsAverageCase()
    {
        hospital1.addResident(resident1);   //USES STUB!!!!Make sure to replace.
        hospital1.addResident(resident2);   //USES STUB!!!!Make sure to replace.
        testSet.add(resident1);
        assert(hospital1.getTreatedResidents().equals(testSet)) : 
                "Only resident1 should be returned by the method.";
    }
    
    
    /**
     * getTreatedResidents no treated.
     */
    @Test
    public void getTreatedResidentsNoTreated()
    {
        hospital1.addResident(resident2);   //USES STUB!! Makes sure to replace.
        assert(testSet.equals(hospital1.getTreatedResidents())) : 
                "No residents should be returned";
    }
    
    
    
    /**
     * getTreatedResident no residents.
     */
    @Test
    public void getTreatedResidentsNoResidents()
    {
        assert(testSet.equals(hospital1.getTreatedResidents())) : 
                "No residents should be returned";
    }
    
    
    
    
    /**
     * Checks that getTreated returns only residents with a true treated attribute
     * when there are objects to return.
     */
    
    @Test 
    public void getUntreatedResidentsAverageCase()
    {
        hospital1.addResident(resident1);   //<--USES STUB!!!!Make sure to replace.
        hospital1.addResident(resident2);   //<--USES STUB!!!!Make sure to replace.
        testSet.add(resident2);
        assert(hospital1.getUntreatedResidents().equals(testSet)) : 
                "Only resident2 should be returned by the method.";
    }
    
    
    /**
     * Checks getUntreatedResidents works when there are no treated residents.
     */
    @Test
    public void getUntreatedResidentsNoTreated()
    {
        hospital1.addResident(resident1);   //<--USES STUB!! Makes sure to replace.
        assert(testSet.equals(hospital1.getUntreatedResidents())) : 
                "No residents should be returned";
    }
    
    
    
    /**
     * Checks getUntreatedResidents works when there are no residents.
     */
    @Test
    public void getUntreatedResidentsNoResidents()
    {
        assert(testSet.equals(hospital1.getUntreatedResidents())) : 
                "No residents should be returned";
    }
    
    
    
    /**
     * Checks getVets returns only Vet objects.
     */
    @Test
    public void getVetsAverageCase()
    {
        hospital1.addStaff(vet1);
        hospital1.addStaff(nurse1);
        hospital1.addStaff(staff1);
        testSet.add(vet1);
        assert(testSet.equals(hospital1.getVets())) : 
                "A set containing only vet1 should be returned";
    }
    
    
    
    /**
     * Checks getVets works when there are no vets.
     */
    @Test
    public void getVetsNoVets()
    {
        hospital1.addStaff(staff1);   //<--USES STUB!!!
        hospital1.addStaff(nurse1); //<--USES STUB!!!
        assert(testSet.equals(hospital1.getVets())) : 
                "An empty set should be returned.";
    }
    
    
    
    
    /**
     * Checks getVets() works when there are no staff.
     */
    @Test
    public void getVetsNoStaff()
    {
        assert(testSet.equals(hospital1.getVets())) : 
                "An empty set should be returned.";
    }
    
    
    
    /**
     * Checks getNurses returns only Nurse objects.
     */
    @Test
    public void getNurseAverageCase()
    {
        hospital1.addStaff(vet1);   //<--USES STUB!!!
        hospital1.addStaff(staff1);
        hospital1.addStaff(nurse1);
        testSet.add(nurse1);
        assert(testSet.equals(hospital1.getNurses())) : 
                "A set containing only nurse1 should be returned";
    }
    
    
    
    /**
     * Checks getNurses works when there are no nurses.
     */
    @Test
    public void getNursesNoVets()
    {
        hospital1.addStaff(staff1);   //<--USES STUB!!!
        hospital1.addStaff(vet1); //<--USES STUB!!!
        assert(testSet.equals(hospital1.getNurses())) : 
                "An empty set should be returned.";
    }
    
    
    
    
    /**
     * Checks getNurses() works when there are no staff.
     */
    @Test
    public void getNursesNoStaff()
    {
        assert(testSet.equals(hospital1.getNurses())) : 
                "An empty set should be returned.";
    }
    
    
    
    
    /**
     * Checks addResident() works when there is space.
     */
    @Test
    public void addResidentAverageCase()
    {
        hospital1.addResident(resident1);
        hospital1.addResident(resident2);
        hospital1.addResident(resident3);
        hospital1.addResident(resident4);
        assert(hospital1.addResident(resident5)) : "Should return true";
        assert(hospital1.getResidents().contains(resident5)) : 
                "hospital1's residents should contain resident 5";
    }
    
    
    
    /**
     * Checks addResident() works when there is no space.
     */
    @Test
    public void addResidentHospitalFull()
    {
        hospital1.addResident(resident1);
        hospital1.addResident(resident2);
        hospital1.addResident(resident3);
        hospital1.addResident(resident4);
        hospital1.addResident(resident5);
        assert(!hospital1.addResident(resident6)) : "Should return false";
        assert(!hospital1.getResidents().contains(resident6)) : 
                "hospital1's residents should not contain resident 6";
    }
    
    
    
    /**
     * Checks addResident() works when the resident is of the wrong species.
     */
}
