/**
 * 
 */
package edu.masterjava.ejb.tarea10.bean.impl;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.SecurityDomain;

import edu.masterjava.ejb.tarea10.bean.Ejb1Local;
import edu.masterjava.ejb.tarea10.bean.Ejb1Remote;
import edu.masterjava.ejb.tarea10.bean.Ejb2Local;

/**
 * @author carloshernandezarques
 * 
 */
@DeclareRoles({"rolBueno", "rolMalo"})
@SecurityDomain("other")
@Stateless
public class Ejb1Impl implements Ejb1Local, Ejb1Remote {
	
	@EJB
	private Ejb2Local ejb2;
	
	@RolesAllowed({"rolBueno", "rolMalo"})
	public void metodoExterno() {
		System.out.println("metodoExterno");
		ejb2.metodoInterno();
	}
	
}
