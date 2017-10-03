package vetadmincoreTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;
import java.time.LocalTime;
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
            Set<Staff> staffSet;
            Set testSet;
            Person person1;
            Person person2;
            Person person3;
            Owner owner1;
            Owner owner2;
            Owner owner3;
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
            Vet vet1;
            Vet vet2;
            Nurse nurse1;
            Appointment appointment1;
            
    
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
        testSet = new HashSet<>();
        staffSet = new HashSet<>();
        hospital1 = new Hospital("Burseldon", staffSet, 
                                set1, 5);
        hospital2 = new Hospital("York", staffSet, set2, 13);
        hospital3 = new Hospital("York", staffSet, set2, 13);
        
        person1 = new Person("Mr", "Buddy", "Holly", "24 Cardigan Way", 
                                "buddy@dmail.com", "04323444666");
        person2 = new Person("Miss", "Beyonce", "Knowles", "58 Boogie Down",
                                "beyonce@shakeyabooty.com", "94534665421");
        person3 = new Person("Mrs", "Dana", "Lockley", "94 Essington Road",
                                "dana@hooya.com", "84302345802");
        owner1 = new Owner(hospital1, person1, false);
        owner2 = new Owner(hospital1, person2, true);
        owner3 = new Owner(hospital1, person3, false);
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
        nurse1 = new Nurse(person3, hospital1, "PhD", vet1);
        vet1 = new Vet(person2, hospital1, "MSc");
        vet2 = new Vet(person3, hospital1, "BSc");
        hospital4 = null;
        
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
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
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
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
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
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
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
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
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
        System.out.println(hospital1.getVets().size());
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
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
        hospital1.addResident(animal3, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        hospital1.addResident(animal4, LocalDate.of(2020, 7, 30), "Cuddle addict", false);
        //System.out.println(hospital1.getResidents());
        assert(hospital1.addResident(animal5, LocalDate.of(2020, 4, 17), "Ate too much", true)) : "Should return true";
        assert(hospital1.getResidents().contains(resident5)) : 
                "hospital1's residents should contain resident 5";
    }
    
    
    
    /**
     * Checks addResident() works when there is no space.
     */
    @Test
    public void addResidentHospitalFull()
    {
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
        hospital1.addResident(animal3, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        hospital1.addResident(animal4, LocalDate.of(2020, 7, 30), "Cuddle addict", false);
        hospital1.addResident(animal5, LocalDate.of(2020, 4, 17), "Ate too much", true);
        assert(!hospital1.addResident(animal7, LocalDate.of(2020, 2, 12), "Sings in the shower", true)) : "Should return false";
        assert(!hospital1.getResidents().contains(resident7)) : 
                "hospital1's residents should not contain resident 6";
    }
    
    
    
    /**
     * Checks addResident() works when the resident is of the wrong species.
     */
    @Test
    public void addResidentWrongSpecies()
    {
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
        hospital1.addResident(animal3, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        assert(!hospital1.addResident(animal6, LocalDate.of(2020, 2, 23), "Very sleepy", true)) : "Should return false";
        assert(!hospital1.getResidents().contains(6)) : 
                "hospital1's residents should not contain resident6";
        
    }
    
    
    
    /**
     * Checks that remove resident works when the resident is present.
     */
    @Test
    public void removeResidentPresent()
    {
        assert(hospital1.getResidents().isEmpty()) : "hospital1 should have no residents at the start.";
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
        hospital1.addResident(animal3, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        Set<Resident> residentSet = (hospital1.getResidents());
        for(Resident aResident : residentSet)
        {
            assert(hospital1.getResidents().contains(aResident)) : "hospital1 residents should contain aResident.";
            assert(hospital1.removeResident(aResident)) : 
                    "aResident should be removed from hospital1's residents";
        }
        assert(hospital1.getResidents().isEmpty()) : "hospital1 should have no residents at the end";
        
    }
    
    
    
    
    /**
     * Checks that removeResident works when the resident is not present.
     */
        @Test
    public void removeResidentNotPresent()
    {
        assert(hospital1.getResidents().isEmpty()) : "hospital1 should have no residents at the start.";
        hospital1.addResident(animal1, LocalDate.of(2020, 12, 12), "Sore paw", true);
        hospital1.addResident(animal2, LocalDate.of(2020, 12, 11), "Too cute", false);
        hospital1.addResident(animal3, LocalDate.of(2020, 11, 29), "Uber fluffy", true);
        Set<Resident> residentSet = new HashSet<>();
        residentSet.add(new Resident(animal4, hospital1, LocalDate.of(2020, 7, 30), "Cuddle addict", false));
        for(Resident aResident : residentSet)
        {
            assert(!hospital1.getResidents().contains(aResident)) : "hospital1 residents should not contain aResident.";
            assert(!hospital1.removeResident(aResident)) : 
                    "aResident should not be removed from hospital1's residents because it was never there";
        }
        
    }
    
    
    
    
    /**
     * Checks addStaff works with a staff member linked to another hospital.
     */
    @Test
    public void addStaffLinked()
    {
        assert(staff1.getHospital().equals(hospital1)) : "staff1 should be employed at hospital1";
        assert(hospital2.addStaff(staff1)) : "Should return true.";
        assert(hospital2.getStaff().contains(staff1)) : "hospital1's staffMembers set should contain staff1";
    }
    
    
    
    /**
     * Checks addStaff works with a staff member is already linked to the hospital.
     */
    @Test
    public void addStaffAlreadyLinked()
    {
        assert(staff1.getHospital().equals(hospital1)) : "staff1 should be employed at hospital1";
        hospital1.addStaff(staff1);
        assert(hospital1.getStaff().size() == 1 && 
                hospital1.getStaff().contains(staff1)) :
                "hospital1 should only employ staff1";
        assert(!hospital1.addStaff(staff1)) : "Staff 1 should not be added as it's already there";
        assert(hospital1.getStaff().size() == 1 && 
                hospital1.getStaff().contains(staff1)) :
                "hospital1 should only employ staff1 at the end";
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
     * Checks assignVet assigns the vet with the lowest assigned animals when
     * there is one viable candidate.
     */
    @Test
    public void assignVetAverageCase()
    {
        vet1.addAnimal(animal1);
        hospital1.addStaff(vet1);
        hospital1.addStaff(vet2);
        assert(hospital1.assignVet(animal2) == vet2) : "assignVet should return vet2";
        assert(vet2.getAssignedAnimals().contains(animal2) && 
                vet2.getAssignedAnimals().size()== 1) :
                "vet2 should be assigned only to animal2";
    }
    
    
    
    /**
     * Checks assignVet assigns a vet with the lowest assigned animals when
     * more than one vet is more than one viable candidate.
     */
    @Test
    public void assignVetMultipleOptions()
    {
        vet1.addAnimal(animal1);
        vet2.addAnimal(animal2);
        hospital1.addStaff(vet1);
        hospital1.addStaff(vet2);
        Vet assignedVet = hospital1.assignVet(animal3);
        assert(assignedVet == vet1 || assignedVet == vet2) : 
                "the assigned vet should be either vet1 or vet2";
        assert(assignedVet.getAssignedAnimals().size() == 2 &&
                assignedVet.getAssignedAnimals().contains(animal3)) :
                "the assignedVet should be assigned animal3 and 1 other only";
        
    }
    
    
    /**
     * Checks assignVet works correctly when there are no vets to assign.
     */
    @Test
    public void assignVetNoVets()
    {
        assert(hospital1.assignVet(animal1) == null) : "null should be returned";
        assert(animal1.getAssignedVet() == null) : "animal1 should not have any vet assigned";
    }
    
    
    
    
    
    
    
    
    
    /**
     * Checks addAppointment works when both the animals assigned vet and the 
     * owner have no other appointments at that date and time.
     */
    @Test
    public void addAppointmentAverageCase()
    {
        hospital1.addStaff(vet1);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        owner1.addAnimal(animal1);
        appointment1 = new Appointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal1, animal1.getAssignedVet());
        assert(owner1.getAppointments().isEmpty()) : "owner1 should have no appointments";
        assert(vet1.getAppointments().isEmpty()) : "vet1 should have no appointments";
        assert(hospital1.addAppointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal1)) : "A new appointment should be made.";
        assert(vet1.getAppointments().size() == 1 && vet1.getAppointments().contains(appointment1)) :
                "vet1 should have appointment1 as it's only appointment.";
        assert(owner1.getAppointments().size() == 1 && owner1.getAppointments().contains(appointment1)) :
                "owner1 should have appointment1 as it's only appointment.";
        
        
    }
    
    
    
    /**
     * Checks addAppointment works when the animals assigned vet is unavailable,
     * so another vet must be found.
     */
    @Test
    public void addAppointmentAssignedVetUnavailable()
    {
        //Add animals whilst there's only 1 vet to choose from.
        hospital1.addStaff(vet1);   
        owner1.addAnimal(animal1);
        owner2.addAnimal(animal2);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
        
        //Ensure vet1 has an appointment to clash with.
        hospital1.addAppointment(LocalDate.of(2020, 5, 14),
                LocalTime.of(9,0), animal1);
        
        //Add second vet
        hospital1.addStaff(vet2);   
        
        //Create the appointment that should be made to compare results against.
        appointment1 = new Appointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal2, vet2);
        
        //Tests
        assert(vet1.getAppointments().size() == 1) : 
                "vet1 should have 1 appointment at the start";
        assert(vet2.getAppointments().isEmpty()) : 
                "vet2 should have no appointments at the start";
        assert(owner2.getAppointments().isEmpty()) :
                "owner2 should have no appointments at the start";
        assert(hospital1.addAppointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal2)) : 
                "A new appointment should be made.";
        assert(vet2.getAppointments().size() == 1 && vet2.getAppointments().contains(appointment1)) :
                "vet2 should have appointment1 as it's only appointment.";
        assert(owner2.getAppointments().size() == 1 && owner2.getAppointments().contains(appointment1)) :
                "owner2 should have appointment1 as it's only appointment.";
    }
    
    
    
    /**
     * Checks addAppointment works when no vet is available for the appointment.
     */
    @Test
    public void addAppointmentNoVetAvailable()
    {
        //Assign all animals to vet1.
        hospital1.addStaff(vet1);
        owner1.addAnimal(animal1);
        owner2.addAnimal(animal2);
        owner3.addAnimal(animal3);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        animal2 = new Animal("Maia", Species.DOG, owner2, hospital1);
        animal3 = new Animal("Gonzo", Species.CAT, owner2, hospital1);
        
        //Add vet2 and create two appointments at the same time so both vets will be busy.
        hospital1.addStaff(vet2);
        hospital1.addAppointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal1);
        hospital1.addAppointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal2);
        
        //Tests
        assert(!hospital1.addAppointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal3)) : 
                "no appointment should be made, no vet is free";
        assert(vet1.getAppointments().size() == 1) : "vet1 should have 1 appointments";
        assert(vet2.getAppointments().size() == 1) : "vet2 should have 1 appointments";
        assert(owner3.getAppointments().isEmpty()) : "owner3 should have no appointments";
    }
    
    
    
    /**
     * Checks addAppointment works when the owner is not free.
     */
    @Test
    public void addAppointmentOwnerUnavailable()
    {
        hospital1.addStaff(vet1);
        animal1 = new Animal("Freddy", Species.DOG, owner1, hospital1);
        hospital1.addStaff(vet2);
        animal2 = new Animal("Maia", Species.DOG, owner1, hospital1);
        owner1.addAnimal(animal1);
        owner1.addAnimal(animal2);
        
        //Add appointment to occupy the owner
        hospital1.addAppointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal1);
        //Create the appointment equal to the one that will occupy the owner to compare against it.
        appointment1 = new Appointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal1, animal1.getAssignedVet());
        
        
        
        //Tests
        assert(owner1.getAppointments().size() == 1 && 
                owner1.getAppointments().contains(appointment1)) : 
                "owner1 should have 1 appointment at the start";
        assert(vet1.getAppointments().size() == 1 && 
                vet1.getAppointments().contains(appointment1)) : 
                "vet1 should have 1 appointment at the start";
        assert(vet2.getAppointments().isEmpty()): 
                "vet2 should have no appointments at the start";
        
        
        assert(!hospital1.addAppointment(LocalDate.of(2020, 5, 14), 
                LocalTime.of(9,0), animal2)) : 
                "No appointment should be made, the owner is busy.";
        
        
        assert(owner1.getAppointments().size() == 1 && 
                owner1.getAppointments().contains(appointment1)) : 
                "owner1 should have 1 appointment at the end";
        assert(vet1.getAppointments().size() == 1 && 
                vet1.getAppointments().contains(appointment1)) : 
                "vet1 should have 1 appointment at the end";
        assert(vet2.getAppointments().isEmpty()): 
                "vet2 should have no appointments at the end";
        
    }
    
    
    
    /**
     * Checks if addAnimal works when the hospital can treat its species.
     */
    @Test
    public void addAnimalCanTreat()
    {
        Animal targetAnimal = new Animal("Ringo", Species.DOG, owner1, hospital1);
        assert(owner1.getAnimals().isEmpty()) : 
                "owner1 should have no animals registered";
        assert(hospital1.addAnimal("Ringo", Species.DOG, owner1)) :
                "the new animal should be registered";
        assert(owner1.getAnimals().size() == 1 &&
                owner1.getAnimals().contains(targetAnimal)) :
                "owner1 should have targetAnimal registered only";
    }
    
    
    
    /**
     * Checks if addAnimal works when the hospital cannot treat its species.
     */
    @Test
    public void addAnimalCantTreat()
    {
        assert(owner1.getAnimals().isEmpty()) : 
                "owner1 should have no animals registered at the start";
        assert(!hospital1.addAnimal("Monty", Species.HORSE, owner1)) :
                "the new animal should not be registered";
        assert(owner1.getAnimals().isEmpty()) : 
                "owner1 should have no animals registered at the end";
    }
}
