package vetadmincore;
import java.time.LocalDate;
import java.util.*;

/**
 * Coordinating class for the VetAdmin system. Uses the singleton pattern.
 * @author Adam
 */
public class VetAdminCoord {
    
    private static VetAdminCoord instance = null;
    public static int idCounter = 0;    //Used in creation of staff and owner objects.
    private Set<Hospital> hospitals;
    private Set<Owner> owners;
    
    
    /**
     * Private constructor to ensure only one instance exists at a time.
     * Initialises all collections to empty collections.
     */
    private VetAdminCoord()
    {
        this.hospitals = new HashSet<>();
        this.owners = new HashSet<>();
    }
    
    
    
    
    /**
     * Works as the public constructor. If there is no instance of VetAdminCoord
     * in existence then a new one is created and returned, otherwise a
     * reference to the existing one is returned.
     * @return a reference to a VetAdminCoord object.
     */
    public static VetAdminCoord getVetAdminCoord()
    {
        VetAdminCoord theCoord = VetAdminCoord.instance;
        
        if(theCoord == null)
        {
            theCoord = new VetAdminCoord();
            VetAdminCoord.instance = theCoord;
        }
        
        return theCoord;
    }

    
    
    
    
    /**
     * Returns the current idCounter value, then increments it by 1.
     * @return the integer value of idCounter.
     */
    public static int getIDCounter()
    {
        return VetAdminCoord.idCounter++;   
    }
    
    
    
    
    
    /**
     * Returns the hospitals within the business.
     * @return returns a copy of the hospitals  set 
     */
    public Set<Hospital> getHospitals()
    {
        return new HashSet<Hospital>(this.hospitals);
    }
    
    
    
    
    /**
     * Returns the hospitals within the business.
     * @return returns a copy of the hospitals  set 
     */
    public Set<Owner> getOwners()
    {
        return new HashSet<Owner>(this.owners);
    }
    
    
    
    /**
     * Returns all the owners registered at the given hospital.
     * @return a copy of the hospital's owners Set.
     */
    public Set<Owner> getOwners(Hospital aHospital)
    {
        return aHospital.getOwners();
    }
    
    
    
    
    /**
     * Returns all the hospitals the given owner is registered at.
     * @return a copy of the owners hospitals  set.
     */
    public Set<Hospital> getOwnersHospitals(Owner anOwner)
    {
        return anOwner.getHospitals();
    }
    
    
    
    
    /**
     * Returns all of the staff employed at aHospital.
     * @param aHospital a hospital object.
     * @return a copy of the arguments staffMembers Set.
     */
    public Set<Staff> getStaff(Hospital aHospital)
    {
        return aHospital.getStaff();
    }
    
    
    
    /**
     * Returns all of the treated residents at aHospital.
     * @return a set containing all resident objects with true treated attribute 
     * value linked to aHospital.
     */
    public Set<Resident> getTreatedResidents(Hospital aHospital)
    {
        return aHospital.getTreatedResidents();
    }
    
    
    
    /**
     * Returns all of the untreated residents at aHospital.
     * @return a set containing all resident objects with false treated attribute 
     * value linked to aHospital.
     */
    public Set<Resident> getUntreatedResidents(Hospital aHospital)
    {
        return aHospital.getUntreatedResidents();
    }
    
    /**
     * Returns all of the vets employed at aHospital.
     * @param aHospital a hospital object.
     * @return all of the Vet objects linked to aHospital.
     */
    public Set<Vet> getVets(Hospital aHospital)
    {
        return aHospital.getVets();
    }
    
    
    /**
     * Returns all of the nurses employed at aHospital.
     * @param aHospital a hospital object.
     * @return all of the Nurse objects linked to aHospital.
     */
    public Set<Nurse> getNurses(Hospital aHospital)
    {
        return aHospital.getNurses();
    }
    
    
    
    /**
     * Records the treatment of aResident.
     * @param aResident a Resident object.
     * @return a boolean value representing whether the recording was successful.
     */
    public boolean recordTreatment(Resident aResident)
    {
        return aResident.recordTreatment();
    }
    
    
    /**
     * Returns all of the animals registered at aHospital.
     * @param aHospital a hospital object.
     * @return a set containing all animal objects with aHospital hospital 
     * attribute value.
     */
    public Set<Animal> getRegisteredAnimals(Hospital aHospital)
    {
        return aHospital.getRegisteredAnimals();
    }
    
    
    
    /**
     * Returns all aHospitals residents.
     * @param aHospital a hospital object.
     * @return a copy of aHospitals residents set.
     */
    public Set<Resident> getResidents(Hospital aHospital)
    {
        return aHospital.getResidents();
    }
    
    
    
