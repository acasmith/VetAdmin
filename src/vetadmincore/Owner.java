/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincore;
import java.util.*;

/**
 *
 * @author Adam
 */
public class Owner {
    
    private boolean staffDiscount;
    private final int iD;
    private Person thePerson;
    private SortedSet<Hospital> hospitals;
    private SortedSet<Animal> animals;
    private SortedSet<Appointment> appointments;
    
    
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
        this.hospitals = new TreeSet<>();
        this.animals = new TreeSet<>();
        this.appointments = new TreeSet<>();
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
     * @return a copy of the animals sorted set.
     */
    public SortedSet<Animal> getAnimals()
    {
        return new TreeSet<Animal>(this.animals);
    }
    
    
    
    
    /**
     * Returns a collection of all the hospitals the owner is registered with.
     * @return a copy of the hospitals sorted set.
     */
    public SortedSet<Hospital> getHospitals()
    {
        return new TreeSet<Hospital>(this.hospitals);
    }
    
    
    
    
    /**
     * Returns a collection of all the appointments the owner currently has.
     * @return a copy of the appointments sorted set.
     */
    public SortedSet<Appointment> getAppointments()
    {
        return new TreeSet<Appointment>(this.appointments);
    }
}
