/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka.dao;

import biblioteka.model.Uzytkownik;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kamil_2
 */
@Local
public interface UzytkownikFacadeLocal {

    void create(Uzytkownik uzytkownik);

    void edit(Uzytkownik uzytkownik);

    void remove(Uzytkownik uzytkownik);

    Uzytkownik find(Object id);

    List<Uzytkownik> findAll();

    List<Uzytkownik> findRange(int[] range);

    int count();
    
}