    /**
     * If the resident is of a species the hospital can treat, and the hospital
     * is not full the resident is recorded.
     * @param aHospital a hospital object.
     * @param aResident a resident object.
     * @return a boolean value indicating whether the addition was successful.
     */
    public boolean addResident(Animal anAnimal, Hospital aHospital, 
                                LocalDate admissionDate, String illness,
                                boolean isTreated)
    {
        return aHospital.addResident(anAnimal, admissionDate, illness, isTreated);
    }
    
    
    
    /**
     * Removes any existing links between the staff member and any other hospital
     * and adds the staff member to aHospital.
     * @param aHospital a hospital object.
     * @param aStaff a staff object.
     * @return a boolean value indicating if the addition was successful.
     */
    public boolean addStaff(Hospital aHospital, Staff aStaff)
    {
        if(aHospital.addStaff(aStaff))
        {
            if(aStaff.getHospital() == null)
            {
                aStaff.getHospital().removeStaff(aStaff);
            
            }
            return aStaff.setHospital(aHospital);
        }
        return false;
    }
    
    
    
    /**
     * Removes any links between aHospital and aStaff.
     * @param aHospital a Hospital object.
     * @param aStaff a Staff object.
     * @return a boolean value indicating if the removal was successful.
     */
    public boolean removeStaff(Hospital aHospital, Staff aStaff)
    {
        return aHospital.removeStaff(aStaff);
    }
    
    
    
    /**
     * Removes a resident from aHospitals residents collection.
     * @param aHospital a hospital object.
     * @param aResident a resident object.
     * @return a boolean value indicating whether the removal was successful.
     */
    public boolean removeResident(Hospital aHospital, Resident aResident)
    {
        return aHospital.removeResident(aResident);
    }
    
    
    
    /**
     * Adds a new hospital to the system. The hospital must have a name, at least
     * 5 staff, be able to treat at least 1 species of animal and be able to house
     * at least 1 resident.
     * @param name the name of the hospital.
     * @param staffSet a set of staff employed at the hospital.
     * @param speciesSet the set of species the hospital can treat.
     * @param maxResidents the maximum number of residents the hospital can take.
     * @return a boolean value indicating if the addition was successful.
     */
    public boolean addHospital(String name, Set<Staff> staffSet, 
                                Set<Species> speciesSet, int maxResidents)
    {
        if(!name.equals("") && 
                staffSet.size() > 4 &&
                speciesSet.size() > 1 &&
                maxResidents > 0)
        {
            return this.hospitals.add(new Hospital(name, staffSet, speciesSet,
                                            maxResidents));
        }
        return false;
    }
    
    
    
    
    /**
     * Removes the given hospital from the system.
     * @param aHospital a hospital object.
     * @return a boolean value indicating if the removal was successful.
     */
    public boolean removeHospital(Hospital aHospital)
    {
        return this.hospitals.remove(aHospital);
    }
    
    
    
    /**
     * Returns all of aVets appointments.
     * @param aVet a Vet object.
     * @return a copy of aVets appointments collection.
     */
    public Set<Appointment> getAppointments(Vet aVet)
    {
        return aVet.getAppointments();
    }
        
        
        
        /**
     * Returns all of aOwners appointments.
     * @param aOwner a Owner object.
     * @return a copy of aOwners appointments collection.
     */
    public Set<Appointment> getAppointments(Owner aOwner)
    {
        return aOwner.getAppointments();
    }
       
            
    
    
    /**
     * If aHospital can treat aSpecies, then the new animal is added.
     * @param aHospital the hospital where the animal is to be registered.
     * @param aName the name of the animal
     * @param aSpecies the species of the animal
     * @param anOwner the owner of the animal
     * @return a boolean indicating whether the addition was successful.
     */
    public boolean addAnimal(Hospital aHospital, String aName, Species aSpecies,
                                Owner anOwner)
    {
        return aHospital.addAnimal(aName, aSpecies, anOwner);
    }
    
    
    
    
    /**
     * Removes anAnimal from anOwners registered animals.
     * @param anAnimal the animal to be removed
     * @return a boolean indicating if the removal was successful.
     */
    public boolean removeAnimal(Animal anAnimal)
    {
        return anAnimal.getOwner().removeAnimal(anAnimal);
    }
    
    
    
    
    /**
     * Removes anOwner from aHospitals records only if anOwner has no animals
     * registered with them.
     * @param aHospital the hospital to remove the record from.
     * @param anOwner the owner to remove.
     * @return a boolean value indicating whether or not the removal was successful.
     */
    public boolean removeOwner(Hospital aHospital, Owner anOwner)
    {
        return aHospital.removeOwner(anOwner);
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
}
