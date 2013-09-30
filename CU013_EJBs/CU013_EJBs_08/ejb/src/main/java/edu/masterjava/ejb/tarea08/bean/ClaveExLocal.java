package edu.masterjava.ejb.tarea08.bean;

import java.util.List;

import javax.ejb.Local;

import edu.masterjava.ejb.tarea08.entity.Clave;

@Local
public interface ClaveExLocal {

	void create3Claves(Long c1, Long c2, Long c3);
	
	void createClave(Long c);
	
	List<Clave> obtenerClaves();
}
