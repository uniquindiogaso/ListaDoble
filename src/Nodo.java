
public class Nodo<T> {

	//Dato a almacenar en estructura
	private T dato;
	//Referencia a posicion siguiente dentro de estructura
	private Nodo<T> siguiente;
	//Referencia a posicion anterior dentro de la estructura
	private Nodo<T> anterior;
	
	/**
	 * Constructor de Nodo
	 */
	public Nodo(){
		this.dato = null;
		this.siguiente = null;
		this.anterior = null;
	}
	
	/**
	 * Constructor de Nodo
	 * @param dato dato a almacenar
	 */
	public Nodo(T dato){
		this.dato = dato;
		this.siguiente = null;
		this.anterior = null;
	}
	
	/**
	 * Constructor de Nodo
	 * @param dato dato a almacenar
	 * @param siguiente posicion siguiente a donde estara el dato
	 */
	public Nodo(T dato, Nodo<T> siguiente){
		this.setDato(dato);
		this.setSiguiente(siguiente);
		this.anterior = null;
	}
	
	/**
	 * Constructor de Nodo
	 * @param dato dato a almacenar
	 * @param siguiente posicion siguiente a donde estara el dato
	 * @param anterior posicion anterior donde estara el dato
	 */
	public Nodo(T dato, Nodo<T> siguiente, Nodo<T> anterior){
		this.dato = dato;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}

	/**
	 * Retornar Dato
	 * @return dato tipo generic
	 */
	public T getDato() {
		return dato;
	}
	/**
	 * Asignar valor a dato
	 * @param dato Valor a asignar
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Obtener Nodo Siguiente
	 * @return nodo
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * 
	 * @param siguiente
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
	
	/**
	 * Obtener Nodo Anterior
	 * @return generics nodo
	 */
	public Nodo<T> getAnterior() {
		return anterior;
	}
	/**
	 * Asignar valor al Nodo Anterior
	 * @param anterior Valor para el nodo anterior
	 */
	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		return dato.toString();
	}
	

}
