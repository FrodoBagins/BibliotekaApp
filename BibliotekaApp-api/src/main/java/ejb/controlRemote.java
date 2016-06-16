/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author Kamil_2
 */
@Remote
public interface controlRemote {
    
    public String funkcja();
    
    public void dodajklienta(String name, String nazwisko, String haslo, String pesel);
}
