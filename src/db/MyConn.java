/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author algajard
 *
 */
public class MyConn {

	private String user; // Nombre
	private String password; // Password
	private String db; // Base de datos
	private String url; // URL o IP
	private String connString; // String de conexión generada
	private Connection conn = null; // Objeto que mantiene la conexión

	public MyConn(String user, String password, String db, String url) {
		StringBuilder builder = null;

		this.user = user;
		this.password = password;
		this.db = db;
		this.url = url;

		builder = new StringBuilder();
		builder.append("jdbc:mysql://");
		builder.append(this.url);
		builder.append("/");
		builder.append(this.db);
		builder.append("?user=");
		builder.append(this.user);
		builder.append("&");
		builder.append(this.password);
	}

	public final String getUser() {
		return user;
	}

	public final void setUser(String user) {
		this.user = user;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getDb() {
		return db;
	}

	public final void setDb(String db) {
		this.db = db;
	}

	public final String getUrl() {
		return url;
	}

	public final void setUrl(String url) {
		this.url = url;
	}

	public Boolean connect()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Boolean success = Boolean.FALSE;

		if (getConnection() == null) {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connString);
		}

		return success;
	}

	private Connection getConnection() {
		return this.conn;
	}

	public Boolean disconnect() throws SQLException {
		Boolean success = Boolean.FALSE;

		if (getConnection() != null && !getConnection().isClosed()) {
			getConnection().close();
		}

		return success;
	}

	public PreparedStatement getPreparedStatement(String sqlStatement) throws SQLException {
		PreparedStatement stmt = null;

		if (sqlStatement == null || sqlStatement.equalsIgnoreCase("")) {
			throw new NullPointerException("SQL Statement vacío o nulo");
		}

		stmt = getConnection().prepareStatement(sqlStatement);

		return stmt;
	}

	public Statement getStatement() throws SQLException {
		Statement stmt = null;

		stmt = getConnection().createStatement();

		return stmt;
	}
}
