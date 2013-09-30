package edu.masterjava.ejb.tarea07.bean;

import java.util.List;

import javax.ejb.Remote;

import edu.masterjava.ejb.tarea07.entity.Clave;

@Remote
public interface ClaveExRemote {

	void create3Claves(Long c1, Long c2, Long c3);
	
	void createClave(Long c);
	
	List<Clave> obtenerClaves();
}
