package com.mycompany.bibliotekaapp.appclient;

import ejb.controlRemote;
import java.util.concurrent.ExecutionException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 * Enterprise Application Client main class.
 *
 */
public class Main {
    
    public static void main( String[] args ) throws NamingException, InterruptedException, ExecutionException{
        System.out.println( "Hello World Enterprise Application Client!" );
        
        
        InitialContext ic = new InitialContext();
        
        controlRemote contr = (controlRemote) ic.lookup("sesja");
        
        
        System.out.println(contr.funkcja());
        
        
        contr.dodajklienta("Imie", "Nazwisko", "adsd", "12@omg.pl");
        
        
        
    }
}
