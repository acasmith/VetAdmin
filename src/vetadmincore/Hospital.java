package vetadmincore;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Models a hospital within the veterinary business.
 * @author Adam
 */
public class Hospital implements Comparable<Hospital>{
    
    
    private String name;                //Name of the hospital of the hospital.
    private int maxResidents;           //Maximum number of resident animals.
    private Set<Species> typesTreated = new HashSet<Species>();  //Species of animal the hospital can treat.
    private  Set<Staff> staffMembers;    //Collection of staff employed at the hospital.
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
    public Hospital(String name, SortedSet<Staff> staffMembers, 
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
     *Returns all of the owners registered at this hospital
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
    
    
    
    
    /**
     * Assigns a vet to the given animal. The vet chosen is one who works at the
     * receiver with the fewest assigned animals.
     */
    public Vet assignVet(Animal anAnimal)
    {
        Vet availableVet = null;
        int lowestAssignedAnimals = Integer.MAX_VALUE;
        for(Vet aVet : anAnimal.getHospital().getVets())
        {
            if(aVet.getAssignedAnimals().size() < lowestAssignedAnimals)
            {
                lowestAssignedAnimals = aVet.getAssignedAnimals().size();
                availableVet = aVet;
            }
        }
        if(availableVet != null)
        {
            availableVet.addAnimal(anAnimal);
        }
        return availableVet;
        
        
        
        
    }
    
    
    
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
    
    
    
    /**
     * Checks to see if the owner is and assignedVet is free. If the assignedVet
     * is not free then all other vets at the hospital are tried to see if one is free.
     * If one is found then the appointment is made.
     * @param aDate the date of the appointment.
     * @param aTime the time of the appointment.
     * @param anAnimal the animal whom the appointment is for.
     * @return a boolean value indicating whether the appointment has been made
     * successfully or not.
     */
    public boolean addAppointment(LocalDate aDate, LocalTime aTime, Animal anAnimal)
    {
                    System.out.println("Got this far 1");
        if(anAnimal.getOwner().isFree(aDate, aTime)) //Checks owner is free
        {
                    System.out.println("Got this far 2");
            Vet freeVet = null;
                    System.out.println(anAnimal.getAssignedVet());
            if(anAnimal.getAssignedVet().isFree(aDate, aTime)) //Checks assigned vet
            {
                        System.out.println("Got this far 3");
                freeVet = anAnimal.getAssignedVet();
            }
            else                                    //Else checks all other vets.
            {
                        System.out.println("Got this far 3");
                for(Vet aVet : this.getVets())
                {
                    if(aVet.isFree(aDate, aTime))
                    {
                        freeVet = aVet;
                        break;
                    }
                }
            }
            if(freeVet != null)             //If a vet is free, make the appointment
            {
                        System.out.println("Got this far 4");
                Appointment apt = new Appointment(aDate, aTime, anAnimal, freeVet);
                anAnimal.getOwner().addAppointment(apt);
                freeVet.addAppointment(apt);
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * If the hospital can treat an animal of this species then a new animal is
     * registered to anOwner.
     * @param aName the animals name
     * @param aSpecies the animals species
     * @param anOwner the animal owner
     * @return a boolean value indicating if the addition was successful.
     */
    public boolean addAnimal(String aName, Species aSpecies, Owner anOwner)
    {
        if(this.getTypesTreated().contains(aSpecies))
        {
            return anOwner.addAnimal(new Animal(aName, aSpecies, anOwner, this));
                    
        }
        return false;
    }
    
    
    
    
    /**
     * Removes the owner from the hospital records as long as they do not have
     * an animal registered with the hospital.
     * @param anOwner the owner to remove.
     * @return a boolean value indicating whether or not the removal was successful.
     */
    public boolean removeOwner(Owner anOwner)
    {   
        for(Animal anAnimal : anOwner.getAnimals())
        {
            if(anAnimal.getHospital().equals(this))
            {
                return false;
            }
        }
        
        return this.owners.remove(anOwner);
    }
}
