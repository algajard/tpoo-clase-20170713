package db;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {

	public Boolean insertarUsuario(Usuario user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, NullPointerException;
	public Boolean actualizarUsuario(Usuario user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, NullPointerException;;
	public List<Usuario> seleccionarUsuarios() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	
}
