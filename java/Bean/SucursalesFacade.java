/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Sucursales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FRANCO
 */
@Stateless
public class SucursalesFacade extends AbstractFacade<Sucursales> {

    @PersistenceContext(unitName = "joyeriaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalesFacade() {
        super(Sucursales.class);
    }
    
}
