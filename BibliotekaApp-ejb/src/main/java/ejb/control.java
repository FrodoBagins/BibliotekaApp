/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

import biblioteka.dao.UzytkownikFacadeLocal;
import biblioteka.dao.CategoryFacadeLocal;
import biblioteka.dao.KsiazkiFacadeLocal;

import biblioteka.model.Uzytkownik;
import biblioteka.model.Category;
import biblioteka.model.Ksiazki;
import java.util.Date;
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

    @EJB
    private KsiazkiFacadeLocal ksiazkiFacade;

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

    @Override
    public void dodajksiazke(String nazwa, String autor, String isbn, String wydawca, String rokwydania, String kategoria) {

        Integer rok = Integer.parseInt(rokwydania);

        Date data = new Date();

        Ksiazki ksiazka = new Ksiazki();

        Integer st = 0;

        Category kat = categoryFacade.find(Integer.parseInt(kategoria));

        ksiazka.setNazwa(nazwa);
        ksiazka.setAutor(autor);
        ksiazka.setIsbn(isbn);
        ksiazka.setCategoryId(kat);
        ksiazka.setRokWydania(rok);
        ksiazka.setWydawca(wydawca);
        ksiazka.setLastUpdate(data);
        ksiazka.setStanksiazki(st);

        ksiazkiFacade.create(ksiazka);

    }

    @Override
    public void edytujksiazke(int ID, String nazwa, String autor, String isbn, String wydawca, String rokwydania, String kategoria) {

        Ksiazki ksiazka = ksiazkiFacade.find(ID);

        if (!nazwa.isEmpty()) {
            ksiazka.setNazwa(nazwa);
        }

        if (!autor.isEmpty()) {
            ksiazka.setAutor(autor);
        }

        if (!isbn.isEmpty()) {
            ksiazka.setIsbn(isbn);
        }

        if (!wydawca.isEmpty()) {
            ksiazka.setWydawca(wydawca);
        }

        ksiazkiFacade.edit(ksiazka);
    }

    @Override
    public int numberofbooks() {
       return ksiazkiFacade.count();
    }
}
