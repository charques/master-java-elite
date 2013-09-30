package edu.masterjava.ejb.tarea07.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author carloshernandezarques
 *
 */
@Entity
public class Clave implements Serializable {

	private static final long serialVersionUID = 1L;
	 
    // Persistent Fields:
    @Id 
    Long id;
    
    public Clave() {
    	
    }
    
    public Clave(Long id) {
    	this.id = id;
    }
    
    @Override
    public String toString() {
        return "clave : " + id.toString();
    }
}
