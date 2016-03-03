import java.util.Iterator;

public class ListaDoble<T> implements Iterable<T>{

	private Nodo<T> cabeza;
	private Nodo<T> cola;

	private int tamano;

	public ListaDoble() {
		this.cabeza = null;
		this.cola = null;
		this.tamano = 0;
	}

	public boolean estaVacia() {
		return this.cabeza == null;
	}

	public void insertarPrimero(T dato) {
		Nodo<T> nuevoNodo;
		if (estaVacia()) {
			nuevoNodo = new Nodo<T>(dato);
			cabeza = cola = nuevoNodo;
		} else {

			// El Siguiente sera el que antes era cabeza
			nuevoNodo = new Nodo<T>(dato, cabeza);

			cabeza.setAnterior(nuevoNodo);

			if (cabeza.getSiguiente() == null) {
				cola = cabeza;
			}

			// El nuevo cabeza es el Nodo a Insertar
			cabeza = nuevoNodo;

		}

		tamano++;
	}

	public void insertarUltimo(T dato) {
		Nodo<T> nuevoNodo;
		if (estaVacia()) {
			nuevoNodo = new Nodo<T>(dato);
			cabeza = cola = nuevoNodo;
		} else {
			nuevoNodo = new Nodo<T>(dato, null, cola);
			cola.setSiguiente(nuevoNodo);
			cola = nuevoNodo;
		}

		tamano++;
	}

	public void insertarDespuesDe(T dato, T datoSiguiente) {
		Nodo<T> nodoBase = buscar(datoSiguiente);
		if (nodoBase != null) {
			// Si el dato siguiente es el ultimo
			if (nodoBase.getSiguiente() == null) {
				insertarUltimo(dato);
			} else {
				Nodo<T> nuevoNodo = new Nodo<T>(dato, nodoBase.getSiguiente());
				nodoBase.getSiguiente().setAnterior(nuevoNodo);
				nodoBase.setSiguiente(nuevoNodo);
			}
			tamano++;
		}
	}

	public void insertarAntesDe(T dato, T datoAnterior) {
		Nodo<T> nodoBase = buscar(datoAnterior);
		if (nodoBase != null) {
			// Si el nodo es la cabeza
			if (nodoBase.getAnterior() == null) {
				insertarPrimero(dato);
			} else {
				Nodo<T> nodoAnterior = nodoBase.getAnterior();
				Nodo<T> nuevoNodo = new Nodo<T>(dato, nodoBase);
				nodoAnterior.setSiguiente(nuevoNodo);
				nuevoNodo.setAnterior(nodoAnterior);
				nodoBase.setAnterior(nuevoNodo);
			}

			tamano++;
		}
	}

	public void eliminarTodo() {
		cabeza = cola = null;
		tamano = 0;
	}

	public void eliminarPrimero() {
		if (!estaVacia()) {
			// Si ambos son iguales , debe existir un solo elemento
			if (cabeza == cola) {
				eliminarTodo();
			} else {
				cabeza = cabeza.getSiguiente();
				cabeza.setAnterior(null);
				tamano--;
			}

		}
	}

	public void eliminarUltimo() {
		if (!estaVacia()) {
			// Si ambos son iguales , debe existir un solo elemento
			if (cabeza == cola) {
				eliminarTodo();
			} else {
				Nodo<T> nuevoUltimo = cola.getAnterior();
				cola = nuevoUltimo;
				cola.setSiguiente(null);
				tamano--;
			}
		}
	}

	public void eliminar(T dato) {
		Nodo<T> nodoEliminar = buscar(dato);
		if (nodoEliminar != null) {
			if (nodoEliminar == cabeza) {
				eliminarPrimero();
			} else if (nodoEliminar == cola) {
				eliminarUltimo();
			} else {
				nodoEliminar.getAnterior().setSiguiente(nodoEliminar.getSiguiente());
				nodoEliminar.getSiguiente().setAnterior(nodoEliminar.getAnterior());
				tamano--;
			}

		}
	}

	public Nodo<T> buscar(T dato) {
		Nodo<T> nodoEncontrado = null;
		if (!estaVacia()) {

			Nodo<T> nodoTemporal = cabeza;

			while (nodoTemporal != null) {
				if (dato == nodoTemporal.getDato()) {
					nodoEncontrado = nodoTemporal;
					break;
				}
				nodoTemporal = nodoTemporal.getSiguiente();
			}

		}

		return nodoEncontrado;
	}

	public T obtenerPrimero() {
		return cabeza.getDato();
	}

	public T obtenerUltimo() {
		return cola.getDato();
	}
	


	/**
	 * Método que obtiene el valor
	 * 
	 * @return tamano
	 */
	public int getTamano() {
		return tamano;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorCuentaAdelante(cabeza);
	}
	

	public Iterator<T> iteratorCuentaAtras() {
		return new IteradorCuentaAtras(cola);
	}
	
	class IteradorCuentaAdelante implements Iterator<T>{
		
		protected Nodo cabeza;
		protected Nodo actual;
		protected int posicion;
		
		public IteradorCuentaAdelante(Nodo cabeza){
			this.cabeza = this.actual = cabeza;
			this.posicion = 0;
		}

		@Override
		public boolean hasNext() {			
			return actual != null;
		}

		@Override
		public T next() {
			T dato = (T) actual.getDato();
			actual = actual.getSiguiente();
			posicion++;
			return dato;
		}
		
		public int getPosicion() {
			return posicion;
		}
		
	}
	
	class IteradorCuentaAtras implements Iterator<T>{

		protected Nodo cola;
		protected Nodo actual;
		protected int posicion;
		
		public IteradorCuentaAtras(Nodo cola){
			this.cola = actual = cola;	
			posicion = getTamano();
		}
		
		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			T dato = (T)actual.getDato();
			actual = actual.getAnterior();
			posicion--;
			return dato;
		}
		
	}

}
