package edu.masterjava.ejb.tarea06.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author carloshernandezarques
 *
 */
@Entity
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;
	 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String titulo;
    private String autor;
	
    public Libro() {
    	
    }
    
    public Libro(String titulo, String autor) {
    	this.titulo = titulo;
    	this.autor = autor;
    }
    
    @Override
    public String toString() {
        return titulo + " : " + autor;
    }
}
