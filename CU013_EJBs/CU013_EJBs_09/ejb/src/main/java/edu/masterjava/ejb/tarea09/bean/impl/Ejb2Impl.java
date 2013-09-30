/**
 * 
 */
package edu.masterjava.ejb.tarea09.bean.impl;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.SecurityDomain;

import edu.masterjava.ejb.tarea09.bean.Ejb2Local;

/**
 * @author carloshernandezarques
 * 
 */

@DeclareRoles({"rolBueno"})
@SecurityDomain("other")
@Stateless
public class Ejb2Impl implements Ejb2Local {
	
	@RolesAllowed({"rolBueno"})
	public void metodoInterno() {
		System.out.println("metodoInterno");
	}
	
}
