/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetadmincore;
import java.util.*;

/**
 * Coordinating class for the VetAdmin system. Uses the singleton pattern.
 * @author Adam
 */
public class VetAdminCoord {
    
    private static VetAdminCoord instance = null;
    public static int idCounter = 0;    //Used in creation of staff and owner objects.
    
    
    private SortedSet<Hospital> hospitals;
    private SortedSet<Owner> owners;
    
    
    /**
     * Private constructor to ensure only one instance exists at a time.
     * Initialises all collections to empty collections.
     */
    private VetAdminCoord()
    {
        this.hospitals = new TreeSet<>();
        this.owners = new TreeSet<>();
    }
    
    
    
    
    /**
     * Works as the public constructor. If there is no instance of VetAdminCoord
     * in existence then a new one is created and returned, otherwise a
     * reference to the existing one is returned.
     * @return a reference to a VetAdminCoord object.
     */
    public static VetAdminCoord getVetAdminCoord()
    {
        VetAdminCoord theCoord = VetAdminCoord.instance;
        
        if(theCoord == null)
        {
            theCoord = new VetAdminCoord();
            VetAdminCoord.instance = theCoord;
        }
        
        return theCoord;
    }

    
    
    
    
    /**
     * Returns the current idCounter value, then increments it by 1.
     * @return the integer value of idCounter.
     */
    public static int getIDCounter()
    {
        return VetAdminCoord.idCounter++;   
    }
    
    
    
    
    
    /**
     * Returns the hospitals within the business.
     * @return returns a copy of the hospitals sorted set 
     */
    public SortedSet<Hospital> getHospitals()
    {
        return new TreeSet<Hospital>(this.hospitals);
    }
    
    
    
    
    /**
     * Returns the hospitals within the business.
     * @return returns a copy of the hospitals sorted set 
     */
    public SortedSet<Owner> getOwners()
    {
        return new TreeSet<Owner>(this.owners);
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
}
