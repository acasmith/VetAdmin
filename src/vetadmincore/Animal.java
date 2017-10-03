package vetadmincore;

/**
 * Represents an animal registered at one of the hospitals in the system.
 * @author Adam
 */
public class Animal implements Comparable<Animal>{
    
    private final String name;                //Name of the animal
    private final Species species;            //The animals species.
    private final Owner owner;                //The animals owner.
    private Vet assignedVet;            //The vet assigned to the animal.
    private Hospital hospital;          //The hospital the animal is registered at.
    
    
    /**
     * Constructor
     * @param name Name of the animal
     * @param species The animals species.
     * @param owner The animals owner.
     */
    public Animal(String name, Species species, Owner owner, 
                    Hospital registeredHospital)
    {
        this.name = name;
        this.species = species;
        this.owner = owner;
        this.hospital = registeredHospital;
        this.assignedVet = this.getHospital().assignVet(this);
    }
    
    
    
    /**
     * Returns the hospital the animal is registered at.
     * @return the hospital object linked to the receiver.
     */
    public Hospital getHospital()
    {
        return this.hospital;
    }
    
    
    
    /**
     * Returns the animals name.
     * @return a string representing the animals name.
     */
    public String getName()
    {
        return this.name;
    }
    
    
    
    /**
     * Returns the animals species.
     * @return a Species enum value representing the animals species.
     */
    public Species getSpecies()
    {
        return this.species;
    }
    
    
    
    /**
     * Returns the animals owner.
     * @return reference to the owner object referenced by owner.
     */
    public Owner getOwner()
    {
        return this.owner;
    }
    
    
    
    /**
     * Returns the vet the animal is assigned to.
     * @return reference to the vet object referenced by assignedVet.
     */
    public Vet getAssignedVet()
    {
        return this.assignedVet;
    }
    
    
    
    /**
     * Returns the hospital the animal is registered at.
     * @return reference to the hospital object referenced by registeredAt.
     */
    public Hospital getRegisteredHospital()
    {
        return this.getAssignedVet().getHospital();
    }
    
    
    
    /**
     * Returns the animals name and species.
     * @return a string representing the animals name and species.
     */
    @Override
    public String toString()
    {
        return this.getName() + " the " + this.getSpecies();
    }
    
    
    
    /**
     * Checks whether the receiver and argument represent the same animal.
     * Returns true if the argument is an instance of animal and has the same 
     * name, species and owner.
     * 
     * @param anObject  the object to compare against the receiver.
     * @return a boolean representing whether the receiver and argument are equal.
     */
    @Override
    public boolean equals(Object anObject)
    {
        if((anObject != null) && (anObject instanceof Animal))
        {
            Animal arg = (Animal)anObject;
            if(this.toString().equals(arg.toString()) &&
                    this.getOwner().equals(arg.getOwner()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    /**
     * Creates a hash based on the sum of the hash codes of the fields used to
     * determine equality (name, species and owner) and the product of
     * two arbitrary primes.
     * 
     * @return an integer representing a hash code for the object.
     */
    public int hashCode()
    {
        int result = 47 * 13;
        int equalsFieldsHash = this.toString().hashCode() + 
                                this.getOwner().hashCode();
        return result + equalsFieldsHash;
    }
    
    
    
    /**
     * Places animal objects in alphabetical order by species, then name with 'a'
     * having the highest priority.
     * 
     * @param aAnimal   another animal object to compare the receiver against.
     * 
     * @return a positive integer if the receiver comes after the argument, 
     * negative if it comes before the argument or 0 if they are equal.
     */
    @Override
    public int compareTo(Animal aAnimal) throws NullPointerException
    {
        //Checks if the argument is null.
        if(aAnimal == null)
        {
            throw new NullPointerException("The compareTo argument is null");
        }
        
        //checks for equality.
        if(this.equals(aAnimal))
        {
            return 0;
        }
        
        
        String receiverSpecies = this.getSpecies().name();
        String argSpecies = aAnimal.getSpecies().name();
        
        //Primary comparison against species.
        int returnValue = receiverSpecies.compareTo(argSpecies);

        //Secondary comparies checks against name attribute if same species.
        if(returnValue == 0)
        {
            returnValue = this.getName().compareTo(aAnimal.getName());
        }
        
        return returnValue;
        
    }
        
        
    
    
    
        
        
        
  
    
}
