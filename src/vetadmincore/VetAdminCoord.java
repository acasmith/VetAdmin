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
public class VetAdminCoord {
    
    public static int idCounter = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    /**
     * Returns the current idCounter value, then increments it by 1.
     * @return the integer value of idCounter.
     */
    public static int getIDCounter()
    {
        return VetAdminCoord.idCounter++;   
    }
}
