package vetadmincore;
import java.util.*;

/**
 * Models a hospital within the veterinary business.
 * @author Adam
 */
public class Hospital implements Comparable<Hospital>{
    
    
    private String name;                //Name of the hospital of the hospital.
    private int maxResidents;           //Maximum number of resident animals.
    private Set<Species> typesTreated = new HashSet<Species>();  //Species of animal the hospital can treat.
    private SortedSet<Staff> staffMembers;    //Collection of staff employed at the hospital.
    private SortedSet<Owner> owners;    //The owners registered at this hospital.
    private SortedSet<Resident> residents;  //The animals currently resident in this hospital.
    
    
    
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
    public Hospital(String name, SortedSet<Staff> staffMembers, 
                    Set<Species> typesTreated, int maxResidents)
    {
        this.name = name;
        this.typesTreated = typesTreated;
        this.maxResidents = maxResidents;
        this.staffMembers = staffMembers;
        this.owners = new TreeSet<>();
        this.residents = new TreeSet<>();
        
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
     * @return a copy of the owners sorted set.
     */
    public SortedSet<Owner> getOwners()
    {
        return this.owners;
    }
    
    
    
    /**
     * Returns all of the animals resident at the hospital.
     * @return a copy of the residents sortedSet.
     */
    public SortedSet<Resident> getResidents()
    {
        return this.residents;
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
        
        String receiverName = this.getName().trim().toLowerCase();
        String argName = aHospital.getName().trim().toLowerCase();
        int returnValue = 0;
        
        //Catches equality
        if(receiverName.equals(argName))
        {
            return returnValue;
        }
        //Performs character comparisons on name attributes.
        else
        {
            for(int i = 0; i < receiverName.length() && i < argName.length(); i++)
            {
                if(receiverName.charAt(i) < argName.charAt(i))
                {
                    returnValue = -1;
                    break;
                }
                else if(receiverName.charAt(i) > argName.charAt(i))
                {
                    returnValue = 1;
                    break;
                }
            }
        }
        
        /*Catches where one string is shorter than the other, but is also a 
        substring of the longer string. Shorter has priority. */
        if(returnValue == 0)
        {
            returnValue = (receiverName.length() < argName.length()) ? -1 : 1;
        }
        return returnValue;
    }
    
    
    
    /**
     * Registers a new owner with the hospital.
     * @param aOwner an Owner object.
     * @return true if the owner was successfully added to the receivers owners
     * sortedSet. Returns false if the owner is already registered.
     */
    public boolean addOwner(Owner anOwner)
    {
        return this.owners.add(anOwner);
    }
    
    
    /**
     * Returns all of the animals registered to the receiver.
     * @return a sorted set containing all of the animals registered at the 
     * hospital.
     */
    public SortedSet<Animal> getRegisteredAnimals()
    {   
        SortedSet<Animal> results = new TreeSet<>();
        for(Owner anOwner : this.getOwners())
        {
            for(Animal anAnimal : anOwner.getAnimals())
            {
                results.add(anAnimal);
            }
        }
        return results;
    }
    
    
    
    /**
     * Assigns a vet to the given animal. The vet chosen is one who works at the
     * receiver with the fewest assigned animals.
     */
    public Vet assignVet(Animal anAnimal)
    {
        //TODO
        ////Remove any existing links between animal and vet before assigning a
        ////new one.
        return new Vet();
    }
}
