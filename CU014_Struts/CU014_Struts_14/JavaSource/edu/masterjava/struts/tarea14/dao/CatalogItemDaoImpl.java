/**
 * 
 */
package edu.masterjava.struts.tarea14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.masterjava.comun.JdbcConfig;
import edu.masterjava.struts.tarea14.vo.CatalogItem;

/**
 * Implementaci—n del DAO de gesti—n del cat‡logo.
 * 
 * @author carloshernandezarques
 */
public class CatalogItemDaoImpl implements CatalogItemDao {

	JdbcConfig jdbcConfig;
	
	/**
	 * Constructor
	 */
	public CatalogItemDaoImpl() {
		jdbcConfig = new JdbcConfig("jdbc:oracle:thin:@192.168.1.10:1521:xe", "charques", "Manolete1");
	}
	
	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.dao.CatalogItemDao#getAllCatalogItems()
	 */
	@Override
	public List<CatalogItem> getAllCatalogItems() {
		Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		List<CatalogItem> items = new ArrayList<CatalogItem>();
		
		try {
			String query = "SELECT itemId, itemName, autorName, pubYear, catalog_items_struts.categoryId, categoryName " +
					"FROM catalog_categories_struts, catalog_items_struts " +
					"WHERE catalog_categories_struts.categoryId = catalog_items_struts.categoryId";
			stmt = con.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			CatalogItem item;
			while (result.next()) {
				int itemId = result.getInt(1);
				String itemName = result.getString(2);
				String autorName = result.getString(3);
				String pubYear = result.getString(4);
				int categoryId = result.getInt(5);
				String categoryName = result.getString(6);
				
				item = new CatalogItem();
				item.setItemId(itemId);
				item.setItemName(itemName);
				item.setAutorName(autorName);
				item.setPubYear(pubYear);
				item.setCategoryId(categoryId);
				item.setCategoryDesc(categoryName);
				items.add(item);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.dao.CatalogItemDao#getCatalogItem(java.lang.Integer)
	 */
	@Override
	public CatalogItem getCatalogItem(Integer id) {
		Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		CatalogItem item = null;
		
		try {
			String query = "SELECT itemId, itemName, autorName, pubYear, catalog_items_struts.categoryId, categoryName " +
					"FROM catalog_items_struts, catalog_categories_struts " +
					"WHERE catalog_categories_struts.categoryId = catalog_items_struts.categoryId " +
					"AND itemId = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int itemId = result.getInt(1);
				String itemName = result.getString(2);
				String autorName = result.getString(3);
				String pubYear = result.getString(4);
				int categoryId = result.getInt(5);
				String categoryName = result.getString(6);
				
				item = new CatalogItem();
				item.setItemId(itemId);
				item.setItemName(itemName);
				item.setAutorName(autorName);
				item.setPubYear(pubYear);
				item.setCategoryId(categoryId);
				item.setCategoryDesc(categoryName);
				break;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return item;
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.dao.CatalogItemDao#update(edu.masterjava.struts.tarea14.vo.CatalogItem)
	 */
	@Override
	public void update(CatalogItem item) {
		Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String query = "UPDATE catalog_items_struts SET itemName = ?, autorName = ?, pubYear = ?, categoryId = ? WHERE itemId = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, item.getItemName());
			stmt.setString(2, item.getAutorName());
			stmt.setString(3, item.getPubYear());
			stmt.setInt(4, item.getCategoryId());
			stmt.setInt(5, item.getItemId());
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.dao.CatalogItemDao#insert(edu.masterjava.struts.tarea14.vo.CatalogItem)
	 */
	@Override
	public void insert(CatalogItem item) {
		Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String query = "INSERT INTO catalog_items_struts (itemId, itemName, autorName, pubYear, categoryId) VALUES (catalog_items_struts_seq.nextval, ?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, item.getItemName());
			stmt.setString(2, item.getAutorName());
			stmt.setString(3, item.getPubYear());
			stmt.setInt(4, item.getCategoryId());
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.dao.CatalogItemDao#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM catalog_items_struts WHERE itemId = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
