/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Kamil_2
 */
@Remote
public interface controlRemote {

    public String funkcja();

    public void dodajklienta(String name, String nazwisko, String haslo, String pesel);

    int findnumberofkat();

    void dodajksiazke(String nazwa, String autor, String isbn, String wydawca, String rokwydania, String kategoria);

    void edytujksiazke(int ID, String nazwa, String autor, String isbn, String wydawca, String rokwydania, String kategoria);

    int numberofbooks();

    int logowanie(String id, String haslo);
    
    List<String> rekordtabeli();
        
    void wypozyczKsiazke(int ID, int idksiazki);
     
    void usunKsiazke(int idksiazki);
    
    void rezerwujksiazke(int ID, int idksiazki, String data);
    
    //  List<String> lista();
    
    //  List<String> brakodbioru();
    
    
    
    
    
}
