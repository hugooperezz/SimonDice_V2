package SimonDice;

public class persona {
	private String[] nombres;

	// Constructor que inicializa el array de nombres con un tamaño específico
	public persona() {
		nombres = new String[10];
	}

	// Método para agregar un nombre al array
	public void agregarNombre(int indice, String nombre) {
		if (indice >= 0 && indice < nombres.length) {
			nombres[indice] = nombre;
		} else {
			System.out.println("Índice fuera de rango.");
		}
	}

	// Método para obtener un nombre del array
	public String obtenerNombre(int indice) {
		if (indice >= 0 && indice < nombres.length) {
			return nombres[indice];
		} else {
			System.out.println("Índice fuera de rango.");
			return null;
		}
	}

	// Método para imprimir todos los nombres del array
	public void imprimirNombres() {
		System.out.println("Nombres de los usuarios:");
		for (String nombre : nombres) {
			if (nombre != null) {
				System.out.println(nombre);
			}
		}
	}

	// Método getter para obtener el array de nombres
	public String[] getNombres() {
		return nombres;
	}

	// Método setter para establecer el array de nombres
	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}
}
