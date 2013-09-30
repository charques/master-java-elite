package edu.masterjava.javainiciacion.tarea19;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Representar la situaci—n que sucede cuando vamos a un restaurante a comer, tener en
 * cuenta las clases Cocina, Camarero, Plato, Mesa, Menu, Cliente y la clase Restaurante como
 * escenario de las interacciones del resto de objetos.
 * 
 * @author carloshernandezarques
 *
 */
public class Restaurante {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Inicializa los elementos propios del restaurante
		Cocina cocina = new Cocina();
		
		List<Mesa> mesas = new ArrayList<Mesa>();
		mesas.add(new Mesa(1, 2));
		mesas.add(new Mesa(1, 4));
		
		Camarero camarero = new Camarero("Camarero 1");
		
		// Crea clientes
		Cliente cliente1 = new Cliente("Pedro Mart’nez");
		Cliente cliente2 = new Cliente("Elsa Rodriguez");
		
		// Ocupan una mesa libre
		Mesa mesaLibre = obtenerMesaLibre(mesas, 2);
		
		// Si hay una mesa libre, los comensales la ocupan
		if(mesaLibre != null) {
			
			// Asigna la mesa a un camarero
			camarero.asignarMesa(mesaLibre);
			
			// Se realizan los pedidos (menu)
			List<Plato> platos1 = new ArrayList<Plato>();
			platos1.add(new Plato("Gazpacho", 5.0f));
			platos1.add(new Plato("Chuleta de ternera", 18.5f));
			Menu menu1 = new Menu(cliente1, platos1);
			
			List<Plato> platos2 = new ArrayList<Plato>();
			platos2.add(new Plato("Ensalada", 4.3f));
			platos2.add(new Plato("Lubina a la sal", 15.5f));
			Menu menu2 = new Menu(cliente2, platos2);
			
			// Ocupa una mesa asignando unos menus a esta
			List<Menu> menus = new ArrayList<Menu>();
			menus.add(menu1);
			menus.add(menu2);
			mesaLibre.ocuparMesa(menus);
			
			// Se realizan los pedidos a la cocina
			cocina.realizarPedido(menus);
			
			// Se itera hasta que se sirvan todos los menus.
			List<Menu> menusPreparados;
			Menu menuPreparado;
			do {
				// En cada iteraci—n se obtienen los pedidos preparados.
				menusPreparados = cocina.obtenerPedidosPreparados();
				for(int i= 0; i < menusPreparados.size(); i++) {
					menuPreparado = menusPreparados.get(i);
					// Se sirven los menus que ya est‡n preparados. 
					Mesa mesa = camarero.obtenerMesaPorMenu(menuPreparado);
					mesa.servir(menuPreparado);
				}
			} while (cocina.tienePedidosPendientes());
			
			// Libera la mesa
			mesaLibre.liberarMesa();
			camarero.desasignarMesa(mesaLibre.getIdMesa());
		}
		
	}
	
	/**
	 * Obtiene una mesa libre que tenga capacidad para el nœmero de comensales
	 * pasado como par‡metro.
	 * @param mesas
	 * @param numComensales
	 * @return
	 */
	private static Mesa obtenerMesaLibre(List<Mesa> mesas, int numComensales) {
		Mesa mesa;
		for(int i=0; i < mesas.size(); i++) {
			mesa = mesas.get(i);
			if(!mesa.isEstaOcupada() && mesa.getCapacidad()>=numComensales) {
				return mesa;
			}
		}
		return null;
	}

}
