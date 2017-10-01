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
public class Vet {
    
    Hospital hospital;          //the hospital the vet is employed at.
    
    
    /**
     * Returns the hospital the vet is employed at.
     * @return the Hospital object referenced by hospital.
     */
    public Hospital getHospital()
    {
        return this.hospital;
    }
}
