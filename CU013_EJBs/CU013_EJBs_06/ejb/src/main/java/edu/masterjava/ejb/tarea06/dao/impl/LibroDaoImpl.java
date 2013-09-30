/**
 * 
 */
package edu.masterjava.ejb.tarea06.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.masterjava.ejb.tarea06.dao.LibroDaoLocal;
import edu.masterjava.ejb.tarea06.dao.LibroDaoRemote;
import edu.masterjava.ejb.tarea06.entity.Libro;

/**
 * @author carloshernandezarques
 * 
 */
@Stateless
public class LibroDaoImpl implements LibroDaoLocal, LibroDaoRemote {
	// Entity manager
	@PersistenceContext
	private EntityManager em;
	
	public void crearLibro(Libro libro) {
		em.persist(libro);
	}
	 
    public Libro actualizar(Libro libro) {
    	return em.merge(libro);
    }
 
    public Libro buscar(Long id) {
    	return em.find(Libro.class, id);
    }
    
 	public List<Libro> obtenerLibros() {
 		TypedQuery<Libro> query = em.createQuery(
 				"SELECT u FROM Libro u ORDER BY u.id", Libro.class);
 		return query.getResultList();
 	}
}
