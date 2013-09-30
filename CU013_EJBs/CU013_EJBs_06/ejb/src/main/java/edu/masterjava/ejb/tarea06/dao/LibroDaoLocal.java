package edu.masterjava.ejb.tarea06.dao;

import java.util.List;

import javax.ejb.Local;

import edu.masterjava.ejb.tarea06.entity.Libro;

@Local
public interface LibroDaoLocal {

	void crearLibro(Libro c);
	 
    Libro actualizar(Libro c);
 
    Libro buscar(Long id);
    
    List<Libro> obtenerLibros();
}
