package vetadmincore;

import java.time.LocalDate;

/**
 * Models an animals residential stay at a hospital.
 * @author Adam
 */
public class Resident implements Comparable<Resident>{
    
    private LocalDate admissionDate;        //The date of admission.
    private String reasonForAdmission;      //the medical condition of the animal.
    private boolean treated;                //whether the animal has received treatment.
    private Animal theAnimal;               //The animal being treated.
    private Hospital hospital;              //The hospital where the animal is staying.
    
    
    public Resident(Animal anAnimal, Hospital aHospital, LocalDate admissionDate, String illness,
                        boolean treated)
    {
        this.admissionDate = admissionDate;
        this.reasonForAdmission = illness;
        this.treated = treated;
        this.theAnimal = anAnimal;
        this.hospital = aHospital;
    }
    
    
    /**
     * Returns the date the resident was admitted to the hospital.
     * @return the LocalDate object representing the admission date.
     */
    public LocalDate getAdmissionDate()
    {
        return this.admissionDate;
    }
    
    
    
    /**
     * Returns the reason for the residents admission.
     * @return a string representing the reason for admission.
     */
    public String getReasonForAdmission()
    {
        return this.reasonForAdmission;
    }
    
    
    
    /**
     * Returns whether the animal has been treated yet or not.
     * @return a boolean value indicating whether or not the resident has been treated.
     */
    public boolean hasBeenTreated()
    {
        return this.treated;
    }
    
    
    
    /**
     * Returns the hospital the resident is staying at.
     * @return the hospital object linked to the receiver.
     */
    public Hospital getHospital()
    {
        return this.hospital;
    }
    
    
    
    /**
     * Returns the residents name.
     * @return a string representing the animals name.
     */
    public String getName()
    {
        return this.theAnimal.getName();
    }
    
    
    
    /**
     * Returns the residents species.
     * @return a Species enum value representing the animals species.
     */
    public Species getSpecies()
    {
        return this.theAnimal.getSpecies();
    }
    
    
    
    /**
     * Returns the residents owner.
     * @return reference to the owner object referenced by owner.
     */
    public Owner getOwner()
    {
        return this.theAnimal.getOwner();
    }
    
    
    
    /**
     * Returns the vet the resident is assigned to.
     * @return reference to the vet object referenced by assignedVet.
     */
    public Vet getAssignedVet()
    {
        return this.theAnimal.getAssignedVet();
    }
    
    
    
    /**
     * Returns the hospital the resident is registered at.
     * @return reference to the hospital object referenced by registeredAt.
     */
    public Hospital getRegisteredHospital()
    {
        return this.theAnimal.getAssignedVet().getHospital();
    }
    
    
    
    /**
     * Returns the residents name and species.
     * @return a string representing the animals name and species.
     */
    @Override
    public String toString()
    {
        return this.getName() + " the " + this.getSpecies();
    }
    
    
    
    /**
     * Checks whether the receiver and argument represent the same resident.
     * Returns true if the argument is an instance of resident, is the same
     * animal, is staying at the same hospital and has the same admission date.
     * 
     * @param anObject  the object to compare against the receiver.
     * @return a boolean representing whether the receiver and argument are equal.
     */
    @Override
    public boolean equals(Object anObject)
    {
        if((anObject != null) && (anObject instanceof Resident))
        {
            Resident arg = (Resident)anObject;
            if(this.getName().equals(arg.getName()) &&
                    this.getSpecies().equals(arg.getSpecies()) &&
                    this.getOwner().equals(arg.getOwner()) &&
                    this.getAdmissionDate().equals(arg.getAdmissionDate()) &&
                    this.getHospital().equals(arg.getHospital()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    /**
     * Creates a hash based on the sum of the hash codes of the fields used to
     * determine equality (animal, hospital and admission date) and the product of
     * two arbitrary primes.
     * 
     * @return an integer representing a hash code for the object.
     */
    public int hashCode()
    {
        int result = 47 * 13;
        int equalsFieldsHash = this.getName().hashCode() +
                                this.getSpecies().hashCode() +
                                this.getOwner().hashCode() +
                                this.getHospital().hashCode() +
                                this.getAdmissionDate().hashCode();
        return result + equalsFieldsHash;
    }
    
    
    
    /**
     * Places resident objects in alphabetical order by name with 
     * 'a' having the highest priority.
     * 
     * @param aResident   another Resident object to compare the receiver against.
     * 
     * @return a positive integer if the receiver comes after the argument, 
     * negative if it comes before the argument or 0 if they are equal.
     */
    @Override
    public int compareTo(Resident aResident) throws NullPointerException
    {
        //Checks if the argument is null.
        if(aResident == null)
        {
            throw new NullPointerException("The compareTo argument is null");
        }
        
        
        int returnValue = this.getName().compareTo(aResident.getName());
        return returnValue;
        
    }
    
    
    
    
    /**
     * Records the treatment of the resident.
     * @return sets the treated value to true.
     */
    public boolean recordTreatment()
    {
        this.treated = true;
        return true;
    }
}
