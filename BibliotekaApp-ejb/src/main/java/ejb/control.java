/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Kamil_2
 */
@Stateless(mappedName = "sesja")
public class control implements controlRemote {

    @Override
    public String funkcja() {
        return "wynik";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
