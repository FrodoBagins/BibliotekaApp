/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

import biblioteka.dao.UzytkownikFacadeLocal;
import biblioteka.dao.CategoryFacadeLocal;

import biblioteka.model.Uzytkownik;
import javax.ejb.EJB;

/**
 *
 * @author Kamil_2
 */
@Stateless(mappedName = "sesja")
public class control implements controlRemote {

    @EJB
    private UzytkownikFacadeLocal uzytkownikFacade;
    
    @EJB
    private CategoryFacadeLocal categoryFacade;

    @Override
    public String funkcja() {
        return "wynik";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void dodajklienta(String name, String nazwisko, String haslo, String pesel) {

        Uzytkownik uzytkownik = new Uzytkownik();

        uzytkownik.setName(name);
        uzytkownik.setNazwisko(nazwisko);
        uzytkownik.setHaslo(haslo);
        uzytkownik.setPesel(pesel);
        uzytkownik.setStan(0);

        uzytkownikFacade.create(uzytkownik);

    }

    @Override
    public int findnumberofkat() {
        
        return categoryFacade.count();
    }
}
