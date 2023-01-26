package fraccion;

/**
 * 
 * @author jperez
 * @version1.0
 * Esta clase nos permite definir una fraccion
 *
 */

// Clase que define una fracción
public class Fraccion {
	
	/**
	 * atributo que guardara el valor de Numerador
	 */
	
	// Numerador
	private int num;

	/**
	 * Atributo que guardara el valor de Denominador
	 */
	
	// Denominador
	private int den;

	// Constructor por defecto

	/**
	 * Constructor por defecto de nombre Fraccion
	 * que generara una fraccion de valor neutro 0/1
	 * asignando dichos valores a atributos num y den respectivamente
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		
		num = 0;
		den = 1;

	}

	/**
	 * constructor con parametros de entrada para crear una fraccion con dichos datos
	 * evitar usar fraciones con 0 en el divisor
	 * usa el metodo simplificar para devolver la fraccion simplificada
	 * @param num parametro de entrada cuyo valor se asigna a atributo num
	 * @param den parametro de entrada cuyo valor se asigna a atributo den
	 */
	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	
	/**
	 * constructor para copiar la fraccion
	 * @param f parametro de entrada cuyo valor se asigna a atributo num
	 * y a atributo den
	 */
	
	// Constructor copia
	
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * metodo para dar valor a atributo num 
	 * @param num parametro de entrada que cuyo valor se asignara a atributo num
	 */
	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	/**
	 * metodo para recoger valor actual de atributo num
	 * @return num retorno que devolvera valor actual de atributo num
	 */
	public int getNum() {
		return num;

	}

	/**
	 * metodo para dar valor a atributo den 
	 * @param den parametro de entrada que cuyo valor se asignara a atributo den
	 */
	public void setDen(int den) {
		this.den = den;
	}

	/**
	 * metodo para recoger el valor actual de atributo den
	 * @return den retorno que devolvera valor actual de atributo den
	 */
	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * metodo para calcular maximo comun divisor por metodo de Euclides
	 * donde doy a u valor absoluto del numerador
	 * y a v valor absoluto del denominador
	 * @return u retorno que devolvera el resultado del metodo
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	/**
	 * metodo para simplificar fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	// Método toString

	/**
	 * Metodo para insertar atributos num y den en un mensaje usanto variable tipo String
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	
	/**
	 * Metodo para sumar fracciones
	 * @param f parametro de entrada
	 * @return aux retorno que devolvera resultado del metodo
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	/**
	 * Metodo para restar fracciones
	 * @param f parametro de entrada
	 * @return aux retorno que devolvera resultado del metodo
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	/**
	 * metodo para multipicar fracciones
	 * @param f parametro de entrada
	 * @return aux retorno que devolvera resultado del metodo
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	/**
	 * metodo para dividir rfacciones
	 * @param f parametro de entrada
	 * @returnaxu retorno que devolvera resultado del metodo
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
