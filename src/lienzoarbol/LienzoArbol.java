/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lienzoarbol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.Arbol;

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
              
              lblRespuesta.setText("Estoy modificando el texto");
  
              }
       
				
			}
		});
        ventana.add(btnBuscar);
        
        
        
        ventana.getContentPane().add(objLienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    
    }
 
        
}
