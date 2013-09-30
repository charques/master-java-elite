package edu.masterjava.ejb.tarea06.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.masterjava.ejb.tarea06.entity.Libro;

@Remote
public interface LibroDaoRemote {

	void crearLibro(Libro c);
	 
    Libro actualizar(Libro c);
 
    Libro buscar(Long id);
    
    List<Libro> obtenerLibros();
}
