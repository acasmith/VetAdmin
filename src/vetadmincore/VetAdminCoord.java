package vetadmincore;
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
}
