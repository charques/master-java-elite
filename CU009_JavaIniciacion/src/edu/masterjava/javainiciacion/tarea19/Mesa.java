/**
 * 
 */
package edu.masterjava.javainiciacion.tarea19;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clase que representa una mesa
 * 
 * @author carloshernandezarques
 *
 */
public class Mesa {

	/**
	 * Numero de mesa
	 */
	private int idMesa;
	
	/**
	 * Capacidad de la mesa.
	 */
	private int capacidad;

	/**
	 * Indica si la mesa est‡ ocupada.
	 */
	private boolean estaOcupada;
	
	/**
	 * Lista de menus asociados a una mesa. Un menu est‡ asociado 
	 * a un cliente.
	 */
	private List<Menu> menus;
	
	/**
	 * Constructor
	 */
	public Mesa(int idMesa, int capacidad) {
		this.idMesa = idMesa;
		this.capacidad = capacidad;
	}
	
	/**
	 * Sirve un menu.
	 * @param menu
	 */
	public void servir(Menu menu) {
		menu.setServido(true);
	}
	
	/**
	 * Ocupa una mesa al asignar una serie de menus a
	 * una mesa.
	 */
	public void ocuparMesa(List<Menu> menus) {
		this.menus = new ArrayList<Menu>();
		estaOcupada = true;
	}
	
	/**
	 * Libera una mesa
	 */
	public void liberarMesa() {
		this.menus = null;
		estaOcupada = false;
	}
	
	

	/**
	 * @return the menus
	 */
	public List<Menu> getMenus() {
		return menus;
	}

	/**
	 * @return the idMesa
	 */
	public int getIdMesa() {
		return idMesa;
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @return the estaOcupada
	 */
	public boolean isEstaOcupada() {
		return estaOcupada;
	}
	
	

}
