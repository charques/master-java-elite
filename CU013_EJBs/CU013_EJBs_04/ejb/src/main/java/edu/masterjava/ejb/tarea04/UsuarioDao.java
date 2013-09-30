/**
 * 
 */
package edu.masterjava.ejb.tarea04;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author carloshernandezarques
 * 
 */
@Stateless
public class UsuarioDao {
	// Entity manager
	@PersistenceContext
	private EntityManager em;

	// Guarda un usuario
	public Long saveUsuario(Usuario usuario) {
		em.persist(usuario);
		em.flush();
		em.refresh(usuario);

		return usuario.id;
	}

	// Recupera todos los usuarios
	public List<Usuario> getUsuarios() {
		TypedQuery<Usuario> query = em.createQuery(
				"SELECT u FROM Usuario u ORDER BY u.id", Usuario.class);
		return query.getResultList();
	}

	// Actualiza un usuario
	public void updateUsuario(Usuario input) {
		Usuario usuario = em.find(Usuario.class, input.getId());
		usuario.setNombre(input.getNombre());
		usuario.setPassword(input.getPassword());
	}

	// Elimina un usuario
	public void eliminaUsuario(Long id) {
		Usuario usuario = em.find(Usuario.class, id);
		em.remove(usuario);
	}

	// Obtiene un usuario
	public Usuario obtenerUsuario(Long id) {
		Usuario usuario = em.find(Usuario.class, id);
		return usuario;
	}
}