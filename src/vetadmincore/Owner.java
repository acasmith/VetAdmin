package vetadmincore;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Models an owner of an animal, registered at one or more of the companies
 * hospitals.
 * @author Adam
 */
public class Owner implements Comparable<Owner> {
    
    private boolean staffDiscount;
    private final int iD;
    private Person thePerson;
    private Set<Hospital> hospitals;
    public Set<Animal> animals;
    private Set<Appointment> appointments;
    
    
    /**
     * Constructor
     * @param aHospital the hospital the owner is registering at.
     * @param aPerson   the person details of the owner.
     * @param hasDiscount whether the owner is entitled to staff discount.
     */
    public Owner(Hospital aHospital, Person aPerson, boolean hasDiscount)
    {
        this.iD = VetAdminCoord.getIDCounter();
        this.staffDiscount = hasDiscount;
        this.thePerson = aPerson;
        this.hospitals = new HashSet<>();
        this.animals = new HashSet<>();
        this.appointments = new HashSet<>();
        this.hospitals.add(aHospital); 
    }
    
    
    
    
    /**
     * Returns the owners title.
     * @return a string representing the owners title.
     */
    public String getTitle()
    {
        return this.thePerson.getTitle();
    }
    
    
    
    
    /**
     * Returns the owners first name.
     * @return a string representing the owners first name.
     */
    public String getFirstName()
    {
        return this.thePerson.getFirstName();
    }
    
    
    
    
   /**
     * Returns the owners last name.
     * @return a string representing the owners last name.
     */
    public String getLastName()
    {
        return this.thePerson.getLastName();
    }
    
    
    
    
    /**
     * Returns the owners contact address.
     * @return a string representing the owners contact address.
     */
    public String getAddress()
    {
        return this.thePerson.getAddress();
    }
    
    
    
    
     /**
     * Returns the owners email address.
     * @return a string representing the owners email address.
     */
    public String getEmailAddress()
    {
        return this.thePerson.getEmailAddress();
    }    
    
    
    
    
    /**
     * Returns the owners phoneNumber.
     * @return a string representing the owners phoneNumber.
     */
    public String getPhoneNumber()
    {
        return this.thePerson.getPhoneNumber();
    }
    
    
    
    
     /**
     * Returns the owners ID number.
     * @return an integer representing the owners ID.
     */
    public int getID()
    {
        return this.iD;
    }
    
    
    
    
    /**
     * Returns whether the owner is entitled to staff discount.
     * @return a boolean representing whether the owner has staff discount.
     */
    public boolean hasStaffDiscount()
    {
        return this.staffDiscount;
    }
    
    
    
    
    /**
     * Returns a collection of all the animals the owner has registered with
     * the hospital.
     * @return a copy of the animals  set.
     */
    public Set<Animal> getAnimals()
    {
        return new HashSet<Animal>(this.animals);
    }
    
    
    
    
    /**
     * Returns a collection of all the hospitals the owner is registered with.
     * @return a copy of the hospitals  set.
     */
    public Set<Hospital> getHospitals()
    {
        return new HashSet<Hospital>(this.hospitals);
    }
    
    
    
    
    /**
     * Returns a collection of all the appointments the owner currently has.
     * @return a copy of the appointments  set.
     */
    public Set<Appointment> getAppointments()
    {
        return new HashSet<Appointment>(this.appointments);
    }
    
    
    
    
    /**
     * Returns the owners full name.
     * @return a string representing the owners full name.
     */
    @Override
    public String toString()
    {
        return this.thePerson.toString();
    }
    
    
    
    
    /**
     * Checks whether the receiver and argument represent the same person.
     * Returns true if the argument is an instance of Owner and has the same 
     * name and address as the receiver.
     * 
     * @param anObject  the object to compare against the receiver.
     * @return a boolean representing whether the receiver and argument are equal.
     */
    @Override
    public boolean equals(Object anObject)
    {
        if((anObject != null) && (anObject instanceof Owner))
        {
            Owner arg = (Owner)anObject;
            if(this.toString().equals(arg.toString()) &&
                    this.getAddress().equals(arg.getAddress()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    /**
     * Creates a hash based on the sum of the hash codes of the fields used to
     * determine equality (name, address) and the product of
     * two arbitrary primes.
     * 
     * @return an integer representing a hash code for the object.
     */
    public int hashCode()
    {
        int result = 47 * 13;
        int equalsFieldsHash = this.toString().hashCode() + 
                                this.getAddress().hashCode();
        return result + equalsFieldsHash;
    }
    
    
    
    
     /**
     * Places owner objects in alphabetical order by last name, with 'a' having
     * the highest priority.
     * 
     * @param aOwner   another owner object to compare the receiver against.
     * 
     * @return a positive integer if the receiver comes after the argument, 
     * negative if it comes before the argument or 0 if they are equal.
     */
    @Override
    public int compareTo(Owner aOwner) throws NullPointerException
    {
        //Checks if the argument is null.
        if(aOwner == null)
        {
            throw new NullPointerException("The compareTo argument is null");
        }
        
        //checks for equality.
        if(this.equals(aOwner))
        {
            return 0;
        }
        
        String receiverName = this.getLastName().trim().toLowerCase();
        String argName = aOwner.getLastName().trim().toLowerCase();
        int returnValue = 0;
        
        //Performs character comparisons on the lastName attribute.
        for(int i = 0; i < receiverName.length() && i < argName.length(); i++)
        {
            if(receiverName.charAt(i) > argName.charAt(i))
            {
                returnValue = 1;
                break;
            }
            else if(receiverName.charAt(i) < argName.charAt(i))
            {
                returnValue = -1;
                break;
            }
        }
        
        //Catches where one string is shorted than the other, but is a substring.
        if((returnValue == 0) && (receiverName.length() != argName.length()))
        {
            returnValue = (receiverName.length() < argName.length()) ? -1 : 1;
        }
        
        return returnValue;
        
        
        
        
    }
    
    
    
    /**
     * Registers a new animal to the owner.
     * @param aAnimal an animal object to register to the owner.
     * @return returns true if the animal is successfully added to the receivers
     * animals Set. Returns false if the animal is already registered to
     * the owner.
     */
    public boolean addAnimal(Animal anAnimal)
    {
        return this.animals.add(anAnimal);
    }
    
    
    
    /**
     * Adds a new appointment to the owners appointments.
     * @param anApt an Appointment object.
     * @return a boolean indicating whether the addition was successful.
     */
    public boolean addAppointment(Appointment anApt)
    {
        return this.appointments.add(anApt);
    }
    
    
    
    /**
     * Checks to see if the vet has an appointment at the given date and time.
     * @param aDate the date of the appointment.
     * @param aTime the time of the appointment.
     * @return a boolean value indicated whether or not the receiver does not have
     * an appointment at that date and time.
     */
    public boolean isFree(LocalDate aDate, LocalTime aTime)
    {
        for(Appointment anAppointment : this.getAppointments())
            {

                if(anAppointment.getDate().equals(aDate) && 
                        anAppointment.getTime().equals(aTime))
                {
                    return false;
                }
            }
        return true;
    }
    
}
