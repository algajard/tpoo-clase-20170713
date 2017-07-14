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
		connection = new MyConn(user, password, db, url);
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

		PreparedStatement stmt = connection.getPreparedStatement("INSERT INTO USUARIO(ID, NOMBRE) VALUES(?, ?);");

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

		PreparedStatement stmt = connection.getPreparedStatement("UPDATE USUARIO SET NOMBRE=? WHERE ID=?;");

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
		stmt.executeQuery("SELECT ID, NOMBRE FROM USUARIO;");
		
		ResultSet rs = stmt.getResultSet();
		userList = new ArrayList<>();
		
		while(rs.next()) {
			userList.add(new Usuario(rs.getInt(1), rs.getString(2)));
		}
		
		return userList;
	}

}
