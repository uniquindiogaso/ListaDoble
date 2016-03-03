import java.util.Iterator;

public class ListaDobleRun {
	
	public static void main(String[] args) {
		
		
		ListaDoble<Integer> lista = new ListaDoble<Integer>();
		 // -> x3 2 1 33 x4
		lista.insertarPrimero(1);
		lista.insertarPrimero(3);
		lista.insertarUltimo(4);
		//lista.insertarDespuesDe(6, 5);
		//lista.insertarDespuesDe(11, 20);
		
		lista.insertarAntesDe(2, 1);
		lista.insertarAntesDe(33, 4);
		
		lista.eliminarPrimero();
		lista.eliminarUltimo();
		
		lista.eliminar(1);
		
		lista.insertarDespuesDe(34, lista.obtenerUltimo());
		lista.insertarDespuesDe(35, lista.obtenerUltimo());
		lista.insertarDespuesDe(36, lista.obtenerUltimo());
		lista.insertarDespuesDe(37, lista.obtenerUltimo());
		lista.insertarDespuesDe(38, lista.obtenerUltimo());
		
		for(Integer i : lista){
			System.out.println(i);
		}
		
		System.out.println("----------------");
		
		Iterator<Integer> ie = lista.iteratorCuentaAtras();
		while(ie.hasNext()){
			System.out.println(ie.next());
		}
	}

}
