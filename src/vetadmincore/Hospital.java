package vetadmincore;
import java.time.LocalDate;
import java.util.*;

/**
 * Models a hospital within the veterinary business.
 * @author Adam
 */
public class Hospital implements Comparable<Hospital>{
    
    
    private String name;                //Name of the hospital of the hospital.
    private int maxResidents;           //Maximum number of resident animals.
    private Set<Species> typesTreated = new HashSet<Species>();  //Species of animal the hospital can treat.
    public  Set<Staff> staffMembers;    //Collection of staff employed at the hospital.
    private Set<Owner> owners;    //The owners registered at this hospital.
    private Set<Resident> residents;  //The animals currently resident in this hospital.
    
    
    
    /**
     * constructor
     * Initialises new Hospital objects with the provided data.
     * 
     * @param name          the name of the hospitals name.
     * @param staffMembers  a collection of all the employees at the hospital.
     * @param typesTreated  a collection of all the types currently treated by
     *                      the hospital.
     * @param maxResidents  the maximum number of resident animals.
     */
    public Hospital(String name, Set<Staff> staffMembers, 
                    Set<Species> typesTreated, int maxResidents)
    {
        this.name = name;
        this.typesTreated = typesTreated;
        this.maxResidents = maxResidents;
        this.staffMembers = staffMembers;
        this.owners = new HashSet<>();
        this.residents = new HashSet<>();
        
    }
    
    
    
    /**
     * Returns the name of the hospital.
     * @return a string representing the hospitals name.
     */
    public String getName()
    {
        return this.name;
    }
    
    
    
    /**
     * Returns the maximum number of residents.
     * @return an integer indicating the maximum number of residents.
     */
    public int getMaxResidents()
    {
        return this.maxResidents;
    }
    
    
    
    /**
     * Returns all of the species the hospital can treat.
     * @return a copy of the typesTreated collection.
     */
    public Set<Species> getTypesTreated()
    {
        return new HashSet<Species>(this.typesTreated);
    }
    
    
    
    /**
     *Returns all of the owners registered at this hospital.
     * @return a copy of the owners  set.
     */
    public Set<Owner> getOwners()
    {
        return this.owners;
    }
    
    
    
    /**
     * Returns all of the animals resident at the hospital.
     * @return a copy of the residents Set.
     */
    public Set<Resident> getResidents()
    {
        return new HashSet<Resident>(this.residents);
    }
    
    
    /**
     * Returns the hospitals name.
     *
     * @return a string representing the hospitals name.
     */
    @Override
    public String toString()
    {
        return this.getName();
    }
    
    
    
