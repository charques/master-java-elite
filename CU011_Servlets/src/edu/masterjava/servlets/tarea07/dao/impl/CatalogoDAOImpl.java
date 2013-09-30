/**
 * 
 */
package edu.masterjava.servlets.tarea07.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.masterjava.servlets.comun.JdbcComun;
import edu.masterjava.servlets.comun.Utils;
import edu.masterjava.servlets.tarea07.dao.CatalogoDAO;
import edu.masterjava.servlets.tarea07.exceptions.CatalogoException;
import edu.masterjava.servlets.tarea07.model.CatalogoItem;
import edu.masterjava.servlets.tarea07.model.Config;

/**
 * 
 * Implementacion del DAO de catalogo.
 * 
 * @author carloshernandezarques
 *
 */
public class CatalogoDAOImpl implements CatalogoDAO {

	@Override
	public List<CatalogoItem> obtenerCatalogo(String idTipoSelect) throws CatalogoException {
		
		// Validacion
		Integer tipoSelect = null;
		if(idTipoSelect != null) {
			tipoSelect = Utils.convertirStringToInteger(idTipoSelect);
			if(tipoSelect == null) {
				throw new CatalogoException(CatalogoException.ERROR_VALIDACION);
			}
		}
		
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		List<CatalogoItem> catalogo = new ArrayList<CatalogoItem>();
		
		try {
			String query = "SELECT i.item_id, i.item_titulo, i.item_autor, i.soporte_id, s.soporte_desc, i.tipo_id, t.tipo_desc, i.item_anio " +
					"FROM items i, soportes_config s, tipos_config t " +
					"WHERE i.soporte_id = s.soporte_id " +
					"AND i.tipo_id = t.tipo_id ";
			if(tipoSelect != null) {
				query += "AND i.tipo_id = ?";
			}
			stmt = con.prepareStatement(query);
			if(tipoSelect != null) {
				stmt.setInt(1, tipoSelect);
			}
			
			ResultSet result = stmt.executeQuery();
			
			CatalogoItem item;
			while (result.next()) {
				int id = result.getInt(1);
				String titulo = result.getString(2);
				String autor = result.getString(3);
				int idSoporte = result.getInt(4);
				String descSoporte = result.getString(5);
				int idTipo = result.getInt(6);
				String descTipo = result.getString(7);
				int anio = result.getInt(8);

				item = new CatalogoItem();
				item.setId(id);
				item.setTitulo(titulo);
				item.setAutor(autor);
				item.setIdSoporte(idSoporte);
				item.setDescripSoporte(descSoporte);
				item.setIdTipo(idTipo);
				item.setDescripTipo(descTipo);
				item.setAnio(anio);
				catalogo.add(item);
			}

		} catch (SQLException ex) {
			throw new CatalogoException(CatalogoException.ERROR_SQL + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				throw new CatalogoException(CatalogoException.ERROR_SQL + e.getMessage());
			}
		}
		return catalogo;
	}

