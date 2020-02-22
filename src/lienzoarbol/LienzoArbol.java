package lienzoarbol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.Arbol;
import logica.Busqueda;

/**
 *
 * @author daniel
 */
public class LienzoArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //PATRON MVC
        Arbol objArbol = new Arbol(); //MODELO
        Lienzo objLienzo = new Lienzo(); //VISTA
        Controlador objControlador = new Controlador(objLienzo, objArbol); //CONTROLADOR
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //INSERTAR Y PINTAR ARBOL
        objArbol.insertar(7);
        objArbol.insertar(2);
        objArbol.insertar(9);
        objArbol.insertar(5);
        objArbol.insertar(4 );
        objArbol.insertar(10);
        objControlador.iniciar();
        Busqueda.Nodos nodo1 =new Busqueda.Nodos(7);
	Busqueda.Nodos nodo2 =new Busqueda.Nodos(2);
	Busqueda.Nodos nodo3 =new Busqueda.Nodos(9);
	Busqueda.Nodos nodo4 =new Busqueda.Nodos(5);
	Busqueda.Nodos nodo5 =new Busqueda.Nodos(10);
	Busqueda.Nodos nodo6 =new Busqueda.Nodos(4);
        nodo1.AgregarHijo(nodo2);
	nodo1.AgregarHijo(nodo3);
	nodo2.AgregarHijo(nodo4);
	nodo3.AgregarHijo(nodo5);
	nodo4.AgregarHijo(nodo6);
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR LIENZO EN UNA VENTANA TODO
        JFrame ventana = new JFrame();
        JLabel lblBuscar = new JLabel("Ingresar Valor");
        lblBuscar.setBounds(10, 10, 150, 20);
        ventana.add(lblBuscar);
        
        
        JLabel lblRespuesta = new JLabel("**********");
        lblRespuesta.setBounds(10, 30, 250, 20);
        ventana.add(lblRespuesta);
       
        JTextField txtBuscar;
        txtBuscar = new JTextField();
	txtBuscar.setBounds(105, 10, 25, 20);
	txtBuscar.setText(" ");
        ventana.add(txtBuscar);
	JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(121, 440, 89, 20);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscar.setText("");
			}
		});
		ventana.add(btnLimpiar);
                
	JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(222, 440, 89, 20);
        btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
                ventana.add(btnSalir);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(20, 440, 89, 20);
        btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    if( txtBuscar.getText().equals(" ") ) {
JOptionPane.showMessageDialog(null,"El campo no puede estar vacio","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
              JOptionPane.showMessageDialog(null, "Realizando Busqueda.\n"); 
              Busqueda BusquedaPorAnchura = new Busqueda();
              switch(Integer.parseInt(txtBuscar.getText().trim())) {
                  case 7:
                      lblRespuesta.setText(BusquedaPorAnchura.Buscar(nodo1));
                      break;
                  case 2:
                      lblRespuesta.setText(BusquedaPorAnchura.Buscar(nodo2));
                      break;
                  case 9:
                      lblRespuesta.setText(BusquedaPorAnchura.Buscar(nodo3));
                      break;
                  case 5:
                      lblRespuesta.setText(BusquedaPorAnchura.Buscar(nodo4));
                      break;
                  case 4:
                      lblRespuesta.setText(BusquedaPorAnchura.Buscar(nodo5));
                      break;
                  case 10:
                      lblRespuesta.setText(BusquedaPorAnchura.Buscar(nodo6));
                      break;
              }
              }
       
				
			}
		});
        ventana.add(btnBuscar);
        ventana.getContentPane().add(objLienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
    }
}