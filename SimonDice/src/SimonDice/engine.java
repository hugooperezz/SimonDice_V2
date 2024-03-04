package SimonDice;

import java.util.Random;
import java.util.Scanner;

public class engine {

	/**
	 * Metodo de colores
	 */
	public enum tColores {
		Rojo, Dorado, Verde, Azul, Blanco, Marron, Naranja
	}
	
	public enum tMode {
        FACIL, DIFICIL
    }

	static int MAX_COLORES_SEQ = 15;
	static int MAX_COLORES_SEQ_FACIL = 4;
	static int MAX_COLORES_SEQ_DIFICIL = 7;
	static int AYUDAS = 3;

	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * Metodo para asignar letras a Colores
	 * 
	 * @param _color
	 * @return
	 */
	public tColores charToColor(char _color) {
		tColores eleccion = null;
		char LetraColores = Character.toLowerCase(_color); // Para q no diferencie entre mayusculas y minusculas
		switch (LetraColores) {
		case 'r':
			eleccion = tColores.Rojo;
			break;
		case 'a':
			eleccion = tColores.Azul;
			break;
		case 'v':
			eleccion = tColores.Verde;
			break;
		case 'd':
			eleccion = tColores.Dorado;
			break;
		case 'b':
			eleccion = tColores.Blanco;
			break;
		case 'm':
			eleccion = tColores.Marron;
			break;
		case 'n':
			eleccion = tColores.Naranja;
			break;

		}
		return eleccion;

	}

	/**
	 * Metodo para relacionar los colores con numeros para el arrays
	 * 
	 * @param _numero
	 * @return
	 */
	public static tColores intToColor(int _numero) {
		tColores numeros = null;
		switch (_numero) {
		case 1:
			numeros = tColores.Rojo;
			break;
		case 2:
			numeros = tColores.Azul;
			break;
		case 3:
			numeros = tColores.Verde;
			break;
		case 4:
			numeros = tColores.Dorado;
			break;
		case 5:
			numeros = tColores.Blanco;
			break;
		case 6:
			numeros = tColores.Marron;
			break;
		case 7:
			numeros = tColores.Naranja;
			break;
		}
		return numeros;
	}

	/**
	 * Metodo para gererar una secuencia ramdon (FACIL)
	 * 
	 * @param _numColores
	 */
	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(1, _numColores);
			secuenciaColores[i] = intToColor(aleatorio);
		}
	}

	/**
	 * Metodo para mostrar el array
	 * 
	 * @param _numero
	 */
	void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}

	/**
	 * Metodo para comparar la secuencia y ver si a ganado o a perdido
	 * 
	 * @param _index
	 * @param _color
	 * @return
	 */
	boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;

	}

	/**
	 * Metodo para usar ayudas
	 * 
	 * @param _index
	 * @return
	 */
	boolean usarAyuda(int _index) {
		if (_index > 0) {
            _index--;
            return true;

        } else {
            System.out.println("No quedan ayudas disponibles.");
            return false;
        }
    }

	/*
	 * Metodo para que muestre el mensaje de biembenida al jugador
	 */
	public void inicio() {
		// Memsaje de biembenida
		System.out.println("Biembenido a Simon Dice");
		
		System.out.print("Introduce tu nombre: ");
		Scanner scNombre = new Scanner(System.in);
		String nombre = scNombre.nextLine();
		System.out.println("");
		System.out.println("Biembenido a Simon Dice " + nombre);

		menu();
	}

	/**
	 * Metodo para ejecutar un menu para jugar
	 */
	public void menu() {
		System.out.println("");
		System.out.println("Presiona-1 para salir");
		System.out.println("");
		System.out.println("Presiona-2 para jugar");

		Scanner menu = new Scanner(System.in);
		int _menu = menu.nextInt();

		// Introducir numeros para empezar a jugar
		if (_menu == 1) {
			System.out.println("Saliste del juego");
		} else if (_menu == 2) {
			play();
		}
	}

	/*
	 * Metodo para que se ejecute el programa
	 */
	public void play() {
		int puntuacion = 0;
		// Elegir el modo de juego
		System.out.println("");
		System.out.println("Presiona-1 para modo Facil");
		System.out.println("");
		System.out.println("Presiona-2 para modo Dificil");
		Scanner modo = new Scanner(System.in);
		int _modo = modo.nextInt();

		if (_modo == 1) {
			generarSecuencia(MAX_COLORES_SEQ_FACIL);
		} else if (_modo == 2) {
			generarSecuencia(MAX_COLORES_SEQ_DIFICIL);
		}

		// Comienzo del juego
		int i = 0;
		while (i < MAX_COLORES_SEQ) {
			System.out.println(" ");

			// Mostrar la secuencia
			if (_modo == 1) {
				mostrarSecuencia(MAX_COLORES_SEQ_FACIL + i);
			} else if (_modo == 2) {
				mostrarSecuencia(MAX_COLORES_SEQ_DIFICIL + i);

			}
			System.out.println("");

			// Limpiar la pantalla y pulsar el ENTER para introducir la secuencia
			System.out.println("Pulsa ENTER para comenzar");
			Scanner comenzar = new Scanner(System.in);
			String ENTER = comenzar.nextLine();
			if (ENTER.equals("")) {
				int j = 0;
				while (j < 30) {
					System.out.println();
					j++;
				}
			}

			// Introducir los colores y comprobar que estan bien
			System.out.println("Introduce los colores");

			int j = 0;
			while (j < MAX_COLORES_SEQ_DIFICIL + i) {

				char letraColor = new Scanner(System.in).next().charAt(0);
				tColores Color_Elegido = charToColor(letraColor);

				if (letraColor != 'x' && letraColor != 'X') {
					if (comprobarColor(j, Color_Elegido)) {
						System.out.println("Color correcto");
						puntuacion = +2;
					} else {
						System.out.println("Has fallado con " + puntuacion + " puntos");
						menu();
						break;
					}
				} else {
					usarAyuda(3);
					if (usarAyuda(3) == true) {

						System.out.println("El color es " + secuenciaColores[j]);
					} else {
						System.out.println("No te quedan ayudas");
					}
				}
				j++;
			}
			i++;
		}
	}
}
