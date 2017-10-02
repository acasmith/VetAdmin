/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincoreTest;

import java.time.LocalDate;
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
public class VetAdminCoordTest {
    
    VetAdminCoord admin1;
    Set testSet;
    Hospital hospital1;
    Person person1;
    Person person2;
    Person person3;
    Owner owner1;
    Owner owner2;
    Animal animal1;
    Animal animal2;
    Animal animal3;
    Resident resident1;
    Resident resident2;
    Staff staff1;
    Vet vet1;
    Nurse nurse1;
    
    
    public VetAdminCoordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        admin1 = VetAdminCoord.getVetAdminCoord();
        testSet = new HashSet();
        hospital1 = new Hospital("Burseldon", new HashSet(), 
                                new HashSet(), 5);
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
        resident1 = new Resident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        resident2 = new Resident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        staff1 = new Staff(person1, hospital1);
        vet1 = new Vet(person2, hospital1, "MSc");
        nurse1 = new Nurse(person3, hospital1, "PhD", vet1);
    }
    
    @After
    public void tearDown() {
    }

 
    
    //*****Tests*****
    
    
    
    /**
     * Checks that only one VetAdminCoord is ever in existence.
     */
    @Test
    public void getVetAdminCoordTest()
    {
        VetAdminCoord vetAdmin = VetAdminCoord.getVetAdminCoord();
        assert(vetAdmin == VetAdminCoord.getVetAdminCoord()) : 
                "vetAdmin should share identity with the returned object.";
        
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
        assert(admin1.getTreatedResidents(hospital1).equals(testSet)) : 
                "Only resident1 should be returned by the method.";
    }
    
    
    /**
     * getTreatedResidents no treated.
     */
    @Test
    public void getTreatedResidentsNoTreated()
    {
        hospital1.addResident(resident2);   //USES STUB!! Makes sure to replace.
        assert(testSet.equals(admin1.getTreatedResidents(hospital1))) : 
                "No residents should be returned";
    }
    
    
    
    /**
     * getTreatedResident no residents.
     */
    @Test
    public void getTreatedResidentsNoResidents()
    {
        assert(testSet.equals(admin1.getTreatedResidents(hospital1))) : 
                "No residents should be returned";
    }
    
    
    
        /**
     * Checks getVets returns only Vet objects.
     */
    @Test
    public void getVetsAverageCase()
    {
        hospital1.addStaff(vet1);   //<--USES STUB!!!
        hospital1.addStaff(staff1);   //<--USES STUB!!!
        hospital1.addStaff(nurse1); //<--USES STUB!!!
        testSet.add(vet1);
        assert(testSet.equals(admin1.getVets(hospital1))) : 
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
        assert(testSet.equals(admin1.getVets(hospital1))) : 
                "An empty set should be returned.";
    }
    
    
    
    
    /**
     * Checks getVets() works when there are no staff.
     */
    @Test
    public void getVetsNoStaff()
    {
        assert(testSet.equals(admin1.getVets(hospital1))) : 
                "An empty set should be returned.";
    }
    
    
    
    /**
     * Checks getVets returns only Vet objects.
     */
    @Test
    public void getNursesAverageCase()
    {
        hospital1.addStaff(vet1);   //<--USES STUB!!!
        hospital1.addStaff(staff1);   //<--USES STUB!!!
        hospital1.addStaff(nurse1); //<--USES STUB!!!
        testSet.add(nurse1);
        assert(testSet.equals(admin1.getNurses(hospital1))) : 
                "A set containing only nurse1 should be returned";
    }
    
    
    
    /**
     * Checks getVets works when there are no nurses.
     */
    @Test
    public void getNursesNoNurses()
    {
        hospital1.addStaff(staff1);   //<--USES STUB!!!
        hospital1.addStaff(vet1); //<--USES STUB!!!
        assert(testSet.equals(admin1.getNurses(hospital1))) : 
                "An empty set should be returned.";
    }
    
    
    
    
    /**
     * Checks getVets() works when there are no staff.
     */
    @Test
    public void getNursesNoStaff()
    {
        assert(testSet.equals(admin1.getNurses(hospital1))) : 
                "An empty set should be returned.";
    }
    
    
    
    /**
     * Checks recordTreatment() works correctly.
     */
    @Test
    public void recordTreatmentAverageCase()
    {
        assert(!resident2.hasBeenTreated()) : 
                "resident2 treated attribute should be false.";
        admin1.recordTreatment(resident2);
        assert(resident2.hasBeenTreated()) : "resident2 should have been treated";
    }
    
    
    
    /**
     * Checks that getRegisteredAnimals() works when there are animals present.
     */
    @Test
    public void getRegisteredAnimalsAverageCase()
    {
        owner1.addAnimal(animal1);
        //owner2.addAnimal(animal2);
        hospital1.addOwner(owner1);
        hospital1.addOwner(owner2);
        testSet.add(animal1);
        //testSet.add(animal2);
        
        assert(testSet.equals(admin1.getRegisteredAnimals(hospital1))) : 
                "A set containing only animal1 should be returned.";
    }
    
    
    
    /**
     * Checks getRegisteredAnimals works when there are no animals present.
     */
    @Test
    public void getRegisteredAnimalsNoAnimals()
    {
        hospital1.addOwner(owner1);
        hospital1.addOwner(owner2);
        assert(testSet.equals(admin1.getRegisteredAnimals(hospital1))) : 
                "An empty set should be returned.";
    }
    
    
    
    /**
     * Checks getRegisteredAnimals works when there are no owners present.
     */
    @Test
    public void getRegisteredAnimalsNoOwners()
    {
        assert(testSet.equals(admin1.getRegisteredAnimals(hospital1))) : 
                "An empty set should be returned.";
    }
    
    
    /**
     * Checks getResidentAnimals works when animals are present.
     */
    @Test
    public void getResidentAnimalsAverageCase()
    {
        hospital1.addResident(resident1);
        hospital1.addResident(resident2);
        testSet.add(resident1);
        testSet.add(resident2);
        assert(testSet.equals(admin1.getResidents(hospital1))) : 
                "Should return a set containing resident1 and resident2";
    }
    
    
    /**
     * Checks getResidentAnimals works when no animals are present.
     */
    @Test
    public void getResidentAnimalsNoAnimals()
    {
         assert(testSet.equals(admin1.getResidents(hospital1))) : 
                 "Should return an empty set.";
    }
    

}