	@Override
	public CatalogoItem detalleCatalogo(String idItem) throws CatalogoException {
		
		// Validacion
		Integer itemId = Utils.convertirStringToInteger(idItem);
		if(itemId == null) {
			throw new CatalogoException(CatalogoException.ERROR_VALIDACION);
		}
		
		// Realiza consulta y procesa los resultados
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		CatalogoItem item = null;
		
		try {
			String query = "SELECT i.item_id, i.item_titulo, i.item_autor, i.soporte_id, s.soporte_desc, i.tipo_id, t.tipo_desc, i.item_anio " +
					"FROM items i, soportes_config s, tipos_config t " +
					"WHERE i.soporte_id = s.soporte_id " +
					"AND i.tipo_id = t.tipo_id " +
					"AND i.item_id = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, itemId);
			
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				int id = result.getInt(1);
				String titulo = result.getString(2);
				String autor = result.getString(3);
				int idSoporte = result.getInt(4);
				String descSoporte = result.getString(5);
				int idTipo = result.getInt(6);
				String descTipo = result.getString(7);
				int anio = result.getInt(8);

				item = new CatalogoItem();
				item.setId(id);
				item.setTitulo(titulo);
				item.setAutor(autor);
				item.setIdSoporte(idSoporte);
				item.setDescripSoporte(descSoporte);
				item.setIdTipo(idTipo);
				item.setDescripTipo(descTipo);
				item.setAnio(anio);
			}

		} catch (SQLException ex) {
			throw new CatalogoException(CatalogoException.ERROR_SQL + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				throw new CatalogoException(CatalogoException.ERROR_SQL + e.getMessage());
			}
		}
		return item;
	}

	@Override
	public List<Config> obtenerTipos() {
				
		// Realiza consulta y procesa los resultados
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		List<Config> config = new ArrayList<Config>();
		
		try {
			String query = "SELECT tipo_id, tipo_desc FROM tipos_config";
			stmt = con.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			Config item;
			while (result.next()) {
				int id = result.getInt(1);
				String descripcion = result.getString(2);
				
				item = new Config();
				item.setId(id);
				item.setDescripcion(descripcion);
				config.add(item);
			}

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// no hace nada
			}
		}
		return config;
	}

	@Override
	public List<Config> obtenerSoportes() {
		
		// Realiza consulta y procesa los resultados
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		List<Config> config = new ArrayList<Config>();
		
		try {
			String query = "SELECT soporte_id, soporte_desc FROM soportes_config";
			stmt = con.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			Config item;
			while (result.next()) {
				int id = result.getInt(1);
				String descripcion = result.getString(2);
				
				item = new Config();
				item.setId(id);
				item.setDescripcion(descripcion);
				config.add(item);
			}

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// no hace nada
			}
		}
		return config;
	}

	@Override
	public void eliminarItem(String idItem) throws CatalogoException {
		
		// Validacion
		Integer itemId = Utils.convertirStringToInteger(idItem);
		if(itemId == null) {
			throw new CatalogoException(CatalogoException.ERROR_VALIDACION);
		}
		
		// Elimina item
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM items WHERE item_id = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, itemId);
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			throw new CatalogoException(CatalogoException.ERROR_SQL + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				throw new CatalogoException(CatalogoException.ERROR_SQL + e.getMessage());
			}
		}
	}

	@Override
	public void guardaItem(CatalogoItem item) throws CatalogoException {
		if(item.getId() == null) {
			insertItem(item);
		}
		else {
			updateItem(item);
		}
	}
	
	/**
	 * Inserta un item.
	 * @param item
	 * @return
	 * @throws CatalogoException 
	 */
	private void insertItem(CatalogoItem item) throws CatalogoException {
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String query = "INSERT INTO items (item_id, item_titulo, item_autor, soporte_id, tipo_id, item_anio) VALUES (items_seq.nextval, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, item.getTitulo());
			stmt.setString(2, item.getAutor());
			stmt.setInt(3, item.getIdSoporte());
			stmt.setInt(4, item.getIdTipo());
			stmt.setInt(5, item.getAnio());
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			throw new CatalogoException(CatalogoException.ERROR_SQL + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				throw new CatalogoException(CatalogoException.ERROR_SQL + e.getMessage());
			}
		}
	}
	
	/**
	 * Actualiza un item.
	 * @param item
	 * @return
	 * @throws CatalogoException 
	 */
	private void updateItem(CatalogoItem item) throws CatalogoException {
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String query = "UPDATE items SET item_titulo = ?, item_autor = ?, soporte_id = ?, tipo_id = ?, item_anio = ? WHERE item_id = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, item.getTitulo());
			stmt.setString(2, item.getAutor());
			stmt.setInt(3, item.getIdSoporte());
			stmt.setInt(4, item.getIdTipo());
			stmt.setInt(5, item.getAnio());
			stmt.setInt(6, item.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			throw new CatalogoException(CatalogoException.ERROR_SQL + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				throw new CatalogoException(CatalogoException.ERROR_SQL + e.getMessage());
			}
		}
	}

}
