/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka.dao;

import biblioteka.model.UzytkownikWypozycenia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kamil_2
 */
@Local
public interface UzytkownikWypozyceniaFacadeLocal {

    void create(UzytkownikWypozycenia uzytkownikWypozycenia);

    void edit(UzytkownikWypozycenia uzytkownikWypozycenia);

    void remove(UzytkownikWypozycenia uzytkownikWypozycenia);

    UzytkownikWypozycenia find(Object id);

    List<UzytkownikWypozycenia> findAll();

    List<UzytkownikWypozycenia> findRange(int[] range);

    int count();
    
}
