/**
 * 
 */
package edu.masterjava.spring.tarea03.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.masterjava.spring.tarea03.entity.Usuario;

/**
 * @author carloshernandezarques
 * 
 */
@Repository("UsuarioDao")
public class UsuarioDao {
	
	static final Logger logger = Logger.getLogger(UsuarioDao.class);
	
	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	// Guarda un usuario
    @Transactional(readOnly = false)
	public Long saveUsuario(Usuario usuario) {
		em.persist(usuario);
		em.flush();
		em.refresh(usuario);
		
		logger.info("saveUsuario: " + usuario.toString());
		
		return usuario.getId();
	}

	// Recupera todos los usuarios
    @Transactional(readOnly = true)
	public List<Usuario> getUsuarios() {
		TypedQuery<Usuario> query = em.createQuery(
				"SELECT u FROM Usuario u ORDER BY u.id", Usuario.class);
		
		List<Usuario> usuarios = query.getResultList();
		logger.info("getUsuarios: " + usuarios.size());
		return usuarios;
	}

	// Actualiza un usuario
    @Transactional(readOnly = false)
	public void updateUsuario(Usuario input) {
		Usuario usuario = em.find(Usuario.class, input.getId());
		usuario.setNombre(input.getNombre());
		usuario.setPassword(input.getPassword());
		
		logger.info("updateUsuario: " + usuario.toString());
	}

	// Elimina un usuario
    @Transactional(readOnly = false)
	public void eliminaUsuario(Long id) {
		Usuario usuario = em.find(Usuario.class, id);
		logger.info("eliminaUsuario: " + usuario.toString());
		em.remove(usuario);
	}

	// Obtiene un usuario
    @Transactional(readOnly = true)
	public Usuario obtenerUsuario(Long id) {
		Usuario usuario = em.find(Usuario.class, id);
		logger.info("obtenerUsuario: " + usuario.toString());
		return usuario;
	}
}