package logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
public class Busqueda
{ 
 
	public Queue<Nodos> listado;
	public static ArrayList<Nodos> nodes=new ArrayList<Nodos>();
	public static class Nodos
	{
		int data;
		boolean visited;
		List<Nodos> Hijos;
 
		public Nodos(int data)
		{
			this.data=data;
			this.Hijos=new ArrayList<>();
 
		}
		public void AgregarHijo(Nodos NodoHijo)
		{
			this.Hijos.add(NodoHijo);
		}
		public List<Nodos> ObtenerHijo() {
			return Hijos;
		}
		public void ConfigurarHijo(List<Nodos> Hijos) {
			this.Hijos = Hijos;
		}
	}
 
	public Busqueda()
	{
		listado = new LinkedList<Nodos>();
	}
 
	public String Buscar(Nodos node)
	{
		listado.add(node);
                String ruta = "";
		node.visited = true;
		while (!listado.isEmpty())
		{
 
			Nodos element = listado.remove();
                        ruta = ruta + element.data + " - ";
			System.out.print(ruta + " - ");
			List<Nodos> Hijos = element.ObtenerHijo();
			for (int i = 0; i < Hijos.size(); i++) {
				Nodos n=Hijos.get(i);
				if(n != null && !n.visited)
				{
					listado.add(n);
					n.visited=true;
				}
			}
		}
            return ruta;
	}
}