    /**
     * Returns true if the argument has the same name, can treat the same types
     * of animals and can handle the same amount of residents as the receiver.
     * 
     * @param   anObject is an object to be compared for equality.
     * 
     * @return  a boolean representing whether the receiver is equal to the
     * argument.
     */
    @Override
    public boolean equals(Object anObject)
    {
        if((anObject != null) && (anObject instanceof Hospital))
        {
            Hospital arg = (Hospital) anObject;
            boolean sameName = this.getName().equals(arg.getName());
            boolean sameMax = (this.getMaxResidents() == arg.getMaxResidents() ?
                    true : false);
            //Checks typesTreated is the same size.
            boolean canTreat = this.getTypesTreated().size() == 
                                arg.getTypesTreated().size();
            //If any elements of typesTreated is not present, sets false.
            for(Species aSpecies : this.getTypesTreated())
            {
                if(!arg.getTypesTreated().contains(aSpecies))
                {
                    canTreat = false;
                }
            }
            
            
            if(sameName && canTreat && sameMax)
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * Creates a hash based on the sum of the hash codes of the fields used to
     * determine equality (name, maxResidents, typesTreated) and the product of
     * two arbitrary primes.
     * 
     * @return an integer representing a hash code for the object.
     */
    @Override
    public int hashCode()
    {
        int result = 43 * 13;
        int equalsFieldsHash = this.getName().hashCode() + 
                                this.getMaxResidents() + 
                                this.getTypesTreated().hashCode();
        
        result = result + equalsFieldsHash;
        return result;
        
        
    }
    
    
    
    /**
     * Places hospitals in alphabetical order by name, with 'a' having highest 
     * priority.
     * 
     * @param aHospital a hospital object to compare against the receiver.
     * 
     * @return an integer indicating whether the receiver is less than, greater
     * than or equal to the argument.
     */
    @Override
    public int compareTo(Hospital aHospital) throws NullPointerException
    {
        if(aHospital == null)
        {
            throw new NullPointerException("The compareTo argument is null.");
        }
        
        //COmparison on name.
        int returnValue = this.getName().compareTo(aHospital.getName());
        return returnValue;
        
    }
    
    
    
    /**
     * Registers a new owner with the hospital.
     * @param aOwner an Owner object.
     * @return true if the owner was successfully added to the receivers owners
     * Set. Returns false if the owner is already registered.
     */
    public boolean addOwner(Owner anOwner)
    {
        return this.owners.add(anOwner);
    }
    
    
    
    /**
     * Returns all of the animals registered to the receiver.
     * @return a  set containing all of the animals registered at the 
     * hospital.
     */
    public Set<Animal> getRegisteredAnimals()
    {   
        Set<Animal> results = new HashSet<>();
        for(Owner anOwner : this.getOwners())
        {
            for(Animal anAnimal : anOwner.getAnimals())
            {
                if(anAnimal.getHospital().equals(this))
                {
                    results.add(anAnimal);
                }
            }
        }
        return results;
    }
    
    
    
    /**
     * Returns all of the staff members employed at the hospital.
     * @return a copy of the receivers staffMembers  set.
     */
    public Set<Staff> getStaff()
    {
        return new HashSet<>(this.staffMembers);
    }
    
    
    
    /**
     * Returns all of the treated residents at the hospital.
     * @return a set containing all of the resident objects in residents with a
     * true treated attribute.
     */
    public Set<Resident> getTreatedResidents()
    {
        Set<Resident> results = new HashSet<>();
        
        for(Resident aResident : this.getResidents())
        {
            if(aResident.hasBeenTreated())
            {
                results.add(aResident);
            }
        }
        
        return results;
    }
    
    
    
     /**
     * Returns all of the untreated residents at the hospital.
     * @return a set containing all of the resident objects in residents with a
     * false treated attribute.
     */
    public Set<Resident> getUntreatedResidents()
    {
        Set<Resident> results = new HashSet<>();
        
        for(Resident aResident : this.getResidents())
        {
            if(!aResident.hasBeenTreated())
            {
                results.add(aResident);
            }
        }
        
        return results;
    }
    
    
    
    /**
     * Returns all of the vets employed at the hospital.
     * @return a set containing all of the Vet objects within staffMembers.
     */
    public Set<Vet> getVets()
    {
        Set<Vet> results = new HashSet<>();
        for(Staff aStaff : this.getStaff())
        {
            if(aStaff instanceof Vet)
            {
                results.add((Vet)aStaff);
            }
        }
        return results;
    }
    
    
    
    /**
     * Returns all of the nurses employed at the hospital.
     * @return a set containing all of the Nurse objects within staffMembers.
     */
    public Set<Nurse> getNurses()
    {
        Set<Nurse> results = new HashSet<>();
        for(Staff aStaff : this.getStaff())
        {
            if(aStaff instanceof Nurse)
            {
                results.add((Nurse)aStaff);
            }
        }
        return results;
    }
    
    
    
    /**
     * Returns whether or not the hospital is currently full.
     * @return a boolean value representing whether or not the size of residents
     * is greater than the value of maxResidents.
     */
    public boolean isFull()
    {
        return this.getResidents().size() >= this.getMaxResidents();
    }
    
    
    
    //TODO
    /**
     * Assigns a vet to the given animal. The vet chosen is one who works at the
     * receiver with the fewest assigned animals.
     */
    /**public Vet assignVet(Animal anAnimal)
    {
        //TODO
        ////Remove any existing links between animal and vet before assigning a
        ////new one.
        return new Vet();
    }**/
    
    
    
   /**
    * If the resident is of a species the hospital can treat and the hospital is
    * not full then the resident is recorded.
    * @param aResident a resident object.
    * @return boolean value indicating whether or not the addition was successful.
    */ 
    public boolean addResident(Animal anAnimal, LocalDate admissionDate, 
                                String illness, boolean isTreated)
    {
        if(this.typesTreated.contains(anAnimal.getSpecies()) &&
                !this.isFull())
        {
            return this.residents.add(new Resident(anAnimal, this, admissionDate,
                                        illness, isTreated));
        }
        return false;
    }
    
    
    /**
     * Removes a staff members links to any other hospital and adds them to the 
     * hospital.
     * @param aStaff a Staff object.
     * @return a boolean value indicating if the staff member
     */
    public boolean addStaff(Staff aStaff)
    {
        return this.staffMembers.add(aStaff);
    }
    
    
    
    /**
     * Removes and links between the receiver and aStaff
     * @param aStaff a Staff object.
     * @return a boolean value indicating if the removal was successful.
     */
    public boolean removeStaff(Staff aStaff)
    {
        return this.getStaff().remove(aStaff);
    }
    
    
    
    /**
     * Removes aResident from the hospitals residents set.
     * @param aResident a resident object.
     * @return a boolean value indicating if the removal was successful.
     */
    public boolean removeResident(Resident aResident)
    {
        return this.residents.remove(aResident);
    }
}
