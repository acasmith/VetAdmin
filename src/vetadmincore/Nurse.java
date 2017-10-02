/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincore;
import java.util.*;

/**
 * Models a nurse employed at a hospital. Specialises MedicalStaff.
 * @author Adam
 */
public class Nurse extends MedicalStaff{
    
    private Vet[] assignedTo;        //The vet(s) the nurse is assigned to.
    
    
    
    /**
     * Constructor
     * @param aPerson the nurses personal details.
     * @param aHospital the hospital the nurse works at.
     * @param qualifications the medical qualifications the nurse has.
     * @param assignedTo  a Vet the nurse is assigned to.
     */
    public Nurse(Person aPerson, Hospital aHospital,String qualifications,
                    Vet assignedTo)
    {
        super(aPerson, aHospital, qualifications);
        this.assignedTo = new Vet[2];
        this.assignedTo[0] = assignedTo;
    }
    
    
    
    /**
     * Returns the vet(s) the nurse is assigned to.
     * @return a copy of the assignedTo array linked to the receiver.
     */
    public Vet[] getAssignedTo()
    {
        Vet[] results = new Vet[2]; 
        System.arraycopy(this.assignedTo, 0, results,0, 2);
        return results;
    }
    
}
