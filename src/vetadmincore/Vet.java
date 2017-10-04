/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincore;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Models a vet employed at a hospital. Specialises MedicalStaff.
 * @author Adam
 */
public class Vet extends MedicalStaff{
   
    private Nurse assistant;                    //The nurse assigned to help the vet.
    private Set<Appointment> appointments;      //The vets appointments.
    private Set<Animal> assignedAnimals;        //The animals the vet is directly assigned to.
    
    
    
    /**
     * Constructor
     * @param aPerson       //The vets personal details.
     * @param aHospital     //The hospital the vet works at.
     * @param qualifications    //The medical qualifications the Vet has achieved.
     */
    public Vet(Person aPerson, Hospital aHospital, String qualifications)
    {
        super(aPerson, aHospital, qualifications);
        this.appointments = new HashSet<>();
        this.assignedAnimals = new HashSet<>();
    }
    
    
    
    /**
     * Returns the nurse assigned to the vet.
     * @return the nurse object linked to the receiver.
     */
    public Nurse getNurse()
    {
        return this.assistant;
    }
    
    
    
    /**
     * Returns the vets appointments.
     * @return a copy of the receivers appointments set.
     */
    public Set<Appointment> getAppointments()
    {
        return new HashSet<Appointment>(this.appointments);
    }
    
    
    
    /**
     * Returns the animals assigned to the vet.
     * @return a copy of the receivers assignedAnimals set.
     */
    public Set<Animal> getAssignedAnimals()
    {
        return new HashSet<Animal>(this.assignedAnimals);
    }
    
    
    
    /**
     * Assigns a new animal to the vet.
     * @param anAnimal an Animal object.
     * @return a boolean indicating whether the addition was successful.
     */
    public boolean addAnimal(Animal anAnimal)
    {
        return this.assignedAnimals.add(anAnimal);
    }
    
    
    
    /**
     * Adds a new appointment to the vets appointments.
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
