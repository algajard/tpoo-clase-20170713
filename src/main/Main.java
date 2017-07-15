/**
 * 
 */
package main;

import java.util.List;

import db.Usuario;
import db.UsuarioDAO;

/**
 * @author algajard
 *
 */
public class Main {

	private static UsuarioDAO usuarioDAO;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			usuarioDAO = new UsuarioDAO();

			List<Usuario> userList01 = usuarioDAO.seleccionarUsuarios();

			for (Usuario u : userList01) {
				System.out.println(u.toString());
			}

			System.out.println();

			Usuario userList02 = usuarioDAO.seleccionarUsuario(2);
			System.out.println(userList02.toString());

			System.out.println();

			List<Usuario> userList03 = usuarioDAO.seleccionarUsuarios(2,5);

			for (Usuario u : userList03) {
				System.out.println(u.toString());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
