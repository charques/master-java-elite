/**
 * 
 */
package edu.masterjava.javainiciacion.tarea19;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clase que representa una cocina
 * 
 * @author carloshernandezarques
 *
 */
public class Cocina {

	/**
	 * Lista de pedidos pendientes.
	 */
	List<Menu> pedidos;
	
	/**
	 * Constructor
	 */
	public Cocina() {
		pedidos = new ArrayList<Menu>();
	}
	
	/**
	 * Realiza un pedido a la cocina
	 * @param menus
	 */
	public void realizarPedido(List<Menu> menus) {
		pedidos.addAll(menus);
	}
	
	/**
	 * Simula la preparaci—n de pedidos en la cocina.
	 * Cada vez que se invoca se da por supuesto que todos los
	 * pedidos est‡n preparados.
	 * @return
	 */
	public List<Menu> obtenerPedidosPreparados() {
		List<Menu> pedidosPreparados= pedidos;
		pedidos = new ArrayList<Menu>();
		
		return pedidosPreparados;
	}

	/**
	 * Obtiene si la cocina tiene pedidos pendientes.
	 * @return
	 */
	public boolean tienePedidosPendientes() {
		if(pedidos.size()>0) {
			return true;
		}
		return false;
	}
}
