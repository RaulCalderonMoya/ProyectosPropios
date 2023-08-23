import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FramePrincipal extends JFrame {
	private boolean pulsacionArriba = false;
	private boolean pulsacionAbajo = false;
	private boolean pulsacionDerecha = false;
	private boolean pulsacionIzquierda = false;

	// private int posX = 0;
	// private int posY = 0;

	private int valorX;
	private int valorY;

	private boolean saleLimitesXDer = false;
	private boolean saleLimitesYArr = false;
	private boolean saleLimitesXIzq = false;
	private boolean saleLimitesYBaj = false;

	// private boolean cambioColor = false;

	private JLabel[][] posiciones;

	public FramePrincipal() {
		setTitle("Juego de la serpiente");
		setSize(500, 500);
		
		getContentPane().setBackground(Color.WHITE);

		// Pulsacion de teclas
		addKeyListener(new pulsacionTeclas());
		creacionMatriz();
		cambioColor();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void cambioColor() {
		// TODO Auto-generated method stub
		// Ponemos un valor inicial al cuadro en las posiciones de la matriz al inicio
		// Funcionamiento: Coloca y pinta al iniciar el juego una de las posiciones de
		// la matriz
		Random r = new Random();

		valorX = r.nextInt(10);
		valorY = r.nextInt(10);

		Color targetColor = Color.GREEN;
		posiciones[valorX][valorY].setOpaque(true);
		posiciones[valorX][valorY].setBackground(targetColor);
	}

	private void creacionMatriz() {
		// Funcionamiento: Crea una matriz de 100 posiciones que posee 10 filas y 10
		// columnas
		int tamX = 10; // 10 filas
		int tamY = 10; // 10 columnas

		setLayout(new GridLayout(tamY, tamX));

		posiciones = new JLabel[tamX][tamY];

		for (int j = 0; j < tamY; j++) {
			for (int i = 0; i < tamX; i++) {
				posiciones[i][j] = new JLabel("");
				add(posiciones[i][j]);
			}
		}
	}

	public class pulsacionTeclas extends KeyAdapter {
		// Funcionamiento: Gestiona la pulsacion de teclas para dar un comportamiento
		// determinado
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				//System.out.println("Ha pulsado la tecla arriba");
				pulsacionArriba = true;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				//System.out.println("Ha pulsado la tecla abajo");
				pulsacionAbajo = true;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				//System.out.println("Ha pulsado la tecla derecha");
				pulsacionDerecha = true;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				//System.out.println("Ha pulsado la tecla izquierda");
				pulsacionIzquierda = true;
			}

			controladorPulsaciones();
		}

	}

	public void controladorPulsaciones() {
		// Funcionamiento : Pone a false los valores booleanos creados previamente
		if (pulsacionArriba) {
			// Aumentamos en uno el valor de los cuadros
			// Aunque parezca raro en este caso el (0,0) es el borde superior izquierdo
			// con lo cual para subir debemos hacer valorY--
			valorY--;
			// Una vez aumentado el valor se actualiza la posicion que se ilumina y la
			// anterior ya no se ilumnia
			Color targetColor = Color.GREEN;
			// Debo comprobar que se encuentra en la matriz de lo contrario petara
			comprobarPosicionCorrecta(valorX, valorY);
			if(saleLimitesYArr) {
				
				valorY = valorY + 10;

				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX][valorY -9].setOpaque(true);
				posiciones[valorX][valorY -9].setBackground(colorGris);
				
			}else {
				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX][valorY + 1].setOpaque(true);
				posiciones[valorX][valorY + 1].setBackground(colorGris);
			}


			pulsacionArriba = false;
			saleLimitesYArr = false;

		} else if (pulsacionAbajo) {

			valorY++;
			// Una vez aumentado el valor se actualiza la posicion que se ilumina y la
			// anterior ya no se ilumnia
			Color targetColor = Color.GREEN;
			comprobarPosicionCorrecta(valorX, valorY);

			if (saleLimitesYBaj) {
				valorY = valorY - 10;

				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX][valorY +9].setOpaque(true);
				posiciones[valorX][valorY +9].setBackground(colorGris);

			} else {
				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX][valorY - 1].setOpaque(true);
				posiciones[valorX][valorY - 1].setBackground(colorGris);
			}

			pulsacionAbajo = false;
			saleLimitesYBaj = false;
		} else if (pulsacionDerecha) {
			valorX++;

			// Una vez aumentado el valor se actualiza la posicion que se ilumina y la
			// anterior ya no se ilumnia
			Color targetColor = Color.GREEN;
			comprobarPosicionCorrecta(valorX, valorY);
			if (saleLimitesXDer) {
				valorX = valorX - (10);

				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX + 9][valorY].setOpaque(true);
				posiciones[valorX + 9][valorY].setBackground(colorGris);

			} else {

				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX - 1][valorY].setOpaque(true);
				posiciones[valorX - 1][valorY].setBackground(colorGris);
			}
//			posiciones[valorX][valorY].setOpaque(true); 
//		    posiciones[valorX][valorY].setBackground(targetColor);
//			
//			Color colorGris = Color.WHITE;
//			posiciones[valorX-1][valorY].setOpaque(true); 
//		    posiciones[valorX-1][valorY].setBackground(colorGris);

			pulsacionDerecha = false;
			saleLimitesXDer = false;
		} else if (pulsacionIzquierda) {

			valorX--;
			// Una vez aumentado el valor se actualiza la posicion que se ilumina y la
			// anterior ya no se ilumnia
			Color targetColor = Color.GREEN;
			comprobarPosicionCorrecta(valorX, valorY);

			if (saleLimitesXIzq) {
				valorX = valorX + (10);

				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX - 9][valorY].setOpaque(true);
				posiciones[valorX - 9][valorY].setBackground(colorGris);

			} else {
				posiciones[valorX][valorY].setOpaque(true);
				posiciones[valorX][valorY].setBackground(targetColor);

				Color colorGris = Color.WHITE;
				posiciones[valorX + 1][valorY].setOpaque(true);
				posiciones[valorX + 1][valorY].setBackground(colorGris);
			}

			pulsacionIzquierda = false;
			saleLimitesXIzq = false;
		}
	}

	private void comprobarPosicionCorrecta(int valorX, int valorY) {
		// TODO Auto-generated method stub

		// Primero comprobamos el eje X
		// Va desde 0 a 9 las posiciones no de 1 a 10 --> IMPORTANTE
		if (valorX < 0) {
			saleLimitesXIzq = true;
		} else if (valorX > 9) {
			saleLimitesXDer = true;
		} else if (valorY < 0) {
			saleLimitesYArr = true;
		} else if (valorY > 9) {
			saleLimitesYBaj = true;
		}

	}

}
