/**
 * 
 */
package edu.masterjava.ejb.tarea08.bean.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.masterjava.ejb.tarea08.bean.ClaveExLocal;
import edu.masterjava.ejb.tarea08.bean.ClaveExRemote;
import edu.masterjava.ejb.tarea08.entity.Clave;

/**
 * @author carloshernandezarques
 * 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClaveExImpl implements ClaveExLocal, ClaveExRemote {
	
	// Entity manager
	@PersistenceContext(unitName = "ClavesPU")
	private EntityManager em;
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create3Claves(Long c1, Long c2, Long c3) {
		createClave(c1);
		createClave(c2);
		createClave(c3);
	}
	
	// Siempre crea una transaccion para ejecutar el metodo
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void createClave(Long c) {
		em.persist(new Clave(c));
	}
    
 	public List<Clave> obtenerClaves() {
 		TypedQuery<Clave> query = em.createQuery(
 				"SELECT u FROM Clave u ORDER BY u.id", Clave.class);
 		return query.getResultList();
 	}
}
