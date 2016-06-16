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
import biblioteka.dao.UzytkownikWypozyceniaFacadeLocal;

import biblioteka.model.Uzytkownik;
import biblioteka.model.Category;
import biblioteka.model.Ksiazki;
import biblioteka.model.UzytkownikWypozycenia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @EJB
    private UzytkownikWypozyceniaFacadeLocal wypozyczeniaFacade;

    @Override
    public String funkcja() {
        return "wynik";
    }

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

    @Override
    public int logowanie(String id, String haslo) {

        Integer ID = Integer.parseInt(id);

        Uzytkownik uzytkownik = uzytkownikFacade.find(ID);

        if (haslo.equals(uzytkownik.getHaslo())) {

            return ID;

        } else {

            return 0;

        }

    }

    @Override
    public List<String> rekordtabeli() {

        List listek;

        List<String> listaa = new ArrayList<>();

        listek = ksiazkiFacade.findAll();

        for (int i = 0; i < listek.size(); i++) {
            System.out.println(listek.get(i));
            listaa.add(listek.get(i).toString());

        }

        return listaa;

    }

    @Override
    public void wypozyczKsiazke(int ID, int idksiazki) {

        Date data = new Date();

        Ksiazki ksiazki = ksiazkiFacade.find(idksiazki);
        Uzytkownik uzytkownik = uzytkownikFacade.find(ID);

        UzytkownikWypozycenia wypozycenia = new UzytkownikWypozycenia();

        wypozycenia.setKsiazkiId(ksiazki);
        wypozycenia.setUzytkownikId(uzytkownik);

        wypozycenia.setDataWypozyczenia(data);
        // wypozycenia.setData(data);
        wypozyczeniaFacade.create(wypozycenia);

        ksiazki.setStanksiazki(2);
        ksiazkiFacade.edit(ksiazki);

    }

    @Override
    public void usunKsiazke(int idksiazki) {

        Ksiazki ksiazki = ksiazkiFacade.find(idksiazki);

        ksiazkiFacade.remove(ksiazki);
    }

    @Override
    public void rezerwujksiazke(int ID, int idksiazki, String data) {
        Date data2 = new Date();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        try {
            startDate = df.parse(data);
            String newDateString = df.format(startDate);

        } catch (ParseException e) {
        }

        Ksiazki ksiazki = ksiazkiFacade.find(idksiazki);
        Uzytkownik uzytkownik = uzytkownikFacade.find(ID);

        UzytkownikWypozycenia wypozycenia = new UzytkownikWypozycenia();

        wypozycenia.setKsiazkiId(ksiazki);
        wypozycenia.setUzytkownikId(uzytkownik);
        wypozycenia.setDataWypozyczenia(startDate);
        wypozyczeniaFacade.create(wypozycenia);

        ksiazki.setStanksiazki(1);
        ksiazkiFacade.edit(ksiazki);

    }
}
