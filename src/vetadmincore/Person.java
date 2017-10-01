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
public class Person implements Comparable<Person>{
    
    private String title;
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String phoneNumber;
    
    
    
    
    /**
     * Constructor
     * @param title     the persons title.
     * @param firstName the persons first name.
     * @param lastName  the persons last name.
     * @param address   the persons contact address.
     * @param emailAddress  the persons email address.
     * @param phoneNumber   the persons phoneNumber.
     */
    public Person(String title, String firstName, String lastName, 
                    String address, String emailAddress, String phoneNumber)
    {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    
    
    
    
    /**
     * Returns the persons title.
     * @return a string representing the persons title.
     */
    public String getTitle()
    {
        return this.title;
    }  
    
    
    
    
    /**
     * Returns the persons first name.
     * @return a string representing the persons first name.
     */
    public String getFirstName()
    {
        return this.firstName;
    }
    
    
    
    /**
     * Returns the persons lastName.
     * @return a string representing the persons last name.
     */
    public String getLastName()
    {
        return this.lastName;
    }
    
    
    
    
    /**
     * Returns the persons email address.
     * @return a string representing the persons email address.
     */
    public String getEmailAddress()
    {
        return this.emailAddress;
    }
    
    
    
    
    /**
     * Returns the person phone number.
     * @return a string representing the persons phone number.
     */
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    
    
    
    
    /**
     * Returns the persons address.
     * @return a string representing the persons address.
     */
    public String getAddress()
    {
        return this.address;
    }
    
    
    
    
    /**
     * Returns the persons full name.
     * @return a string representing the persons title, first name and last name.
     */
    @Override
    public String toString()
    {
        return this.title + " " + this.firstName + " " + this.lastName;
    }
    
    
    
    
    /**
     * Returns true if the argument is an instance of Person and has the same
     * name and address as the receiver.
     * @param anObject  the object to compare against the receiver.
     * @return a boolean representing whether the receiver and argument are equal.
     */
    @Override
    public boolean equals(Object anObject)
    {
        if((anObject != null) && (anObject instanceof Person))
        {
            Person arg = (Person) anObject;
            
            if((this.toString().equals(arg.toString())) && 
                    this.getAddress().equals(arg.getAddress()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    /**
     * Places person objects in alphabetical order by last name, with 'a' having
     * the highest priority.
     * 
     * @param aPerson   another person object to compare the receiver against.
     * 
     * @return a positive integer if the receiver comes after the argument, 
     * negative if it comes before the argument or 0 if they are equal.
     */
    @Override
    public int compareTo(Person aPerson) throws NullPointerException
    {
        //Checks if the argument is null.
        if(aPerson == null)
        {
            throw new NullPointerException("The compareTo argument is null");
        }
        
        //checks for equality.
        if(this.equals(aPerson))
        {
            return 0;
        }
        
        String receiverName = this.getLastName().trim().toLowerCase();
        String argName = aPerson.getLastName().trim().toLowerCase();
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
}
