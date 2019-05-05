package tiendaDeMascotas;

public class Animal {
	public String Nombre;

	public Animal(String nombre) {
		Nombre = nombre;
	}
	
	@Override
	public String toString() {
		return Nombre;
	}
}
