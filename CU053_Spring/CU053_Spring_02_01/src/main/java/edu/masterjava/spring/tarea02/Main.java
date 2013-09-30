package edu.masterjava.spring.tarea02;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.masterjava.spring.tarea02.dao.UsuarioDao;
import edu.masterjava.spring.tarea02.entity.Usuario;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"core-configuration.xml");

		// Guarda usuarios
		UsuarioDao usuarioDao = (UsuarioDao) context.getBean("usuarioDao");
		usuarioDao.saveUsuario(new Usuario("user1", "password1"));
		usuarioDao.saveUsuario(new Usuario("user2", "password2"));
		usuarioDao.saveUsuario(new Usuario("user3", "password3"));
		
		// Obtiene usuarios
		List<Usuario> usuarios = usuarioDao.getUsuarios();
		Usuario primerUsuario = usuarios.get(0);
		
		// Actualiza usuario
		primerUsuario.setNombre("test");
		usuarioDao.updateUsuario(primerUsuario);
		
		// Elimina primer usuario
		usuarioDao.eliminaUsuario(primerUsuario.getId());
	}

}
