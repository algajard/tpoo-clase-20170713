package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

	private MyConn connection = null;

	public UsuarioDAO() {
		connection = new MyConn("tpoo2017", "", "CLASE_20170713", "localhost");
	}

	@Override
	public Boolean insertarUsuario(Usuario user) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, NullPointerException {
		// TODO Auto-generated method stub
		if (connection != null) {
			connection.connect();
		} else {
			throw new NullPointerException("Conexión fallida.");
		}

		PreparedStatement stmt = connection.getPreparedStatement("INSERT INTO CLASE_20170713.USUARIO(ID, NOMBRE) VALUES(?, ?);");

		stmt.setInt(1, user.getId());
		stmt.setString(2, user.getNombre());

		return stmt.execute();
	}

	@Override
	public Boolean actualizarUsuario(Usuario user) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, NullPointerException {
		// TODO Auto-generated method stub
		if (connection != null) {
			connection.connect();
		} else {
			throw new NullPointerException("Conexión fallida.");
		}

		PreparedStatement stmt = connection.getPreparedStatement("UPDATE CLASE_20170713.USUARIO SET NOMBRE=? WHERE ID=?;");

		stmt.setString(1, user.getNombre());
		stmt.setInt(2, user.getId());

		return stmt.execute();
	}

	@Override
	public List<Usuario> seleccionarUsuarios() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Usuario> userList = null;
		
		if (connection != null) {
			connection.connect();
		} else {
			throw new NullPointerException("Conexión fallida.");
		}

		Statement stmt = connection.getStatement();
		stmt.executeQuery("SELECT ID, NOMBRE FROM CLASE_20170713.USUARIO;");
		
		ResultSet rs = stmt.getResultSet();
		userList = new ArrayList<>();
		
		while(rs.next()) {
			userList.add(new Usuario(rs.getInt(1), rs.getString(2)));
		}
		
		return userList;
	}

	@Override
	public Usuario seleccionarUsuario(Integer id)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Usuario> userList = null;
		
		if (connection != null) {
			connection.connect();
		} else {
			throw new NullPointerException("Conexión fallida.");
		}

		PreparedStatement stmt = connection.getPreparedStatement("SELECT ID, NOMBRE FROM CLASE_20170713.USUARIO WHERE ID = ?;");
		stmt.setInt(1, id);
		
		stmt.executeQuery();
		
		ResultSet rs = stmt.getResultSet();
		userList = new ArrayList<>();
		
		while(rs.next()) {
			userList.add(new Usuario(rs.getInt(1), rs.getString(2)));
		}
		
		return userList.get(0);
	}

	@Override
	public List<Usuario> seleccionarUsuarios(Integer idInicio, Integer idTermino)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Usuario> userList = null;
		
		if (connection != null) {
			connection.connect();
		} else {
			throw new NullPointerException("Conexión fallida.");
		}

		PreparedStatement stmt = connection.getPreparedStatement("SELECT ID, NOMBRE FROM CLASE_20170713.USUARIO WHERE ID >= ? AND ID <= ?;");
		stmt.setInt(1, idInicio); 
		stmt.setInt(2, idTermino);
		
		stmt.executeQuery();
		
		ResultSet rs = stmt.getResultSet();
		userList = new ArrayList<>();
		
		while(rs.next()) {
			userList.add(new Usuario(rs.getInt(1), rs.getString(2)));
		}
		
		return userList;
	}

}
