/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincore;
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
    

    
    
    
}
