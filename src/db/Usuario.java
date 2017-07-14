package db;

public class Usuario {

	private Integer id;
	private String nombre;
	
	public Usuario(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
