package vetadmincore;

/**
 * Models a member of staff employed at a hospital. Generalises MedicalStaff.
 * @author Adam
 */
public class Staff implements Comparable<Staff>{
    
    private int iDNumber;       //Unique ID number   
    private Person thePerson;   //Personal details
    private Hospital hospital;  //The hospital the staff member works at.
    
    
    /**
     * Constructor
     * @param aPerson the personal details of the staff member.
     * @param aHospital the hospital where the staff member works.
     */
    public Staff(Person aPerson, Hospital aHospital)
    {
        this.iDNumber = VetAdminCoord.getIDCounter();
        this.thePerson = aPerson;
        this.hospital = aHospital;
    }
    
    
    
    
    /**
     * Returns the persons title.
     * @return a string representing the persons title.
     */
    public String getTitle()
    {
        return this.thePerson.getTitle();
    }
    
    
    /**
     * Returns the staff members first name.
     * @return a string representing the staff members first name.
     */
    public String getFirstName()
    {
        return this.thePerson.getFirstName();
    }
    
    
    
    /**
     * Returns the staff members last name.
     * 
     * @return a string representing the staff members last name. 
     */
    public String getLastName()
    {
        return this.thePerson.getLastName();
    }
    
    
    
    /**
     * Returns the staff members address.
     * @return a string representing the staff members address.
     */
    public String getAddress()
    {
        return this.thePerson.getAddress();
    }
    
    
    
    /**
     * Returns the staff members email address.
     * @return a string representing the staff members email address.
     */
    public String getEmailAddress()
    {
        return this.thePerson.getEmailAddress();
    }
    
    
    
    
    /**
     * Returns the staff members phone number.
     * @return a string representing the staff members phone number.
     */
    public String getPhoneNumber()
    {
        return this.thePerson.getPhoneNumber();
    }
    
    
    
    /**
     * Returns the staff members unique ID number.
     * @return an integer representing the staff members unique ID.
     */
    public int getID()
    {
        return this.iDNumber;
    }
    
    
    
    /**
     * Returns the staff members title, first name and last name.
     * @return a string representing the staff members title, first name and 
     * last name.
     */
    @Override
    public String toString()
    {
        return this.thePerson.toString();
    }
    
    
    
    /**
     * Returns the hospital the staff member works at.
     * @return the hospital object linked to the receiver.
     */
    public Hospital getHospital()
    {
        return this.hospital;
    }
    
    
    
    
    
    /**
     * Checks whether the receiver and argument represent the same person.
     * Returns true if the argument is an instance of Staff and has the same 
     * name and address as the receiver.
     * 
     * @param anObject  the object to compare against the receiver.
     * @return a boolean representing whether the receiver and argument are equal.
     */
    @Override
    public boolean equals(Object anObject)
    {
        if((anObject != null) && (anObject instanceof Staff))
        {
            Staff arg = (Staff)anObject;
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
     * Places staff objects in alphabetical order by last name then first name, 
     * with 'a' having the highest priority.
     * 
     * @param aStaff   another staff object to compare the receiver against.
     * 
     * @return a positive integer if the receiver comes after the argument, 
     * negative if it comes before the argument or 0 if they are equal.
     */
    @Override
    public int compareTo(Staff aStaff) throws NullPointerException
    {
        //Checks if the argument is null.
        if(aStaff == null)
        {
            throw new NullPointerException("The compareTo argument is null");
        }
        
        //checks for equality.
        if(this.equals(aStaff))
        {
            return 0;
        }
        
        //Primary comparison by last name
        int returnValue = this.getLastName().compareTo(aStaff.getLastName());
        //Secondary comparison by first name, if last names are equal.
        returnValue = (returnValue == 0) ? 
                        this.getFirstName().compareTo(aStaff.getFirstName()) : returnValue;
        //Tertiary comparison based on address
        returnValue = (returnValue == 0) ?
                        this.getAddress().compareTo(aStaff.getAddress()) : returnValue;
        
        
        return returnValue;
        
    }
    
    
    
    
    
    
    
}
