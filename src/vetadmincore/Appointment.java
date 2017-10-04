
package vetadmincore;
import java.time.*;

/**
 * Models an appointment made by an owner for a vet to see an animal.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincore;

/**
 *

 * @author Adam
 */
public class Appointment {
    

    private LocalDate date;                 //Date of the appointment.
    private LocalTime time;                 //Time of the appointment.
    private Animal patient;                 //The animal to be seen.
    private Vet vet;                        //The vet leading the appointment.
    
    //Hospital and Owner can be derived!
    
    
    /**
     * Constructor
     * @param aHospital Hospital where the appointment takes place.
     * @param aDate Date and time of the appointment.
     * @param aTime time the appointment will take place.
     * @param aAnimal The animal to be seen.
     * @param aVet The vet leading the appointment.
     */
    public Appointment(LocalDate aDate, LocalTime aTime,
                        Animal aAnimal, Vet aVet)
    {
        this.date = aDate;
        this.time = aTime;
        this.patient = aAnimal;
        this.vet = aVet;
    }
    
    
    /**
     * Returns the date of the appointment in yyyy-mm-dd format.
     * @return a LocalDate object representing the date of the appointment.
     */
    public LocalDate getDate()
    {
        return this.date;
    }
    
    
    
    /**
     * Returns the time of the appointment in hh-mm format.
     * @return 
     */
    public LocalTime getTime()
    {
        return this.time;
    }
    
    
    
    /**
     * Returns the patient being seen in the appointment.
     * @return the animal object linked to the receiver.
     */
    public Animal getPatient()
    {
        return this.patient;
    }
    
    
    
    /**
     * Returns the vet taking the appointment
     * @return the vet object linked to the receiver.
     */
    public Vet getVet()
    {
        return this.vet;
    }
    
    
    /**
     * Returns the patient, vet, date and time of the appointment.
     * @return a string representing the appointment in "thePatient with theVet
     * on theDate at theTime" format.
     */
    @Override
    public String toString()
    {
        return this.getPatient() + " with " + this.getVet() + " on " + this.getDate() +
                " at " + this.getTime() + ".";
    }
    
    
    
    /**
     * Checks whether the receiver and argument represent the same appointment.
     * Returns true if the argument is an instance of Appointment and has the same 
     * patient, vet, date and time values.
     * 
     * @param anObject  the object to compare against the receiver.
     * @return a boolean representing whether the receiver and argument are equal.
     */
    @Override
    public boolean equals(Object anObject)
    {
        if((anObject != null) && (anObject instanceof Appointment))
        {
            Appointment arg = (Appointment)anObject;
            if(this.getPatient().equals(arg.getPatient()) &&
                    this.getVet().equals(arg.getVet()) &&
                    this.getDate().equals(arg.getDate()) &&
                    this.getTime().equals(arg.getTime()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    /**
     * Creates a hash based on the sum of the hash codes of the fields used to
     * determine equality (patient, vet) and the product of
     * two arbitrary primes.
     * 
     * @return an integer representing a hash code for the object.
     */
    public int hashCode()
    {
        int result = 47 * 13;
        int equalsFieldsHash = this.getPatient().hashCode() + 
                                this.getVet().hashCode() +
                                this.getDate().hashCode() +
                                this.getTime().hashCode();
        return result + equalsFieldsHash;
    }
    


}
