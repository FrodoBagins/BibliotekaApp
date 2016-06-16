/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka.dao.jpa;

import biblioteka.dao.KsiazkiFacadeLocal;
import biblioteka.model.Ksiazki;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kamil_2
 */
@Stateless
public class KsiazkiFacade extends AbstractFacade<Ksiazki> implements KsiazkiFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_BibliotekaApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KsiazkiFacade() {
        super(Ksiazki.class);
    }
    
}
