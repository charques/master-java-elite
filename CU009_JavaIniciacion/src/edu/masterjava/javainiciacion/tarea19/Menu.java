/**
 * 
 */
package edu.masterjava.javainiciacion.tarea19;

import java.util.List;

/**
 * 
 * Clase que representa un menu/pedido.
 * 
 * @author carloshernandezarques
 *
 */
public class Menu {

	/**
	 * Cliente asociado a un menu/pedido.
	 */
	private Cliente cliente;
	
	/**
	 * Lista de platos de un menu.
	 */
	private List<Plato> platos;
	
	/**
	 * Indica si el menœ ha sido servido.
	 */
	private boolean servido;
	
	/**
	 * Constructor
	 */
	public Menu(Cliente cliente, List<Plato> platos) {
		this.cliente = cliente;
		this.platos = platos;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @return the platos
	 */
	public List<Plato> getPlatos() {
		return platos;
	}

	/**
	 * @return the servido
	 */
	public boolean isServido() {
		return servido;
	}

	/**
	 * @param servido the servido to set
	 */
	public void setServido(boolean servido) {
		this.servido = servido;
	}

	
}
