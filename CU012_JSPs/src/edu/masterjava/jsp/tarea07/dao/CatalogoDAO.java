/**
 * 
 */
package edu.masterjava.jsp.tarea07.dao;

import java.util.List;

import edu.masterjava.jsp.tarea07.exceptions.CatalogoException;
import edu.masterjava.jsp.tarea07.model.CatalogoItem;
import edu.masterjava.jsp.tarea07.model.Config;

/**
 * 
 * Interface del DAO de acceso a catalogo.
 * 
 * @author carloshernandezarques
 *
 */
public interface CatalogoDAO {

	/**
	 * Obtiene los items del catalogo. 
	 * Permite el filtrado por tipo.
	 * @param tipo
	 * @return
	 */
	public List<CatalogoItem> obtenerCatalogo(String idTipo) throws CatalogoException;
	
	
	/**
	 * Detalle de item del catalogo.
	 * @param idItem
	 * @return
	 */
	public CatalogoItem detalleCatalogo(String idItem) throws CatalogoException;
	
	/**
	 * Obtiene los tipos.
	 * @return
	 */
	public List<Config> obtenerTipos();
	
	/**
	 * Obtiene los soportes.
	 * @return
	 */
	public List<Config> obtenerSoportes();
	
	/**
	 * Elimina un item.
	 * @param idItem
	 * @return
	 */
	public void eliminarItem(String idItem) throws CatalogoException;
	
	/**
	 * Guarda un item.
	 * @param item
	 * @return
	 */
	public void guardaItem(CatalogoItem item) throws CatalogoException;
}
