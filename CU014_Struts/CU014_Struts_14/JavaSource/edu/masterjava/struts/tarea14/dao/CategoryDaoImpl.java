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
import edu.masterjava.struts.tarea14.vo.Category;

/**
 * Implementacion del DAO de gesti—n del categorias.
 * 
 * @author carloshernandezarques
 *
 */
public class CategoryDaoImpl implements CategoryDao {
	
	JdbcConfig jdbcConfig;
	
	/**
	 * Constructor.
	 */
	public CategoryDaoImpl() {
		jdbcConfig = new JdbcConfig("jdbc:oracle:thin:@192.168.1.10:1521:xe", "charques", "Manolete1");
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.dao.CategoryDao#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories() {
		Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		List<Category> categories = new ArrayList<Category>();
		
		try {
			String query = "SELECT categoryId, categoryName " +
					"FROM catalog_categories_struts";
			stmt = con.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			Category cat;
			while (result.next()) {
				int categoryId = result.getInt(1);
				String categoryName = result.getString(2);
				
				cat = new Category();
				cat.setCategoryId(String.valueOf(categoryId));
				cat.setCategoryName(categoryName);
				categories.add(cat);
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
		return categories;
	}

}
