package edu.masterjava.jsf.tarea04.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import edu.masterjava.comun.JdbcConfig;
import edu.masterjava.jsf.tarea04.vo.Contact;

@ManagedBean(name = "ContactDAO")
@ApplicationScoped
public class ContactDAO implements ICrudDAO<Contact, Integer>, Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	JdbcConfig jdbcConfig;
	
	/**
	 * Constructor
	 */
	public ContactDAO() {
		jdbcConfig = new JdbcConfig("jdbc:oracle:thin:@192.168.1.10:1521:xe", "charques", "Manolete1");
	}

    @Override
    public long count()
    {
    	return 0l;
    }

    @Override
    public Contact create()
    {
        return new Contact();
    }

    @Override
    public void delete(Contact entity)
    {
    	Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM contacts_jsf WHERE itemId = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, entity.getId());
			
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

    @Override
    public int deleteAll()
    {
    	return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> findAll()
    {
    	Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		List<Contact> items = new ArrayList<Contact>();
		
		try {
			String query = "SELECT itemId, nombre, apellidos, fechaNac, email " +
					"FROM contacts_jsf";
			stmt = con.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			Contact item;
			while (result.next()) {
				int itemId = result.getInt(1);
				String nombre = result.getString(2);
				String apellidos = result.getString(3);
				Date fechaNac = result.getDate(4);
				String email = result.getString(5);
				
				item = new Contact();
				item.setId(itemId);
				item.setNombre(nombre);
				item.setApellidos(apellidos);
				item.setFechaNac(fechaNac);
				item.setEmail(email);
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

    @Override
    public Contact findById(Integer id)
    {
    	Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		Contact item = null;
		
		try {
			String query = "SELECT itemId, nombre, apellidos, fechaNac, email " +
					"FROM contacts_jsf " +
					"WHERE itemId = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int itemId = result.getInt(1);
				String nombre = result.getString(2);
				String apellidos = result.getString(3);
				Date fechaNac = result.getDate(4);
				String email = result.getString(5);
				
				item = new Contact();
				item.setId(itemId);
				item.setNombre(nombre);
				item.setApellidos(apellidos);
				item.setFechaNac(fechaNac);
				item.setEmail(email);
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

    @PostConstruct
    public void postConstruct()
    {
    }

    @PreDestroy
    public void preDestroy()
    {
    }

    @Override
    public void save(Contact entity)
    {
    	Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String query = "INSERT INTO contacts_jsf (itemId, nombre, apellidos, fechaNac, email) VALUES (contacts_jsf_seq.nextval, ?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, entity.getNombre());
			stmt.setString(2, entity.getApellidos());
			stmt.setTimestamp(3, new java.sql.Timestamp(entity.getFechaNac().getTime()));
			stmt.setString(4, entity.getEmail());
			
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

    @Override
    public Contact update(Contact entity)
    {
    	Connection con = jdbcConfig.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String query = "UPDATE contacts_jsf SET nombre = ?, apellidos = ?, fechaNac = ?, email = ? WHERE itemId = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, entity.getNombre());
			stmt.setString(2, entity.getApellidos());
			stmt.setTimestamp(3, new java.sql.Timestamp(entity.getFechaNac().getTime()));
			stmt.setString(4, entity.getEmail());
			stmt.setInt(5, entity.getId());
			
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
		
		return entity;
    }
}