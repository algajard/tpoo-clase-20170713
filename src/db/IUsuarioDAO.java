package db;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {

	public Boolean insertarUsuario(Usuario user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, NullPointerException;
	public Boolean actualizarUsuario(Usuario user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, NullPointerException;;
	public List<Usuario> seleccionarUsuarios() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public Usuario seleccionarUsuario(Integer id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public List<Usuario> seleccionarUsuarios(Integer idInicio, Integer idTermino) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	
}
