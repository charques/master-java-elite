/**
 * 
 */
package edu.masterjava.javainiciacion.tarea19;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clase que representa un camarero
 * 
 * @author carloshernandezarques
 *
 */
public class Camarero {
	
	/**
	 * Nombre del camarero.
	 */
	private String nombre;
	
	/**
	 * Lista de mesas asignadas a un camarero.
	 */
	private List<Mesa> mesas;
	
	/**
	 * Constructor
	 */
	public Camarero(String nombre) {
		this.nombre = nombre;
		this.mesas = new ArrayList<Mesa>();
	}
	
	/**
	 * Obtiene la mesa que tiene asignado un menu.
	 * @param menu
	 * @return
	 */
	public Mesa obtenerMesaPorMenu(Menu menu) {
		Mesa mesa;
		Menu menuTemp;
		List<Menu> menus;
		for(int i= 0; i < mesas.size(); i++) {
			mesa = mesas.get(i);
			menus = mesa.getMenus();
			for(int j= 0; j < menus.size(); j++) {
				menuTemp = menus.get(j);
				if(menu.equals(menuTemp)) {
					return mesa;
				}
			}
		}
		return null;
	}
	
	/**
	 * Asigna una mesa a un camarero.
	 * @param mesa
	 */
	public void asignarMesa(Mesa mesa) {
		this.mesas.add(mesa);
	}
	
	/**
	 * Desasignar una mesa a un camarero.
	 * @param mesa
	 */
	public void desasignarMesa(int idMesa) {
		Mesa mesa;
		for(int i= 0; i < mesas.size(); i++) {
			mesa = mesas.get(i);
			if(mesa.getIdMesa() == idMesa) {
				mesas.remove(i);
				break;
			}
		}
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	

}
