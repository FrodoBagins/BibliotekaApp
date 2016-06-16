/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka.dao.jpa;

import biblioteka.dao.UzytkownikWypozyceniaFacadeLocal;
import biblioteka.model.UzytkownikWypozycenia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kamil_2
 */
@Stateless
public class UzytkownikWypozyceniaFacade extends AbstractFacade<UzytkownikWypozycenia> implements UzytkownikWypozyceniaFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_BibliotekaApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UzytkownikWypozyceniaFacade() {
        super(UzytkownikWypozycenia.class);
    }
    
}
