package com.mycompany.bibliotekaapp.appclient;

import ejb.controlRemote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Enterprise Application Client main class.
 *
 */
public class Main {

    public static void main(String[] args) throws NamingException, InterruptedException, ExecutionException, IOException {
        System.out.println("Hello World Enterprise Application Client!");

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        fh = new FileHandler("D:/MyLogFile.log", true);
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        InitialContext ic = new InitialContext();

        logger.info("Uruchomiono aplikacje");

        controlRemote contr = (controlRemote) ic.lookup("sesja");

        System.out.println(contr.funkcja());

        Scanner odczyt;
        odczyt = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        //   lista = contr.brakodbioru();
        //   for (int i = 0; i < lista.size(); i++) {
        //       System.out.println(lista.get(i));
        //  }
        int liczba = contr.findnumberofkat();

        System.out.println(liczba);

        int k = 1, j, idksiazki, ID = 0, numb = 1;
        String temp, nazwisko, imie, hasl, mail, rok;

        while (k == 1) {

            System.out.println("1. Wyloguj");
            System.out.println("2. Rejestracja");
            System.out.println("3. Logowanie");
            System.out.println("4. Dodaj ksiazke");
            System.out.println("5. Liczba ksiazek");
            System.out.println("6. Wyświetl liste książek");
            System.out.println("7. Wypożycz ksiazke");
            System.out.println("8. Usuń książkę");
            System.out.println("9. Zarezerwuj ksiazke");
            System.out.println("10. Wyswietl stany ksiazek");
            System.out.println("11. Edytuj ksiazke");
            System.out.println("0. Zakończ działanie aplikacji");

            temp = odczyt.nextLine();
            j = Integer.parseInt(temp);

            switch (j) {

                case 0:

                    logger.info("Poprawnie zakonczono działanie aplikacji");
                    k = 0;

                    break;

                case 1:
                    ID = 0;

                    break;

                case 2:

                    System.out.println("Podaj Imie");
                    imie = odczyt.nextLine();
                    System.out.println("Podaj Nazwisko");
                    nazwisko = odczyt.nextLine();
                    System.out.println("Podaj Mail");
                    mail = odczyt.nextLine();
                    System.out.println("Podaj haslo");
                    hasl = odczyt.nextLine();

                    contr.dodajklienta(imie, nazwisko, hasl, mail);
                    logger.info("Dodano uzytkownika");
                    break;

                case 3:

                    System.out.println("Podaj ID");
                    imie = odczyt.nextLine();
                    System.out.println("Podaj haslo");
                    nazwisko = odczyt.nextLine();

                    ID = contr.logowanie(imie, nazwisko);

                    if (ID == 0) {
                        System.out.println("Podano bledne haslo");
                        logger.info("Nieudana próba logowania");

                    } else {
                        System.out.println(ID);
                        logger.info("Zalogowano uzytkownika");
                    }

                    break;

                case 4:

                    if (ID == 0) {
                        System.out.println("Nie jestes zalogowany");
                        break;
                    }

                    System.out.println("Podaj Nazwę");
                    imie = odczyt.nextLine();
                    System.out.println("Podaj Autora");
                    nazwisko = odczyt.nextLine();
                    System.out.println("Podaj Isbn");
                    mail = odczyt.nextLine();
                    System.out.println("Podaj Wydawnictwo");
                    hasl = odczyt.nextLine();
                    System.out.println("Podaj Rok Wydania");
                    rok = odczyt.nextLine();

                    contr.dodajksiazke(imie, nazwisko, mail, hasl, rok, "2");
                    logger.info("Dodano ksiazke");
                    break;

                case 5:

                    numb = contr.numberofbooks();

                    System.out.println("Liczba książek: " + numb);

                    break;

                case 6:

                    lista = contr.rekordtabeli();

                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }

                    break;

                case 7:

                    if (ID == 0) {
                        System.out.println("Nie jestes zalogowany");
                        break;
                    }

                    lista = contr.rekordtabeli();

                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }

                    temp = odczyt.nextLine();
                    idksiazki = Integer.parseInt(temp);

                    contr.wypozyczKsiazke(ID, idksiazki);
                    logger.info("Wypozyczono ksiazke");
                    break;

                case 8:

                    if (ID == 0) {
                        System.out.println("Nie jestes zalogowany");
                        break;
                    }

                    lista = contr.rekordtabeli();
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }

                    temp = odczyt.nextLine();
                    idksiazki = Integer.parseInt(temp);

                    contr.usunKsiazke(idksiazki);
                    logger.info("Usunieto ksiazke");

                    break;

                case 9:

                    if (ID == 0) {
                        System.out.println("Nie jestes zalogowany");
                        break;
                    }

                    lista = contr.rekordtabeli();

                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }

                    temp = odczyt.nextLine();
                    idksiazki = Integer.parseInt(temp);

                    System.out.println("Podaj date rezerwacji (Format dd/mm/rrrr)");
                    temp = odczyt.nextLine();

                    contr.rezerwujksiazke(ID, idksiazki, temp);
                    logger.info("Zarezerwowano ksiazke");
                    break;

                case 10:

                    lista = contr.lista();

                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }

                    break;

                case 11:

                    if (ID == 0) {
                        System.out.println("Nie jestes zalogowany");
                        break;
                    }

                    String ksid;
                    int tempid;
                    System.out.println("Podaj Id ksiazki do edycji");
                    ksid = odczyt.nextLine();
                    tempid = Integer.parseInt(ksid);
                    System.out.println("Podaj Nazwę");
                    imie = odczyt.nextLine();
                    System.out.println("Podaj Autora");
                    nazwisko = odczyt.nextLine();
                    System.out.println("Podaj Isbn");
                    mail = odczyt.nextLine();
                    System.out.println("Podaj Wydawnictwo");
                    hasl = odczyt.nextLine();
                    System.out.println("Podaj Rok Wydania");
                    rok = odczyt.nextLine();

                    contr.edytujksiazke(tempid, imie, nazwisko, mail, hasl, rok, "2");

                    break;

            }

        }
    }

}
