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
    Set<Species> speciesSet;
    Hospital hospital1;
    Hospital hospital2;
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;
    Owner owner1;
    Owner owner2;
    Animal animal1;
    Animal animal2;
    Animal animal3;
    Animal animal4;
    Animal animal5;
    Animal animal6;
    Animal animal7;
    Resident resident1;
    Resident resident2;
    Resident resident3;
    Resident resident4;
    Resident resident5;
    Resident resident6;
    Resident resident7;
    Staff staff1;
    Staff staff2;
    Staff staff3;
    Staff staff4;
    Staff staff5;
    Vet vet1;
    Nurse nurse1;
    
    
    public VetAdminCoordTest() {
        speciesSet = new HashSet<>();
        speciesSet.add(Species.DOG);
        speciesSet.add(Species.CAT);
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
                                speciesSet, 5);
        hospital2 = new Hospital("York", new HashSet(), speciesSet, 13);
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person3 = new Person("Mrs", "Dana", "Lockley", "94 Essington Road",
                                "dana@hooya.com", "84302345802");
        person4 = new Person("Mr", "James", "Jones", "45 Marquee Lane",
                                "jonsey@boo.co.uk", "23591247589");
        person5 = new Person("Miss", "Wanda", "Renolds", "1 Magic Road",
                                "wandering_wanda@realm.uk", "1234597612658");
        owner1 = new Owner(hospital1, person1, false);
        owner2 = new Owner(hospital1, person2, true);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
        animal3 = new Animal("Gonzo", Species.CAT, owner2, hospital1);
        animal4 = new Animal("Tiki", Species.DOG, owner2, hospital1);
        animal5 = new Animal("Dusty", Species.CAT, owner1, hospital1);
        animal6 = new Animal("Maisy", Species.HORSE, owner1, hospital1);
        animal7 = new Animal("Milo", Species.DOG, owner1, hospital1);
        resident1 = new Resident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        resident2 = new Resident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        resident3 = new Resident(animal3, hospital1, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        resident4 = new Resident(animal4, hospital1, LocalDate.of(2020, 7, 30), "Cuddle addict", false);
        resident5 = new Resident(animal5, hospital1, LocalDate.of(2020, 4, 17), "Ate too much", true);
        resident6 = new Resident(animal6, hospital1, LocalDate.of(2020, 2, 23), "Very sleepy", true);
        resident7 = new Resident(animal7, hospital1, LocalDate.of(2020, 2, 12), "Sings in the shower", true);
        staff1 = new Staff(person1, hospital1);
        staff2 = new Staff(person2, hospital1);
        staff3 = new Staff(person3, hospital1);
        staff4 = new Staff(person4, hospital1);
        staff5 = new Staff(person5, hospital1);
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
        admin1.addResident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        admin1.addResident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
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
        admin1.addResident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
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
        
        admin1.addResident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        admin1.addResident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
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
    
    
    
    
     /**
     * Checks addResident() works when there is space.
     */
    @Test
    public void addResidentAverageCase()
    {
        admin1.addResident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        admin1.addResident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        admin1.addResident(animal3, hospital1, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        admin1.addResident(animal4, hospital1, LocalDate.of(2020, 7, 30), "Cuddle addict", false);
        //System.out.println(hospital1.getResidents());
        assert(admin1.addResident(animal5, hospital1, LocalDate.of(2020, 4, 17), "Ate too much", true)) : "Should return true";
        assert(admin1.getResidents(hospital1).contains(resident5)) : 
                "hospital1's residents should contain resident 5";
    }
    
    
    
    /**
     * Checks addResident() works when there is no space.
     */
    @Test
    public void addResidentHospitalFull()
    {
        admin1.addResident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        admin1.addResident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        admin1.addResident(animal3, hospital1, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        admin1.addResident(animal4, hospital1, LocalDate.of(2020, 7, 30), "Cuddle addict", false);
        admin1.addResident(animal5, hospital1, LocalDate.of(2020, 4, 17), "Ate too much", true);
        assert(!admin1.addResident(animal7, hospital1, LocalDate.of(2020, 2, 12), "Sings in the shower", true)) : "Should return false";
        assert(!admin1.getResidents(hospital1).contains(resident7)) : 
                "hospital1's residents should not contain resident 7";
    }
    
    
    
    /**
     * Checks addResident() works when the resident is of the wrong species.
     */
    @Test
    public void addResidentWrongSpecies()
    {
        admin1.addResident(animal1, hospital1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        admin1.addResident(animal2, hospital1, LocalDate.of(2020, 12, 11), "Too cute", false);
        admin1.addResident(animal3, hospital1, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        assert(!admin1.addResident(animal6, hospital1, LocalDate.of(2020, 2, 23), "Very sleepy", true)) : "Should return false";
        assert(!admin1.getResidents(hospital1).contains(resident6)) : 
                "hospital1's residents should not contain resident6";
        
    }
    
    
    
    
    /**
     * Checks addStaff works with a staff member linked to another hospital.
     */
    @Test
    public void addStaffLinked()
    {
        admin1.addStaff(hospital1, staff1);
        assert(staff1.getHospital().equals(hospital1) && 
                hospital1.getStaff().contains(staff1) ) : 
                "staff1 should be employed at hospital1";
        assert(admin1.addStaff(hospital2, staff1)) : "Should return true.";
        assert(admin1.getStaff(hospital2).contains(staff1)) : 
                "hospital1's staffMembers set should contain staff1";
    }
    
    
    
    /**
     * Checks removeStaff works when the staff member is not employed there.
     */
    @Test
    public void removeStaffNoLink()
    {
        assert(!hospital2.getStaff().contains(staff1)) : 
                "staff1 should not be employed at hospital2";
        assert(!hospital2.removeStaff(staff1)) : 
                "staff1 should not be removed as it is not present";
    }
    
    
    
    /**
     * Checks addHospital works when the data is correct.
     */
    @Test public void addHospitalAverageCase()
    {
        Set<Staff> staffSet = new HashSet<>();
        staffSet.add(staff1);
        staffSet.add(staff2);
        staffSet.add(staff3);
        staffSet.add(staff4);
        staffSet.add(staff5);
        hospital1 = new Hospital("Didsbury", staffSet, speciesSet, 20);
        assert(admin1.getHospitals().isEmpty()) : "No hospitals should have been registered yet";
        assert(admin1.addHospital("Didsbury", staffSet, speciesSet, 20)) :
                "hospital1 should be created";
        assert(admin1.getHospitals().contains(hospital1)) : //try for loop and equals if not working
                "hospital1 should have been added to admin1's hospitals collection";
        admin1.removeHospital(hospital1);
    }
    
    
    /**
     * Checks addHospital works when too few staff are given.
     */
    @Test
    public void addHospitalNoStaff()
    {
        Set<Staff> staffSet = new HashSet<>();
        hospital1 = new Hospital("Didsbury", staffSet, speciesSet, 20);
        System.out.println(admin1.getHospitals());
        assert(admin1.getHospitals().isEmpty()) : "No hospitals should have been registered yet";
        assert(!admin1.addHospital("Didsbury", staffSet, speciesSet, 20)) :
                "hospital1 should not be created";
        assert(admin1.getHospitals().isEmpty()) : //try for loop and equals if not working
                "hospital1 should not have been added to admin1's hospitals collection";
        admin1.removeHospital(hospital1);
    }
    
    
    
    
    

}
