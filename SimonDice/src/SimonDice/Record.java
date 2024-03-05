package SimonDice;

public class Record {
	final int MAX_JUGADORES = 20;
	private persona[] jugadores;
	private int contador;

	public Record() {
		this.jugadores = new persona[MAX_JUGADORES];
		this.contador = 0;
	}

	/**
	 * Añade jugadores al array de jugadores
	 * 
	 * @param jugador
	 */
	public void añadirJugador(persona jugador) {
		if (contador < MAX_JUGADORES) {
			this.jugadores[contador] = jugador;
			this.contador++;
		} else {
			System.out.println("No se pueden añadir más jugadores. Se ha alcanzado el límite.");
		}
	}

	/**
	 * Muestra el ranking de los 10 mejores jugadores
	 */
	public void showRanking() {
		ordenarJugadores();
		System.out.println("Ranking de los 10 mejores jugadores:");
		int limite = Math.min(contador, 10);
		for (int i = 0; i < limite; i++) {
			System.out.println((i + 1) + ". " + jugadores[i].getNombre() + ": " + jugadores[i].getPuntuacion());
		}
	}

	/**
	 * Muestra el jugador (o jugadores) con la puntuación más alta
	 */
	public void showBestPlayer() {
		ordenarJugadores();
		System.out.println("Mejor jugador:");
		int maxPuntuacion = jugadores[0].getPuntuacion(); // Variable que guarda al jugador de la posicion 0
		for (int i = 0; i < contador; i++) {
			if (jugadores[i].getPuntuacion() == maxPuntuacion) {
				System.out.println(jugadores[i].getNombre() + ": " + maxPuntuacion);
			} else {
				break; // Salir del bucle cuando ya no haya jugadores con la máxima puntuación
			}
		}
	}
	
	/**
	 * Metodo que ordena el array mediante el metodo de la burbuja
	 */
	private void ordenarJugadores() {
		for (int i = 0; i < contador; i++) {
			for (int j = 0; j < (contador - i - 1); j++) {
				if (jugadores[j].getPuntuacion() < jugadores[j + 1].getPuntuacion()) {
					persona temp = jugadores[j + 1];
					jugadores[j + 1] = jugadores[j];
					jugadores[j] = temp;
				}
			}
		}
	}
}
