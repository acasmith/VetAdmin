package vetadmincore;

/**
 * An abstract class modelling the medical staff at a hospital. Specialises Staff.
 * @author Adam
 */
public abstract class MedicalStaff extends Staff {
    
    private String qualifications;      //The medical qualifications the member has acheived.
    
    
    
    /**
     * Constructor
     * @param aPerson       //The staff members personal details
     * @param aHospital     //The hospital the staff member works at.
     * @param qualifications   //The medical qualifications the staff member has.
     */
    public MedicalStaff(Person aPerson, Hospital aHospital, String qualifications)
    {
        super(aPerson, aHospital);
        this.qualifications = qualifications;
    }
    
    
    
    /**
     * Returns the medical qualifications the member has.
     * @return a string representing the medical qualifications the member has.
     */
    public String getQualifications()
    {
        return this.qualifications;
    }
    
    
    
    
}
